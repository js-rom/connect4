package connect4.persistence.bbdd;

import connect4.models.Game;
import connect4.persistence.GameDAO;

public class SessionDAO extends connect4.persistence.SessionDAO {

    @Override
    protected GameDAO createGameDAO(Game game) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createGameDAO'");
    }

    @Override
    public String[] getGamesNames() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGamesNames'");
    }

    @Override
    public boolean exists(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public void load(String gameName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

    @Override
    protected void save(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }


}
