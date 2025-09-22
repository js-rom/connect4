package connect4.controllers.implementation;

import connect4.controllers.core.AcceptorController;
import connect4.daos.SessionDAO;
import connect4.models.Session;
import connect4.types.StateValue;

public class Logic extends connect4.controllers.core.Logic {

    private Session session;
    private SessionDAO sessionDAO;

    protected StartController startController;
    protected PlayController playController;
    protected SaveController saveController;
    protected ResumeController resumeController;

    public Logic(SessionDAO sessionDAO) {
        this.session = new Session();
        this.sessionDAO = sessionDAO;
        this.startController = new StartController(session);
        this.playController = new PlayController(session);
        this.saveController = new SaveController(session, sessionDAO);
        this.resumeController = new ResumeController(session);
        this.controllers.put(StateValue.INITIAL, this.startController);
        this.controllers.put(StateValue.IN_GAME, this.playController);
        this.controllers.put(StateValue.OUT_GAME, this.saveController);
        this.controllers.put(StateValue.RESUME, this.resumeController);
        this.controllers.put(StateValue.EXIT, null);
    }

    public AcceptorController getController() {
        return this.controllers.get(this.session.getValueState());
    }

}
