package connect4.controllers.implementation;

import connect4.daos.SessionDAO;
import connect4.models.Session;

public class SaveController extends connect4.controllers.core.SaveController {

    private SessionDAO sessionDAO;

    public SaveController(Session session, SessionDAO sessionDAO) {
        super(session);
        this.sessionDAO = sessionDAO;
    }

    public boolean hasName() {
        return this.session.hasName();
    }

    public boolean exists(String name) {
        return this.sessionDAO.exists(name);
    }

    public void save() {
        this.sessionDAO.save();
    }

    @Override
    public void setName(String name) {
        this.session.setName(name);
    }

}
