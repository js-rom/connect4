package main.java.com.jsrom.connect4.controllers.core;

import java.util.EnumMap;
import java.util.Map;

import main.java.com.jsrom.connect4.types.StateValue;

public abstract class Logic {

    protected Map<StateValue, AcceptorController> controllers;

    public Logic() {
        this.controllers = new EnumMap<>(StateValue.class);
    }

        public abstract AcceptorController getController();

}
