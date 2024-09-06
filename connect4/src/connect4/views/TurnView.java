package connect4.views;

import connect4.models.Game;
import connect4.models.MinMaxMachinePlayer;
import connect4.models.PlayerVisitor;
import connect4.models.RandomMachinePlayer;
import connect4.models.Turn;
import connect4.models.UserPlayer;
import utils.Console;
import connect4.views.menus.TurnMenu;

public class TurnView implements PlayerVisitor {
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

        this.game.getActivePlayer().accept(this);
        if (!this.game.isFinished()) {
            this.game.next();
        }

    }

    public void visit(UserPlayer userPlayer) {
        assert userPlayer != null;

        new UserPlayerView(userPlayer).dropToken();
    }

    public void visit(RandomMachinePlayer randomMachinePlayer) {
        assert randomMachinePlayer != null;
        
        new RandomMachinePlayerView(randomMachinePlayer).dropToken();
    }

    public void visit(MinMaxMachinePlayer minMaxMachinePlayer) {
        assert minMaxMachinePlayer != null;
        
        new MinMaxMachinePlayerView(minMaxMachinePlayer).dropToken();
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
