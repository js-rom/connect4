package connect4.views;

import connect4.models.Game;
import connect4.models.Player;
import connect4.models.Turn;
import connect4.types.PlayerType;
import utils.Console;
import connect4.views.menus.TurnMenu;

public class TurnView  {
    private Game game;

    TurnView(Game game) {
        this.game = game;
    }

    public void resetPlayers() {
        this.game.reset();
        new TurnMenu(this.game.getTurn(), Turn.NUMBER_PLAYERS).interact();
    }

    public void dropToken() {
        assert !this.game.isFinished();

        PlayerViewPrototypeRegistry playerViewRegistry = new PlayerViewPrototypeRegistry(); //crear vista sin player
        Player activePlayer =  this.game.getActivePlayer();
        PlayerType playerType =  activePlayer.getType();
        PlayerView playerView = new PlayerViewPrototypeDirector().get(playerViewRegistry, playerType);
        playerView.setPlayer(activePlayer);  // setear player a la vista antes de usarla
        Message.TURN.write();
        Console.getInstance().writeln(activePlayer.getColor().toString());
        playerView.dropToken();
        if (!this.game.isFinished()) {
            this.game.next();
        }

    }

    public void writeResult() {
        if (this.game.isWinner()) {
            String message = Message.PLAYER_WIN.toString();
            message = message.replace("#color", this.game.getActiveColor().toString());
            Console.getInstance().writeln(message);
        } else {
            Message.PLAYERS_TIED.writeln();
        }
    }

}
