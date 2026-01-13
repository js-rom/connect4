package connect4.persistence.files;

import java.io.BufferedReader;
import java.io.FileWriter;

import connect4.models.Game;

public class GameDAO extends connect4.persistence.GameDAO implements DAO {

    public GameDAO(Game game) {
        super(game);
        assert game != null;

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

    @Override
    protected BoardDAO createBoardDAO() {
        return new BoardDAO(this.game);
    }

    @Override
    protected TurnDAO createTurnDAO() {
        return new TurnDAO(this.game);
    }

}
