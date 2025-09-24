package connect4.controllers.implementation;

import connect4.daos.SessionDAO;
import connect4.models.Session;

public class SaveController extends connect4.controllers.core.SaveController {

    public SaveController(Session session, SessionDAO sessionDAO) {
        super(session);
    }

    public boolean hasName() {
        return this.session.hasName();
    }

    public boolean exists(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    public void save() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }

}
