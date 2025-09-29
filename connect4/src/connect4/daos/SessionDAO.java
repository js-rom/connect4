package connect4.daos;

import connect4.models.Session;

public class SessionDAO {

    Session session;

    public void associate(Session session) {
        this.session = session;
    }
}
