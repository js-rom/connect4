package connect4.files;

import java.io.BufferedReader;
import java.io.FileWriter;

public interface DAO {

    final String EOL = "\n";
    public void save(FileWriter fileWriter);
    public void load(BufferedReader bufferedReader);
}
