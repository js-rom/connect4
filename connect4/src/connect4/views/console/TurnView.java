package connect4.views.console;

import connect4.models.Game;
import connect4.models.Player;
import connect4.models.Turn;
import connect4.types.PlayerType;
import connect4.views.console.menus.TurnMenu;
import utils.views.Console;

public class TurnView  {
    private Game game;
    private PlayerViewPrototypeRegistry playerViewPrototypeRegistry;

    TurnView(Game game, PlayerViewPrototypeRegistry playerViewPrototypeRegistry) {
        this.game = game;
        this.playerViewPrototypeRegistry = playerViewPrototypeRegistry;
    }

    TurnView(Game game) {
        this(game, new PlayerViewPrototypeRegistry());
    }

    public void resetPlayers() {
        assert this.game != null;
        this.game.reset();
        new TurnMenu(this.game.getTurn(), Turn.NUMBER_PLAYERS).interact();
    }

    public void dropToken() {
        assert !this.game.isFinished();

        Player activePlayer =  this.game.getActivePlayer();
        PlayerType playerType =  activePlayer.getType();
        PlayerView playerView = new PlayerViewPrototypeDirector().get(this.playerViewPrototypeRegistry, playerType);
        playerView.setPlayer(activePlayer);
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
