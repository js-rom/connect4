package main.java.com.jsrom.connect4.controllers.core;

import main.java.com.jsrom.connect4.models.Session;

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

    public abstract boolean hasName();

    public abstract boolean exists(String name);

    public abstract void save();

    public abstract void setName(String name);

}
