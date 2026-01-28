package com.jsrom.connect4.persistence;

import com.jsrom.connect4.controllers.implementation.Repository;
import com.jsrom.connect4.models.Game;
import com.jsrom.connect4.models.Session;

public abstract class SessionDAO implements Repository {

    private Session session;
    protected GameDAO gameDAO;

    public void associate(Session session) {
        this.session = session;
        this.gameDAO = createGameDAO(this.session.getGame());
    }

    protected abstract GameDAO createGameDAO(Game game);

    public void save() {
        this.save(this.getName());
    }

    protected abstract void save(String name);

    protected String getName() {
        return this.session.getName();
    }

    public boolean hasSavedGames() {
        return this.getGamesNames().length > 0;
    }

    protected void setName(String name) {
        this.session.setName(name);
    }
}
