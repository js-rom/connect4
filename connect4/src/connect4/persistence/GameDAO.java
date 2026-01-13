package connect4.persistence;

import connect4.models.Game;
import connect4.persistence.files.BoardDAO;
import connect4.persistence.files.TurnDAO;

public abstract class GameDAO {

    protected Game game;
    protected BoardDAO boardDAO;
    protected TurnDAO turnDAO;

    public GameDAO(Game game) {
        assert game != null;
        this.game = game;
        this.boardDAO = this.createBoardDAO();
        this.turnDAO = this.createTurnDAO();
    }

    protected abstract BoardDAO createBoardDAO();
    protected abstract TurnDAO createTurnDAO();
}
