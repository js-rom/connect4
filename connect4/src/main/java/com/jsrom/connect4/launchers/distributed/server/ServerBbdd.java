package main.java.com.jsrom.connect4.launchers.distributed.server;

import main.java.com.jsrom.connect4.persistence.bbdd.SessionDAO;

public class ServerBbdd extends Server {

    @Override
    protected main.java.com.jsrom.connect4.persistence.SessionDAO createSessionDAO() {
        return new SessionDAO();
    }

    public static void main(String[] args) {
        new ServerBbdd().serve();
    }

}
