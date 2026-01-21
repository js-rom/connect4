package main.java.com.jsrom.connect4.persistence.files;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import main.java.com.jsrom.connect4.models.Game;

public class TurnDAO implements DAO {

    private Game game;

    public TurnDAO(Game game) {
        assert game != null;
        this.game = game;
    }

    @Override
    public void save(FileWriter fileWriter) {
        this.saveActivePlayer(fileWriter);
        this.savePlayers(fileWriter);
    }

    private void saveActivePlayer(FileWriter fileWriter) {
        try {
            fileWriter.write(this.game.getActivePlayerIndex() + EOL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void savePlayers(FileWriter fileWriter) {
        new PlayerDAO(this.game).save(fileWriter);
    }

    public void load(BufferedReader bufferedReader) {
        this.loadActivePlayer(bufferedReader);
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
    
}
