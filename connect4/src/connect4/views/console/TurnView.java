package connect4.views.console;

import connect4.controllers.Logic;
import connect4.controllers.PlayController;
import connect4.controllers.StartController;
import connect4.models.Turn;
import connect4.views.console.menus.TurnMenu;
import utils.views.Console;

public class TurnView {

    private PlayerViewPrototypeRegistry playerViewPrototypeRegistry;

    TurnView() {
         this.playerViewPrototypeRegistry = new PlayerViewPrototypeRegistry();
    }


    public void selectPlayers(StartController startController) {
        new TurnMenu(startController, startController.getNumberPlayers()).interact();
    }

    public void dropToken(PlayController playController) {
        assert !playController.isFinished();
        PlayerView playerView = new PlayerViewPrototypeDirector().get(this.playerViewPrototypeRegistry,
                playController.getActivePlayerType());
        playerView.setPlayer(playController.getActivePlayer());
        Message.TURN.write();
        Console.getInstance().writeln(playController.getActiveColor().toString());
        playerView.dropToken();
        if (!playController.isFinished()) {
            playController.next();
        }

    }

    public void writeResult(PlayController playController) {
        if (playController.isWinner()) {
            String message = Message.PLAYER_WIN.toString();
            message = message.replace("#color", playController.getActiveColor().toString());
            Console.getInstance().writeln(message);
        } else {
            Message.PLAYERS_TIED.writeln();
        }
    }

}
