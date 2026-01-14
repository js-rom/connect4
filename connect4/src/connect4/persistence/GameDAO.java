package connect4.persistence;

import connect4.models.Game;
import connect4.persistence.files.BoardDAO;
import connect4.persistence.files.TurnDAO;

public abstract class GameDAO {

    protected Game game;
    protected BoardDAO boardDAO;
    protected TurnDAO turnDAO;

    protected GameDAO(Game game) {
        this.game = game;
    }

}
