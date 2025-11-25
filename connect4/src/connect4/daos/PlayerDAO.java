package connect4.daos;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import connect4.models.Game;
import connect4.types.PlayerType;

public class PlayerDAO implements DAO {

    private Game game;

    public PlayerDAO(Game game) {
        assert game != null;
        this.game = game;

    }

    @Override
    public void save(FileWriter fileWriter) {
        for (int i = 0; i < this.game.getNumberPlayers(); i++) {
            try {
                fileWriter.write(this.game.getPlayerTypeName(i) + EOL);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void load(BufferedReader bufferedReader) {
        for (int i = 0; i < this.game.getNumberPlayers(); i++) {
            PlayerType playerType = null;
            ;
            try {
                playerType = PlayerType.valueOf(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.game.addPlayer(playerType);
        }
    }

}
