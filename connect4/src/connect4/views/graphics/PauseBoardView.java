package connect4.views.graphics;

import javax.swing.ImageIcon;
import connect4.controllers.Logic;
import utils.models.Coordinate;

public class PauseBoardView extends BoardView {

    public PauseBoardView(Logic logic) {
        super(logic);
    }

    @Override
    protected Square createSquare(Coordinate coordiante) {
        ImageIcon icon = this.getColors().get(this.logic.getColor(coordiante));
        NonClickableSquare square = new NonClickableSquare(icon, coordiante);
        return square;
    }

    @Override
    public void accept(PlayPanelViewVisitor playPanelView) {
        playPanelView.visit(this);
    }

}
