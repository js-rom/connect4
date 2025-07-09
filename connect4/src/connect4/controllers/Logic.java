package connect4.controllers;

import java.util.EnumMap;
import java.util.Map;

import connect4.models.Session;
import connect4.types.StateValue;

public class Logic {

    private Session session;
    private Map<StateValue, AcceptorController> controllers;

    public Logic() {
        this.session = new Session();

        this.controllers = new EnumMap<>(StateValue.class);
        this.controllers.put(StateValue.INITIAL, new StartController(session));
        this.controllers.put(StateValue.IN_GAME, new PlayController(session));
        this.controllers.put(StateValue.RESUME, new ResumeController(session));
        this.controllers.put(StateValue.EXIT, null);
    }

    public AcceptorController getController() {
        return this.controllers.get(this.session.getValueState());
    }

}
