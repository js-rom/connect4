package com.jsrom.connect4.launchers.distributed.server;

import com.jsrom.connect4.persistence.bbdd.SessionDAO;

public class ServerBbdd extends Server {

    @Override
    protected com.jsrom.connect4.persistence.SessionDAO createSessionDAO() {
        return new SessionDAO();
    }

    public static void main(String[] args) {
        new ServerBbdd().serve();
    }

}
