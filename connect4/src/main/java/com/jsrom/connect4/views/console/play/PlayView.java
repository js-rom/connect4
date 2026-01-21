package main.java.com.jsrom.connect4.views.console.play;

import main.java.com.jsrom.connect4.controllers.core.PlayController;
import main.java.com.jsrom.connect4.views.console.shared.Message;

public class PlayView {

    public void interact(PlayController playController) {

        Message.TITLE.writeln();
        new BoardView(playController).writeln();
        playController.registerMemento();
        do {
            new PlayMenu(playController).interact();
        } while (!playController.isFinished());
    }

}
