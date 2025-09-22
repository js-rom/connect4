package connect4.controllers.core;

import connect4.models.Session;

public abstract class SaveController extends Controller implements AcceptorController {

    public SaveController(Session session) {
        super(session);
    }

    public SaveController() {

    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
