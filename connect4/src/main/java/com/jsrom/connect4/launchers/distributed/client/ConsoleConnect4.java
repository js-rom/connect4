package com.jsrom.connect4.launchers.distributed.client;

import com.jsrom.connect4.controllers.proxies.Logic;
import com.jsrom.connect4.launchers.Connect4;
import com.jsrom.connect4.views.console.ConsoleView;

public class ConsoleConnect4 extends Connect4 {

    @Override
    protected void createLogic() {
        this.logic = new Logic();
    }

        @Override
    protected void createView() {
        this.view = new ConsoleView();
    }

    @Override
    protected void playGames() {
        do {
            if (this.logic.getController() != null) {
                this.logic.getController().accept((ConsoleView) this.view);
            }
        } while (this.logic.getController() != null);
        ((Logic) this.logic).close();
    }

    public static void main(String[] args) throws Exception {
        new ConsoleConnect4().playGames();
    }

}