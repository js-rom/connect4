package connect4.views.console;

import connect4.controllers.Logic;

public class StartView {

    Logic logic;

    public StartView(Logic logic) {
        this.logic = logic;
    }

    public void interact() {
        assert this.logic.isReset();
        new TurnView(this.logic).selectPlayers();
        Message.TITLE.writeln();
        new BoardView(this.logic).writeln();
    }

}
