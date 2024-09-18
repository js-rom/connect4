package connect4.views.console;

import connect4.models.Game;
import connect4.views.WithGameView;

public class StartView extends WithGameView {

    public StartView(Game game) {
        super(game);
        assert this.game != null;
    }

    public void interact() {
        new TurnView(this.game).resetPlayers(); // OJOOO
        Message.TITLE.writeln();
        new BoardView(this.game).writeln();
    }

}
