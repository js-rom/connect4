package com.jsrom.connect4.launchers.standalone;

import com.jsrom.connect4.controllers.implementation.Logic;
import com.jsrom.connect4.launchers.Connect4;
import com.jsrom.connect4.persistence.SessionDAO;

public abstract class ConsoleConnect4 extends Connect4 {

    protected void createLogic() {
        this.logic = new Logic(this.createSessionDAO());
    }

    protected abstract SessionDAO createSessionDAO();

}