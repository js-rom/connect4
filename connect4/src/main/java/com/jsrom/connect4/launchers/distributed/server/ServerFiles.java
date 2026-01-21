package main.java.com.jsrom.connect4.launchers.distributed.server;

import main.java.com.jsrom.connect4.persistence.files.SessionDAO;

public class ServerFiles extends Server {

    @Override
    protected main.java.com.jsrom.connect4.persistence.SessionDAO createSessionDAO() {
        return new SessionDAO();
    }

    public static void main(String[] args) {
        new ServerFiles().serve();
    }

}
