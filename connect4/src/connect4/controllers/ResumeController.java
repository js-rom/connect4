package connect4.controllers;

import connect4.models.Session;

public class ResumeController extends Controller {

    public ResumeController(Session session) {
        super(session);
    }

    public boolean isWinner() {
        return this.session.isWinner();
    }

    public void reset() {
        this.session.reset();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
