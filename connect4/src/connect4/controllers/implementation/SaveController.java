package connect4.controllers.implementation;

import connect4.daos.SessionDAO;
import connect4.models.Session;

public class SaveController extends connect4.controllers.core.SaveController {

    public SaveController(Session session, SessionDAO sessionDAO) {
        super(session);
    }

}
