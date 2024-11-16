package connect4.views.graphics;

import javax.swing.ImageIcon;

import connect4.models.Game;
import connect4.views.graphics.commands.Command;
import utils.models.Coordinate;

public class PauseBoardView extends BoardView {

    public PauseBoardView(Game game, Command callback) {
        super(game, callback);
    }

    @Override
    protected Square createSquare(ImageIcon icon, Coordinate coordiante) {
        NonClickableSquare square = new NonClickableSquare(icon, coordiante);
        return square;
    }

    @Override
    public BoardView copy() {
        Game game = this.getGame();
        Command callback = this.getCallback();
        return new PauseBoardView(game, callback);
    }

}
