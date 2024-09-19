package connect4.views.graphics;

import connect4.models.Game;
import connect4.views.WithGameView;

public class StartView extends WithGameView {

    public StartView(Game game) {
        super(game);
        assert this.game != null;
    }

    public void interact() {
        assert this.game.isReset();
    }
    
}
