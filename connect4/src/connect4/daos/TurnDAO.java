package connect4.daos;

import java.io.BufferedReader;
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
        //this.savePlayersSize(fileWriter);
        this.savePlayers(fileWriter);
    }

    private void saveActivePlayer(FileWriter fileWriter) {
        try {
            fileWriter.write(this.game.getActivePlayerIndex() + EOL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*     private void savePlayersSize(FileWriter fileWriter) {
        try {
            fileWriter.write(this.game.getPlayersSize() + EOL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */

    private void savePlayers(FileWriter fileWriter) {
        new PlayerDAO(this.game).save(fileWriter);
    }

    public void load(BufferedReader bufferedReader) {
        this.loadActivePlayer(bufferedReader);
        //this.loadPlayersSize(bufferedReader);
        new PlayerDAO(this.game).load(bufferedReader);
    }

    private void loadActivePlayer(BufferedReader bufferedReader) {
        int activePlayerIndex = 0;
        try {
            activePlayerIndex = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.game.setActivePlayer(activePlayerIndex);
    }

/*     private void loadPlayersSize(BufferedReader bufferedReader) {
        int playersSize = 0;
        try {
            playersSize = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.game.setPlayersSize(playersSize);
    } */
}
