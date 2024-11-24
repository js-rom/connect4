package connect4.views.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import connect4.controllers.Logic;
import utils.models.Coordinate;

public class UserPlayerBoardView extends PlayerBoardView implements ActionListener {

    public UserPlayerBoardView(Logic logic, PanelViewCommand callback) {
        super(logic, callback);
    }

    @Override
    protected Square createSquare(Coordinate coordiante) {
        assert (coordiante != null);
        ImageIcon icon = this.getColors().get(this.getLogic().getColor(coordiante));
        ClickableSquare square = new ClickableSquare(icon, coordiante);
        square.addActionListener(this);
        return square;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClickableSquare square = (ClickableSquare) e.getSource();
        int column = square.getColumn();
        this.getLogic().dropToken(column);
        write();
        if (!this.getLogic().isFinished()) {
            this.getLogic().next();
        }
        this.getCallback().execute();
    }

    public void accept(PlayPanelViewVisitor playPanelView) {
        playPanelView.visit(this);
    }
}
