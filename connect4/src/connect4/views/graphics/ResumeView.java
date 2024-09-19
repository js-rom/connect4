package connect4.views.graphics;

import connect4.models.Game;
import connect4.views.WithGameView;

public class ResumeView extends WithGameView{

    public ResumeView(Game game) {
        super(game);
        assert this.game != null;
    }

    public boolean interact() {
        return true;
    }

}
