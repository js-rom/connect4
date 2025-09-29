package connect4.daos;

import java.io.FileWriter;

import connect4.models.Game;

public class GameDAO {

    public GameDAO(Game game) {
        assert game != null;
    }

    public void save(FileWriter fileWriter) {
        assert fileWriter != null;
    }

}
