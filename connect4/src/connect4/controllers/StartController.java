package connect4.controllers;

import connect4.models.Game;
import connect4.models.Turn;

public class StartController extends Controller {

    public StartController(Game game) {
        super(game);
    }

    public void reset() {
        this.game.reset();
    }

    public Turn getTurn() {
        return this.game.getTurn();
    }

}
