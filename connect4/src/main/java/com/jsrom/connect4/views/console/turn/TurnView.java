package com.jsrom.connect4.views.console.turn;

import com.jsrom.connect4.controllers.core.PlayController;
import com.jsrom.connect4.controllers.core.StartController;
import com.jsrom.connect4.views.console.shared.Message;
import com.jsrom.connect4.views.console.turn.player.PlayerView;
import com.jsrom.connect4.views.console.turn.player.PlayerViewPrototypeDirector;
import com.jsrom.connect4.views.console.turn.player.PlayerViewPrototypeRegistry;

import com.jsrom.utils.views.Console;

public class TurnView {

    public void selectPlayers(StartController startController) {
        new TurnMenu(startController, startController.getNumberPlayers()).interact();
    }

    public void dropToken(PlayController playController) {
        assert !playController.isFinished();
        PlayerView playerView = new PlayerViewPrototypeDirector().get(new PlayerViewPrototypeRegistry(playController),
                playController.getActivePlayerType());
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
