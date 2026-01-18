package com.jsrom.connect4.launchers.standalone;

import com.jsrom.connect4.controllers.implementation.Logic;
import com.jsrom.connect4.launchers.Connect4;
import com.jsrom.connect4.persistence.files.SessionDAO;

public class ConsoleConnect4 extends Connect4 {

    protected void createLogic() {
        this.logic = new Logic(new SessionDAO());
    }

    public static void main(String[] args) throws Exception {
        new ConsoleConnect4().playGames();
    }

}