package views;

import models.Game;
import models.MinMaxMachinePlayer;
import models.PlayerVisitor;
import models.RandomMachinePlayer;
import models.Turn;
import models.UserPlayer;
import utils.Console;
import views.menus.TurnMenu;

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
