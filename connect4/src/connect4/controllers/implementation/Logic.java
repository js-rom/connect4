package connect4.controllers.implementation;

import connect4.controllers.core.AcceptorController;
import connect4.models.Session;
import connect4.types.StateValue;

public class Logic extends connect4.controllers.core.Logic {

    protected StartController startController;
    protected PlayController playController;
    protected ResumeController resumeController;

    public Logic() {
        this.session = new Session();
        this.startController = new StartController(session);
        this.playController = new PlayController(session);
        this.resumeController = new ResumeController(session);
        this.controllers.put(StateValue.INITIAL, this.startController);
        this.controllers.put(StateValue.IN_GAME, this.playController);
        this.controllers.put(StateValue.RESUME, this.resumeController);
        this.controllers.put(StateValue.EXIT, null);
    }

    public AcceptorController getController() {
        return this.controllers.get(this.session.getValueState());
    }

}
