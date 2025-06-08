package connect4.views.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import connect4.controllers.PlayController;
import utils.models.Coordinate;

public class UserPlayerBoardView extends BoardView implements ActionListener {

    public UserPlayerBoardView(PlayController playController, PanelViewCommand callback) {
        super(playController, callback);
    }

    @Override
    protected Square createSquare(Coordinate coordiante) {
        assert (coordiante != null);
        ImageIcon icon = this.getColors().get(this.getPlayController().getColor(coordiante));
        ClickableSquare square = new ClickableSquare(icon, coordiante);
        square.addActionListener(this);
        return square;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClickableSquare square = (ClickableSquare) e.getSource();
        int column = square.getColumn();
        this.getPlayController().dropToken(column);
        write();
        if (!this.getPlayController().isFinished()) {
            this.getPlayController().next();
        }
        this.getNextTurnCommand().execute();
    }

    public void accept(PlayPanelViewVisitor playPanelView) {
        playPanelView.visit(this);
    }
}
