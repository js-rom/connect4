package connect4.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import connect4.controllers.implementation.Repository;
import connect4.models.Session;

public class SessionDAO implements Repository {

    public static final String EXTENSION = ".jsrom";
    public static final Path DIRECTORY = Paths.get("connect4", "games");
    private static File directory;
    static {
        SessionDAO.directory = SessionDAO.DIRECTORY.toFile();
    }
    private Session session;
    private GameDAO gameDAO;

    public void associate(Session session) {
        this.session = session;
        this.gameDAO = new GameDAO(this.session.getGame());

    }

    public void save() {
        this.save(this.session.getName());
    }

    private void save(String name) {
        assert name != null;
        FileWriter fileWriter = this.createFileWriter(name);
        this.gameDAO.save(fileWriter);
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

    public boolean hasSavedGames() {
        return this.getGamesNames().length > 0;
    }

    public void load(String gameName) {
        assert gameName != null;
        BufferedReader bufferedReader = this.createBufferedReader(gameName);
        this.gameDAO.load(bufferedReader);
        this.closeBufferedReader(bufferedReader);
        this.session.setName(gameName);
    }
}
