package connect4.files;

import java.io.BufferedReader;
import java.io.FileWriter;

import connect4.models.Game;

public class GameDAO implements DAO {

    private Game game;
    private BoardDAO boardDAO;
    private TurnDAO turnDAO;

    public GameDAO(Game game) {
        assert game != null;
        this.game = game;
        this.boardDAO = new BoardDAO(this.game);
        this.turnDAO = new TurnDAO(this.game);
    }

    public void save(FileWriter fileWriter) {
        assert fileWriter != null;
        this.boardDAO.save(fileWriter);
        this.turnDAO.save(fileWriter);
    }

    public void load(BufferedReader bufferedReader) {
        assert bufferedReader != null;
        this.boardDAO.load(bufferedReader);
        this.turnDAO.load(bufferedReader);
    }

}
