package com.jsrom.connect4.persistence.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.jsrom.connect4.models.Game;

public class SessionDAO extends com.jsrom.connect4.persistence.SessionDAO {

    public static final String EXTENSION = ".jsrom";
    public static final Path DIRECTORY = Paths.get("connect4", "games");
    private static File directory;
    static {
        SessionDAO.directory = SessionDAO.DIRECTORY.toFile();
    }

    @Override
    protected com.jsrom.connect4.persistence.GameDAO createGameDAO(Game game) {
        return new GameDAO(game);
    }

    protected void save(String name) {
        assert name != null;
        FileWriter fileWriter = this.createFileWriter(name);
        ((GameDAO) this.gameDAO).save(fileWriter);
        this.closeFileWriter(fileWriter);
    }

    private FileWriter createFileWriter(String name) {
        assert name != null;
        if (!name.endsWith(SessionDAO.EXTENSION)) {
            name = name + SessionDAO.EXTENSION;
        }
        File file = new File(SessionDAO.directory, name);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileWriter;
    }

    private BufferedReader createBufferedReader(String name) {
        assert name != null;
        File file = new File(SessionDAO.directory, name);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

    private void closeFileWriter(FileWriter fileWriter) {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeBufferedReader(BufferedReader bufferedReader) {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getGamesNames() {
        return SessionDAO.directory.list();
    }

    public boolean exists(String name) {
        for (String auxName : this.getGamesNames()) {
            if (auxName.equals(name + SessionDAO.EXTENSION)) {
                return true;
            }
        }
        return false;
    }

    public void load(String gameName) {
        assert gameName != null;
        BufferedReader bufferedReader = this.createBufferedReader(gameName);
        ((GameDAO) this.gameDAO).load(bufferedReader);
        this.closeBufferedReader(bufferedReader);
        this.setName(gameName);
    }

}
