package connect4.views.console;

import connect4.controllers.StartController;

public class StartView {

    StartController startController;

    public StartView(StartController startController) {
        this.startController = startController;
    }

    public void interact() {
        assert this.startController.isReset();
        new TurnView(this.startController).selectPlayers();
        Message.TITLE.writeln();
        new BoardView(this.startController).writeln();
    }

}
