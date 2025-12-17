package connect4.views.graphics.gameLoop.play.panel.board;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import connect4.controllers.core.PlayController;
import connect4.views.graphics.gameLoop.play.panel.commands.Command;
import utils.models.Coordinate;

public class MachinePlayerBoardView extends BoardView {

    private Timer timer;

    public MachinePlayerBoardView(PlayController playController, Command callback) {
        super(playController, callback);
    }

    @Override
    protected Square createSquare(Coordinate coordiante) {
        ImageIcon icon = this.getColors().get(this.getPlayController().getColor(coordiante));
        NonClickableSquare square = new NonClickableSquare(icon, coordiante);
        return square;
    }

    public void dropToken() {
        int delay = 1000;
        this.timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getPlayController().dropToken(getPlayController().getColumn());
                write();
                if (!getPlayController().isFinished()) {
                    getPlayController().next();
                }
                getNextTurnCommand().execute();
            }
        });
        this.timer.setRepeats(false);
        this.timer.start();
    }

    public void interruptDropToken() {
        assert (this.timer != null && timer.isRunning());
        this.timer.stop();
    }

    public void accept(BoardVisitor playPanelView) {
        playPanelView.visit(this);
    }

}
