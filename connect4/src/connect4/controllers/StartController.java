package connect4.controllers;

import connect4.models.Session;
import connect4.types.PlayerType;

public class StartController extends Controller implements AcceptorController {

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

    public PlayerType getMinMaxMachinePlayerType() {
        return PlayerType.MIN_MAX_MACHINE_PLAYER;
    }

    public PlayerType getRandomMachinePlayerType() {
        return PlayerType.RANDOM_MACHINE_PLAYER;
    }

    public PlayerType getUserPlayerPlayerType() {
        return PlayerType.USER_PLAYER;
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
