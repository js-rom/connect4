package com.jsrom.connect4.controllers.implementation;

import com.jsrom.connect4.controllers.core.Controller;
import com.jsrom.connect4.models.Session;

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
