package connect4.views.console;

import connect4.controllers.core.PlayController;
import connect4.views.console.menus.PlayMenu;

public class PlayView {

    public void interact(PlayController playController) {

        Message.TITLE.writeln();
        new BoardView(playController).writeln();
        playController.registerMemento();
        do {
            new PlayMenu(playController).interact();
        } while (!playController.isFinished());
        new TurnView().writeResult(playController);
        playController.nextState();
    }

}
