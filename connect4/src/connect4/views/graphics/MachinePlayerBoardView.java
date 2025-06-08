package connect4.views.graphics;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import connect4.controllers.PlayController;
import utils.models.Coordinate;

public class MachinePlayerBoardView extends BoardView {

    public MachinePlayerBoardView(PlayController playController, PanelViewCommand callback) {
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
        Timer timer = new Timer(delay, new ActionListener() {
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
        timer.setRepeats(false);
        timer.start();
    }

    public void accept(PlayPanelViewVisitor playPanelView) {
        playPanelView.visit(this);
    }

}
