package connect4.daos;

import java.io.FileWriter;

public interface DAO {

    final String EOL = "\n";
    public void save(FileWriter fileWriter);
}
