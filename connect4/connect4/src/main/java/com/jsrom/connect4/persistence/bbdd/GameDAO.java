package com.jsrom.connect4.persistence.bbdd;

import com.jsrom.connect4.models.Game;

public class GameDAO extends com.jsrom.connect4.persistence.GameDAO implements DAO {

    public GameDAO(Game game) {
        super(game);
        assert game != null;
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void load() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

}
