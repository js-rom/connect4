package com.jsrom.connect4.launchers;

import com.jsrom.connect4.controllers.core.Logic;
import com.jsrom.connect4.views.View;
import com.jsrom.connect4.views.console.ConsoleView;

public abstract class Connect4 {

    protected Logic logic;
    protected View view;

    protected Connect4() {
        this.createLogic();
        this.view = new ConsoleView();
    }

    protected abstract void createLogic();

    protected void playGames() {
        do {
            if (this.logic.getController() != null) {
                this.logic.getController().accept((ConsoleView) this.view);
            }
        } while (this.logic.getController() != null);
    }

}
