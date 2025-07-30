package connect4.controllers.implementation;

import connect4.controllers.core.AcceptorController;
import connect4.controllers.core.ControllerVisitor;
import connect4.models.Player;
import connect4.models.Session;
import connect4.types.Color;
import connect4.types.PlayerType;
import utils.models.Coordinate;

public class PlayController extends connect4.controllers.core.PlayController implements AcceptorController {

    private ActionContoller actionController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayController(Session session) {
        super(session);
        this.actionController = new ActionContoller(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
    }

    public void undo() {
        this.undoController.undo();
                }

    public boolean undoable() {
        return this.undoController.undoable();
    }

    public void redo() {
        this.redoController.redo();
    }

    public boolean redoable() {
        return this.redoController.redoable();
    }

    public Player getActivePlayer() {
        return this.actionController.getActivePlayer();
    }

    public PlayerType getActivePlayerType() {
        return this.actionController.getActivePlayerType();
    }

    public Color getColor(Coordinate coordinate) {
        return this.actionController.getColor(coordinate);
    }

    public boolean isFinished() {
        return this.actionController.isFinished();
    }

    public void next() {
        this.actionController.next();
    }

    public void registerMemento() {
        this.actionController.registerMemento();
    }

    public void dropToken(int Column) {
        this.actionController.dropToken(Column);
    }

    public int getColumn() {
        return this.actionController.getColumn();
    }

    public boolean isWinner() {
        return this.actionController.isWinner();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public boolean isComplete(int column) {
        return this.actionController.isComplete(column);
    }

}
