package connect4.controllers;

import connect4.models.Session;

public class UndoController extends Controller {

    UndoController(Session session) {
        super(session);
    }

    public void undo() {
        this.session.undo();
    }

    public boolean undoable() {
        return this.session.undoable();
    }

}
