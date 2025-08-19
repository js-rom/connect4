package connect4.controllers.implementation;

import connect4.controllers.core.ControllerVisitor;
import connect4.models.Session;
import connect4.types.PlayerType;

public class StartController extends connect4.controllers.core.StartController {

    public StartController(Session session) {
        super(session);
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
        // TODO
    }

    @Override
    public String[] getGameNames() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGameNames'");
    }

    @Override
    public boolean hasSavedGames() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasSavedGames'");
    }

}
