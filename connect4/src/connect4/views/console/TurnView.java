package connect4.views.console;

import connect4.controllers.Logic;
import connect4.controllers.PlayController;
import connect4.models.Turn;
import connect4.views.console.menus.TurnMenu;
import utils.views.Console;

public class TurnView {

    private Logic logic;
    private PlayerViewPrototypeRegistry playerViewPrototypeRegistry;

    TurnView(Logic logic, PlayerViewPrototypeRegistry playerViewPrototypeRegistry) {
        assert logic != null;
        assert playerViewPrototypeRegistry != null;
        this.logic = logic;
        this.playerViewPrototypeRegistry = playerViewPrototypeRegistry;
    }

    TurnView(Logic logic) {
        this(logic, new PlayerViewPrototypeRegistry());
        //this.logic = logic;
    }

 /*    TurnView(PlayController playController) {
        this(playController, new PlayerViewPrototypeRegistry());
    } */

    public void selectPlayers() {
        new TurnMenu(this.logic, Turn.NUMBER_PLAYERS).interact();
    }

    public void dropToken() {
        assert !this.logic.isFinished();
        PlayerView playerView = new PlayerViewPrototypeDirector().get(this.playerViewPrototypeRegistry,
                this.logic.getActivePlayerType());
        playerView.setPlayer(this.logic.getActivePlayer());
        Message.TURN.write();
        Console.getInstance().writeln(this.logic.getActiveColor().toString());
        playerView.dropToken();
        if (!this.logic.isFinished()) {
            this.logic.next();
        }

    }

    public void writeResult() {
        if (this.logic.isWinner()) {
            String message = Message.PLAYER_WIN.toString();
            message = message.replace("#color", this.logic.getActiveColor().toString());
            Console.getInstance().writeln(message);
        } else {
            Message.PLAYERS_TIED.writeln();
        }
    }

}
