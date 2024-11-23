package connect4.controllers;

import connect4.models.Game;

public class ResumeController extends Controller {

    public ResumeController(Game game) {
        super(game);
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public void reset() {
        this.game.reset();
    }
}
