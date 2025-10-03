package connect4.daos;

import java.io.FileWriter;
import java.io.IOException;

import connect4.models.Game;

public class PlayerDAO implements DAO {

    private Game game;

    public PlayerDAO(Game game) {
        assert game != null;
        this.game = game;
    }

    @Override
    public void save(FileWriter fileWriter) {
        for (int i = 0; i < this.game.getPlayersSize(); i++) {
            try {
                fileWriter.write(this.game.getPlayerTypeName(i) + EOL);
                fileWriter.write(this.game.getPlayerColorName(i) + EOL);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
    }

}
