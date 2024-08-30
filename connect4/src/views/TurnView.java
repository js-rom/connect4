package views;

import models.Game;
import models.RandomMachinePlayer;
import models.UserPlayer;
import utils.Console;

public class TurnView {
    private Game game;

    TurnView(Game game) {
        this.game = game;
    }

    public void resetPlayers(){
        int userPlayers = Console.getInstance().readInt(Message.NUM_PLAYERS.toString());
        this.game.reset(userPlayers);
    }

    public void dropToken(){
        this.game.getActivePlayer().accept(this);
        this.game.next();
    }

    public void visit(UserPlayer userPlayer){
        new UserPlayerView(userPlayer).dropToken();
    }

    public void visit(RandomMachinePlayer randomMachinePlayer){
        new MachinePlayerView(randomMachinePlayer).dropToken();
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
