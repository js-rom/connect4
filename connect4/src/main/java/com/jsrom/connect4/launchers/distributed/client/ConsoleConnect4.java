package com.jsrom.connect4.launchers.distributed.client;

import com.jsrom.connect4.controllers.proxies.Logic;
import com.jsrom.connect4.launchers.Connect4;

public class ConsoleConnect4 extends Connect4 {

    @Override
    protected void createLogic() {
        this.logic = new Logic();
    }

    @Override
    protected void playGames() {
        super.playGames();
        ((Logic) this.logic).close();
    }

    public static void main(String[] args) throws Exception {
        new ConsoleConnect4().playGames();
    }

}
