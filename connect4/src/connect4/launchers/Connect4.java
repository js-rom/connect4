package connect4.launchers;

import connect4.controllers.core.Logic;
import connect4.views.View;

public abstract class Connect4 {

    protected Logic logic;
    protected View view;

    protected Connect4() {
        this.createLogic();
        this.createView();
    }

    protected abstract void createLogic();
    
    protected abstract void createView();

    protected abstract void playGames();

}
