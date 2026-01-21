package com.jsrom.connect4.persistence;

import com.jsrom.connect4.models.Game;
import com.jsrom.connect4.persistence.files.BoardDAO;
import com.jsrom.connect4.persistence.files.TurnDAO;

public abstract class GameDAO {

    protected Game game;
    protected BoardDAO boardDAO;
    protected TurnDAO turnDAO;

    protected GameDAO(Game game) {
        this.game = game;
    }

}
