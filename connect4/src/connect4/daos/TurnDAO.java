package connect4.daos;

import java.io.FileWriter;
import java.io.IOException;

import connect4.models.Game;

public class TurnDAO implements DAO {

    private Game game;

    public TurnDAO(Game game) {
        assert game != null;
        this.game = game;
    }

    @Override
    public void save(FileWriter fileWriter) {
        this.saveActivePlayer(fileWriter);
        this.savePlayersSize(fileWriter);
        this.savePlayers(fileWriter);
    }

    private void saveActivePlayer(FileWriter fileWriter) {
        try {
            fileWriter.write(this.game.getActivePlayerIndex() + EOL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void savePlayersSize(FileWriter fileWriter) {
        try {
            fileWriter.write(this.game.getPlayersSize() + EOL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void savePlayers(FileWriter fileWriter) {
        new PlayerDAO(this.game).save(fileWriter);
    }
}
