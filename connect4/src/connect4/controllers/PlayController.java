package connect4.controllers;

import connect4.models.Game;
import connect4.models.Player;
import connect4.types.Color;
import utils.models.Coordinate;

public class PlayController extends Controller {

    public PlayController(Game game) {
        super(game);
    }

    public Player getActivePlayer() {
        return this.game.getActivePlayer();
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    public boolean isFinished() {
        return this.game.isFinished();
    }

    public void next() {
        this.game.next();
    }
}
