package connect4.daos;

import java.io.FileWriter;

import connect4.models.Game;

public class BoardDAO implements DAO {

    public BoardDAO(Game game) {
        assert game != null;
    }

    @Override
    public void save(FileWriter fileWriter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
