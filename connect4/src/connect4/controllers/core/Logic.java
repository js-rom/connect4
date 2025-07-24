package connect4.controllers.core;

import java.util.EnumMap;
import java.util.Map;

import connect4.models.Session;
import connect4.types.StateValue;

public abstract class Logic {

    protected Session session;
    protected Map<StateValue, AcceptorController> controllers;

    public Logic() {
        this.controllers = new EnumMap<>(StateValue.class);
    }

    public AcceptorController getController() {
        return this.controllers.get(this.session.getValueState());
    }

}
