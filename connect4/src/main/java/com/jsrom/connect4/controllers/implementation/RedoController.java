package com.jsrom.connect4.controllers.implementation;

import com.jsrom.connect4.controllers.core.Controller;
import com.jsrom.connect4.models.Session;

public class RedoController extends Controller {

    public RedoController(Session session) {
        super(session);
    }

    public void redo() {
        this.session.redo();
    }

    public boolean redoable() {
        return this.session.redoable();
    }

}
