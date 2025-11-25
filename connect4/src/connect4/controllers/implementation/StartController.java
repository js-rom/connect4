package connect4.controllers.implementation;

import connect4.controllers.core.ControllerVisitor;
import connect4.daos.SessionDAO;
import connect4.models.Session;
import connect4.models.State;
import connect4.types.PlayerType;
import connect4.types.StateValue;

public class StartController extends connect4.controllers.core.StartController {

    private SessionDAO sessionDAO;

    public StartController(Session session, SessionDAO sessionDAO) {
        super(session);
        this.sessionDAO = sessionDAO;
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
        this.sessionDAO.load(gameName);
        if (this.session.isFinished()) {
            this.session.setState(StateValue.FINAL);
        } else {
            this.session.nextState();
        }
    }

    @Override
    public String[] getGameNames() {
        return this.sessionDAO.getGamesNames();
    }

    @Override
    public boolean hasSavedGames() {
        return this.sessionDAO.hasSavedGames();
    }

}
