package connect4.views.console;

import connect4.controllers.PlayController;

public class PlayView {

    public void interact(PlayController playController) {

        Message.TITLE.writeln();
        new BoardView(playController).writeln();
        do {
            new TurnView().dropToken(playController);
            new BoardView(playController).writeln();
        } while (!playController.isFinished());
        new TurnView().writeResult(playController);
        playController.nextState();
    }

}
