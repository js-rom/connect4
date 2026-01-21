package main.java.com.jsrom.connect4.launchers.standalone;

import main.java.com.jsrom.connect4.persistence.bbdd.SessionDAO;

public class ConsoleConnect4bbdd extends ConsoleConnect4 {

    @Override
    protected SessionDAO createSessionDAO() {
        return new SessionDAO();
    }

    public static void main(String[] args) throws Exception {
        new ConsoleConnect4bbdd().playGames();
    }
}
