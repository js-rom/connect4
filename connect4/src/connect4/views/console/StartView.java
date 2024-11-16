package connect4.views.console;

import connect4.models.Game;
import connect4.views.WithGameView;

public class StartView extends WithGameView {

    public StartView(Game game) {
        super(game);
        assert this.game != null;
    }

    public void interact() {
        assert this.game.isReset();
        new TurnView(this.game).selectPlayers();
        Message.TITLE.writeln();
        new BoardView(this.game).writeln();
    }

}
