package connect4.controllers.implementation;

import connect4.controllers.core.Controller;
import connect4.models.Session;

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
