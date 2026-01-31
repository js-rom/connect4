package com.jsrom.connect4.launchers.distributed.client;

import com.jsrom.connect4.controllers.proxies.Logic;

public class Connect4 extends com.jsrom.connect4.launchers.Connect4 {

    public Connect4() {
        this.logic = new Logic();
    }

    public static void main(String[] config) throws Exception {
        new Connect4().play(config);
    }

}