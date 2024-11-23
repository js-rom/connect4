package connect4.views.console;

import connect4.controllers.PlayController;
import connect4.controllers.StartController;
import connect4.models.Turn;
import connect4.views.console.menus.TurnMenu;
import utils.views.Console;

public class TurnView {

    private StartController startController;
    private PlayController playController;
    private PlayerViewPrototypeRegistry playerViewPrototypeRegistry;

    TurnView(PlayController playController, PlayerViewPrototypeRegistry playerViewPrototypeRegistry) {
        assert playController != null;
        assert playerViewPrototypeRegistry != null;
        this.playController = playController;
        this.playerViewPrototypeRegistry = playerViewPrototypeRegistry;
    }

    TurnView(StartController startController) {
        this.startController = startController;
    }

    TurnView(PlayController playController) {
        this(playController, new PlayerViewPrototypeRegistry());
    }

    public void selectPlayers() {
        new TurnMenu(this.startController, Turn.NUMBER_PLAYERS).interact();
    }

    public void dropToken() {
        assert !this.playController.isFinished();
        PlayerView playerView = new PlayerViewPrototypeDirector().get(this.playerViewPrototypeRegistry,
                this.playController.getActivePlayerType());
        playerView.setPlayer(this.playController.getActivePlayer());
        Message.TURN.write();
        Console.getInstance().writeln(this.playController.getActivePlayer().getColor().toString());
        playerView.dropToken();
        if (!this.playController.isFinished()) {
            this.playController.next();
        }

    }

    public void writeResult() {
        if (this.playController.isWinner()) {
            String message = Message.PLAYER_WIN.toString();
            message = message.replace("#color", this.playController.getActiveColor().toString());
            Console.getInstance().writeln(message);
        } else {
            Message.PLAYERS_TIED.writeln();
        }
    }

}
