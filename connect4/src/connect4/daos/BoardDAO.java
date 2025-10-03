package connect4.daos;

import java.io.FileWriter;

import connect4.models.Game;
import utils.models.Coordinate;

public class BoardDAO implements DAO {

    private Game game;

    public BoardDAO(Game game) {
        assert game != null;
        this.game = game;
    }

    @Override
    public void save(FileWriter fileWriter) {
        this.saveBoard(fileWriter);
        this.saveLastDrop(fileWriter);
    }

    private void saveBoard(FileWriter fileWriter) {
        for (String color : game.getBoardColors()) {
            try {
                fileWriter.write(color + EOL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void saveLastDrop(FileWriter fileWriter) {
        Coordinate lastDrop = this.game.getLastDrop();
        try {
            fileWriter.write(lastDrop.getRow() + EOL);
            fileWriter.write(lastDrop.getColumn() + EOL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
