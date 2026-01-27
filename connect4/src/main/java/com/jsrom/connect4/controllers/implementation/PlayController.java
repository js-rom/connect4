package com.jsrom.connect4.controllers.implementation;

import com.jsrom.connect4.controllers.core.ControllerVisitor;
import com.jsrom.connect4.models.Session;
import com.jsrom.connect4.types.Color;
import com.jsrom.connect4.types.PlayerType;

import com.jsrom.utils.models.Coordinate;

public class PlayController extends com.jsrom.connect4.controllers.core.PlayController {

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

    public void dropToken(int column) {
        this.actionController.dropToken(column);
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
