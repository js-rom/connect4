package main.java.com.jsrom.connect4.controllers.implementation;

import main.java.com.jsrom.connect4.controllers.core.Controller;
import main.java.com.jsrom.connect4.models.Session;

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
