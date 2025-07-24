package connect4.controllers.core;

import connect4.models.Player;
import connect4.models.Session;
import connect4.types.Color;
import connect4.types.PlayerType;
import utils.models.Coordinate;

public abstract class PlayController extends Controller implements AcceptorController {

    public PlayController(Session session) {
        super(session);
    }

    public abstract void undo();

    public abstract boolean undoable();

    public abstract void redo();

    public abstract boolean redoable();

    public abstract Player getActivePlayer();

    public abstract PlayerType getActivePlayerType();

    public abstract Color getColor(Coordinate coordinate);

    public abstract boolean isFinished();

    public abstract void next();

    public abstract void registerMemento();

    public abstract void dropToken(int Column);

    public abstract int getColumn();

    public abstract boolean isWinner();

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
