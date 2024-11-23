package connect4;

import connect4.controllers.ResumeController;
import connect4.controllers.PlayController;
import connect4.controllers.StartController;
import connect4.models.Game;
import connect4.views.View;

public abstract class Connect4 {

    private Game game;
    private View view;
    protected StartController startController;
    protected PlayController playController;
    protected ResumeController resumeController;

    protected Connect4() {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.view = this.createView();
    }

    protected abstract View createView();

    protected abstract void playGames();

    protected View getView() {
        assert(this.view != null);
        return this.view;
    }

}
