package connect4.views.console;

import connect4.models.Game;
import connect4.views.WithGameView;

public class PlayView extends WithGameView {

    public PlayView(Game game) {
        super(game);
        assert this.game != null;
    }

    public void interact() {

        do {
            new TurnView(game).dropToken();
            new BoardView(game).writeln();
        } while (!this.game.isFinished());
        new TurnView(game).writeResult();
    }

}
