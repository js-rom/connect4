package com.jsrom.connect4.launchers.standalone;

import com.jsrom.connect4.controllers.implementation.Logic;
import com.jsrom.connect4.launchers.Connect4;
import com.jsrom.connect4.persistence.SessionDAO;
import com.jsrom.connect4.views.console.ConsoleView;

public abstract class ConsoleConnect4 extends Connect4 {

    protected void createLogic() {
        this.logic = new Logic(this.createSessionDAO());
    }

    protected abstract SessionDAO createSessionDAO();

    protected void createView() {
        this.view = new ConsoleView();
    }

    protected void playGames() {
        do {
            if (this.logic.getController() != null) {
                this.logic.getController().accept((ConsoleView) this.view);
            }
        } while (this.logic.getController() != null);
    }

}