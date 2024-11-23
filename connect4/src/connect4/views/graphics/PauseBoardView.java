package connect4.views.graphics;

import javax.swing.ImageIcon;
import connect4.controllers.PlayController;
import utils.models.Coordinate;

public class PauseBoardView extends BoardView {

    public PauseBoardView(PlayController playController) {
        super(playController);
    }

    @Override
    protected Square createSquare(Coordinate coordiante) {
        ImageIcon icon = this.getColors().get(this.playController.getColor(coordiante));
        NonClickableSquare square = new NonClickableSquare(icon, coordiante);
        return square;
    }

    @Override
    public void accept(PlayPanelViewVisitor playPanelView) {
        playPanelView.visit(this);
    }

}
