package connect4.controllers.implementation;

import connect4.controllers.core.AcceptorController;
import connect4.models.Session;
import connect4.types.StateValue;

public class Logic extends connect4.controllers.core.Logic {

    public Logic() {
        this.session = new Session();
        this.controllers.put(StateValue.INITIAL, new StartController(session));
        this.controllers.put(StateValue.IN_GAME, new PlayController(session));
        this.controllers.put(StateValue.RESUME, new ResumeController(session));
        this.controllers.put(StateValue.EXIT, null);
    }

    public AcceptorController getController() {
        return this.controllers.get(this.session.getValueState());
    }

}
