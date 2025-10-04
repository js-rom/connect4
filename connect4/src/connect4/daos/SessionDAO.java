package connect4.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import connect4.models.Session;

public class SessionDAO {

    public static final String EXTENSION = ".jsrom";
    public static final Path DIRECTORY = Paths.get("connect4", "games");
    private static File directory;
    static {
        SessionDAO.directory = SessionDAO.DIRECTORY.toFile();
    }
    Session session;
    GameDAO gameDAO;

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

    private void closeFileWriter(FileWriter fileWriter) {
        try {
            fileWriter.close();
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
}
