package com.jsrom.connect4.launchers;

import com.jsrom.connect4.controllers.core.Logic;
import com.jsrom.connect4.views.View;

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
