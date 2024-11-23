package connect4.controllers;

import connect4.models.Game;
import connect4.models.Player;
import connect4.types.Color;
import utils.models.Coordinate;

public class ResumeController extends Controller {

    public ResumeController(Game game) {
        super(game);
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public Player getActivePlayer() {
        return this.game.getActivePlayer();
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }
}
