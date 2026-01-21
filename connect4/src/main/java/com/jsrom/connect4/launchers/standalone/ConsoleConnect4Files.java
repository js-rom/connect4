package main.java.com.jsrom.connect4.launchers.standalone;

import main.java.com.jsrom.connect4.persistence.files.SessionDAO;

public class ConsoleConnect4Files extends ConsoleConnect4 {

    @Override
    protected SessionDAO createSessionDAO() {
        return new SessionDAO();
    }

    public static void main(String[] args) throws Exception {
        new ConsoleConnect4Files().playGames();
    }

}
