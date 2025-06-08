package connect4;

import connect4.controllers.Logic;
import connect4.views.View;

public abstract class Connect4 {

    private View view;
    protected Logic logic;

    protected Connect4() {

        this.logic = new Logic();
        this.view = this.createView();

    }

    protected abstract View createView();

    protected abstract void playGames();

    protected View getView() {

        assert (this.view != null);
        return this.view;

    }

}
