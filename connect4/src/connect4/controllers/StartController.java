package connect4.controllers;

import connect4.models.Game;
import connect4.types.PlayerType;

public class StartController extends Controller {

    public StartController(Game game) {

        super(game);

    }

    public void reset() {

        this.game.reset();

    }

    public boolean isReset() {

        return this.game.isReset();

    }

    public void addPlayer(PlayerType playerType) {

        this.game.addPlayer(playerType);

    }

}
