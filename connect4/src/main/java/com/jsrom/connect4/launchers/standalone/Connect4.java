package com.jsrom.connect4.launchers.standalone;

import java.util.Map;

import com.jsrom.connect4.controllers.implementation.Logic;
import com.jsrom.connect4.persistence.SessionDAO;

public class Connect4 extends com.jsrom.connect4.launchers.Connect4 {

    private Map<String, SessionDAO> sessionDAOMap;
    private SessionDAO sessionDAO;

    public Connect4() {
        super();
        this.sessionDAOMap = Map.of(
                "files", new com.jsrom.connect4.persistence.files.SessionDAO(),
                "postgresql", new com.jsrom.connect4.persistence.bbdd.SessionDAO());
    }

    @Override
    protected void configure(String[] config) {
        this.usageMsg += "<persistence: files|postgresql> ";
        super.configure(config);
        this.sessionDAO = this.sessionDAOMap.get(config[1]);
        if (this.sessionDAO == null) {
            System.out.println("Unknown persistence system: " + config[1]);
            System.exit(1);
        }
        this.logic = new Logic(this.sessionDAO);
    }

    public static void main(String[] config) throws Exception {
        new Connect4().play(config);
    }

}