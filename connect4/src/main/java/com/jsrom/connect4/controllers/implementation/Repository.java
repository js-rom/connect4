package main.java.com.jsrom.connect4.controllers.implementation;

import main.java.com.jsrom.connect4.models.Session;

public interface Repository {

    public void associate(Session session);
    public void save();
    public String[] getGamesNames();
    public boolean exists(String name);
    public boolean hasSavedGames();
    public void load(String gameName);

}
