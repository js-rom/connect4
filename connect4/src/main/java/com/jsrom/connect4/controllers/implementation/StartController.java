package main.java.com.jsrom.connect4.controllers.implementation;

import main.java.com.jsrom.connect4.controllers.core.ControllerVisitor;
import main.java.com.jsrom.connect4.models.Session;
import main.java.com.jsrom.connect4.types.PlayerType;
import main.java.com.jsrom.connect4.types.StateValue;

public class StartController extends main.java.com.jsrom.connect4.controllers.core.StartController {

    private Repository repository;

    public StartController(Session session, Repository repository) {
        super(session);
        this.repository = repository;
    }

    public PlayerType[] getPlayerTypes() {
        return PlayerType.values();
    }

    public int getNumberPlayers() {
        return this.session.getNumberPlayers();
    }

    public void reset() {
        this.session.reset();
    }

    public boolean isReset() {
        return this.session.isReset();
    }

    public void addPlayer(PlayerType playerType) {
        this.session.addPlayer(playerType);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    @Override
    public void start() {
        this.session.nextState();
    }

    @Override
    public void start(String gameName) {
        this.repository.load(gameName);
        this.session.nextState();
        if (this.session.isFinished()) {
            this.session.setState(StateValue.FINAL);
        }
    }

    @Override
    public String[] getGameNames() {
        return this.repository.getGamesNames();
    }

    @Override
    public boolean hasSavedGames() {
        return this.repository.hasSavedGames();
    }

}
