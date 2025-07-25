package connect4.controllers.core;

import connect4.models.Session;
import connect4.types.PlayerType;

public abstract class StartController extends Controller implements AcceptorController {

    public StartController(Session session) {
        super(session);
    }

    public abstract PlayerType[] getPlayerTypes();

    public abstract int getNumberPlayers();

    public abstract void reset();

    public abstract boolean isReset();

    public abstract void addPlayer(PlayerType playerType);

    public abstract PlayerType getMinMaxMachinePlayerType();

    public abstract PlayerType getRandomMachinePlayerType();

    public abstract PlayerType getUserPlayerPlayerType();

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
