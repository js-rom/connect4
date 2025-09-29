package connect4.daos;

import java.io.FileWriter;

import connect4.models.Game;

public class GameDAO implements DAO {

    Game game;
    BoardDAO boardDAO;
    TurnDAO turnDAO;

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

}
