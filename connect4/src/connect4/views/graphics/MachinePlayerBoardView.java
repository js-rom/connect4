package connect4.views.graphics;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import connect4.controllers.Logic;
import utils.models.Coordinate;

public class MachinePlayerBoardView extends PlayerBoardView {

    public MachinePlayerBoardView(Logic logic, PanelViewCommand callback) {
        super(logic, callback);
    }

    @Override
    protected Square createSquare(Coordinate coordiante) {
        ImageIcon icon = this.getColors().get(this.getLogic().getColor(coordiante));
        NonClickableSquare square = new NonClickableSquare(icon, coordiante);
        return square;
    }

    public void dropToken() {
        int delay = 1000;
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getLogic().dropToken(getLogic().getColumn());
                write();
                if (!getLogic().isFinished()) {
                    getLogic().next();
                }
                getCallback().execute();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void accept(PlayPanelViewVisitor playPanelView) {
        playPanelView.visit(this);
    }

}
