package com.jsrom.connect4.persistence;

import com.jsrom.connect4.models.Game;

public abstract class GameDAO {

    protected Game game;

    protected GameDAO(Game game) {
        this.game = game;
    }

}
