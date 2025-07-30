package connect4.controllers.implementation;

import connect4.controllers.core.ControllerVisitor;
import connect4.models.Session;

public class ResumeController extends connect4.controllers.core.ResumeController {

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
