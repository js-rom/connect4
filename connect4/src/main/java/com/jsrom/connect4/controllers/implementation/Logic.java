package main.java.com.jsrom.connect4.controllers.implementation;

import main.java.com.jsrom.connect4.controllers.core.AcceptorController;
import main.java.com.jsrom.connect4.models.Session;
import main.java.com.jsrom.connect4.types.StateValue;

public class Logic extends main.java.com.jsrom.connect4.controllers.core.Logic {

    private Session session;
    private Repository repository;

    protected StartController startController;
    protected PlayController playController;
    protected SaveController saveController;
    protected ResumeController resumeController;

    public Logic(Repository repository) {
        this.session = new Session();
        this.repository = repository;
        this.repository.associate(this.session);
        this.startController = new StartController(session, repository);
        this.playController = new PlayController(session);
        this.saveController = new SaveController(session, repository);
        this.resumeController = new ResumeController(session);
        this.controllers.put(StateValue.INITIAL, this.startController);
        this.controllers.put(StateValue.IN_GAME, this.playController);
        this.controllers.put(StateValue.OUT_GAME, this.saveController);
        this.controllers.put(StateValue.FINAL, this.resumeController);
        this.controllers.put(StateValue.EXIT, null);
    }

    public AcceptorController getController() {
        return this.controllers.get(this.session.getValueState());
    }

}
