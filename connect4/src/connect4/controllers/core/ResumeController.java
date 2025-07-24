package connect4.controllers.core;

import connect4.models.Session;

public abstract class ResumeController extends Controller implements AcceptorController {

    public ResumeController(Session session) {
        super(session);
    }

    public abstract boolean isWinner();

    public abstract void reset();

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
