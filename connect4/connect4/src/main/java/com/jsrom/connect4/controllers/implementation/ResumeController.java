package com.jsrom.connect4.controllers.implementation;

import com.jsrom.connect4.controllers.core.ControllerVisitor;
import com.jsrom.connect4.models.Session;

public class ResumeController extends com.jsrom.connect4.controllers.core.ResumeController {

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
