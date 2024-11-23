package connect4.views.console;

import connect4.controllers.PlayController;

public class PlayView {

    PlayController playController;

    public PlayView(PlayController playController) {
        assert this.playController != null;
        this.playController = playController;
    }

    public void interact() {

        do {
            new TurnView(this.playController).dropToken();
            new BoardView(this.playController).writeln();
        } while (!this.playController.isFinished());
        new TurnView(this.playController).writeResult();
    }

}
