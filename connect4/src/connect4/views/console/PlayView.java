package connect4.views.console;

import connect4.controllers.Logic;

public class PlayView {

    Logic logic;

    public PlayView(Logic logic) {
        assert this.logic != null;
        this.logic = logic;
    }

    public void interact() {

        do {
            new TurnView(this.logic).dropToken();
            new BoardView(this.logic).writeln();
        } while (!this.logic.isFinished());
        new TurnView(this.logic).writeResult();
    }

}
