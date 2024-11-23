package connect4;

import connect4.controllers.Logic;
import connect4.models.Game;
import connect4.views.View;

public abstract class Connect4 {

    private View view;
    private Logic logic;

    protected Connect4() {

        this.logic = new Logic(new Game());
        this.view = this.createView(this.logic);

    }

    protected abstract View createView(Logic logic);

    protected abstract void playGames();

    protected View getView() {

        assert (this.view != null);
        return this.view;

    }

}
