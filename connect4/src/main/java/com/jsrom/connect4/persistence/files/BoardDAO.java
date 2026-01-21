package main.java.com.jsrom.connect4.persistence.files;

import java.io.BufferedReader;
import java.io.FileWriter;

import main.java.com.jsrom.connect4.models.Game;

import main.java.com.jsrom.utils.models.Coordinate;

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

    public void load(BufferedReader bufferedReader) {
        this.loadBoard(bufferedReader);
        this.loadLastDrop(bufferedReader);
    }

    public void loadBoard(BufferedReader bufferedReader) {
        String[] boardColors = game.getBoardColors();
        for (int i = 0; i < boardColors.length; i++) {
            try {
                boardColors[i] = bufferedReader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.game.setBoardColors(boardColors);
    }

    public void loadLastDrop(BufferedReader bufferedReader) {
        int row = 0;
        int column = 0;
        try {
            row = Integer.parseInt(bufferedReader.readLine());
            column = Integer.parseInt(bufferedReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Coordinate lastDrop = new Coordinate(row, column);
        this.game.setLastDrop(lastDrop);
    }

}
