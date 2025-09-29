package connect4.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import connect4.models.Session;

public class SessionDAO {

    public static final String EXTENSION = ".jsrom";
    public static final String DIRECTORY = "./games";
    private static File directory;
    static {
        SessionDAO.directory = new File(SessionDAO.DIRECTORY);
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
}
