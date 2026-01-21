package com.jsrom.connect4.persistence.files;

import java.io.BufferedReader;
import java.io.FileWriter;

import com.jsrom.connect4.models.Game;

public class GameDAO extends com.jsrom.connect4.persistence.GameDAO implements DAO {

    protected BoardDAO boardDAO;
    protected TurnDAO turnDAO;

    public GameDAO(Game game) {
        super(game);
        assert game != null;
        this.boardDAO = new BoardDAO(this.game);
        this.turnDAO = new TurnDAO(this.game);

    }

    public void save(FileWriter fileWriter) {
        assert fileWriter != null;
        this.boardDAO.save(fileWriter);
        this.turnDAO.save(fileWriter);
    }

    public void load(BufferedReader bufferedReader) {
        assert bufferedReader != null;
        this.boardDAO.load(bufferedReader);
        this.turnDAO.load(bufferedReader);
    }

}
