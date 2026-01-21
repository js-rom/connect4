package com.jsrom.connect4.launchers.distributed.server;

import com.jsrom.connect4.persistence.files.SessionDAO;

public class ServerFiles extends Server {

    @Override
    protected com.jsrom.connect4.persistence.SessionDAO createSessionDAO() {
        return new SessionDAO();
    }

    public static void main(String[] args) {
        new ServerFiles().serve();
    }

}
