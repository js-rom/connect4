package connect4;

import connect4.models.Game;
import connect4.views.View;

public abstract class Connect4 {

    private Game game;
    private View view;

    protected Connect4() {
        this.game = new Game();
        this.view = this.createView(this.game);
    }

    protected abstract View createView(Game game);

    protected abstract void playGames();

    protected View getView() {
        return this.view;
    }

}
