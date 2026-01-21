package main.java.com.jsrom.connect4.controllers.implementation;

import main.java.com.jsrom.connect4.models.Session;

public class SaveController extends main.java.com.jsrom.connect4.controllers.core.SaveController {

    private Repository repository;

    public SaveController(Session session, Repository repository) {
        super(session);
        this.repository = repository;
    }

    public boolean hasName() {
        return this.session.hasName();
    }

    public boolean exists(String name) {
        return this.repository.exists(name);
    }

    public void save() {
        this.repository.save();
    }

    @Override
    public void setName(String name) {
        this.session.setName(name);
    }

}
