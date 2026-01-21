package main.java.com.jsrom.connect4.persistence.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.java.com.jsrom.connect4.models.Game;

public class SessionDAO extends main.java.com.jsrom.connect4.persistence.SessionDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/Connect4";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private Connection connection;

    public SessionDAO() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.createTables();
    }

    private void createTables() {
        this.createGamesTableIfNotExists();
        this.createColorsTableIfNotExists();
    }

    private void createGamesTableIfNotExists() {
        String sql = """
                CREATE TABLE IF NOT EXISTS games (
                game_name varchar(255) UNIQUE NOT NULL,
                last_drop_row INTEGER,
                last_drop_column INTEGER,
                active_player SMALLINT CHECK (active_player IN (0, 1)),
                first_player_type varchar(255),
                second_player_type varchar(255),
                PRIMARY KEY (game_name)
                );
                """;
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void createColorsTableIfNotExists() {
        String sql = """
                CREATE TABLE IF NOT EXISTS colors (
                game_name VARCHAR(255) NOT NULL,
                index INTEGER NOT NULL,
                color VARCHAR(255) NOT NULL,
                PRIMARY KEY (game_name, index),
                FOREIGN KEY (game_name) REFERENCES games(game_name));
                """;
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected GameDAO createGameDAO(Game game) {
        return new GameDAO(game, this.connection);
    }

    @Override
    public String[] getGamesNames() {
        String sql = "SELECT game_name FROM games";
        ArrayList<String> gamesNames = new ArrayList<String>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                gamesNames.add(result.getString("game_name"));
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gamesNames.toArray(new String[0]);
    }

    @Override
    public boolean exists(String name) {
        return ((GameDAO) this.gameDAO).exists(name);
    }

    @Override
    public void load(String name) {
        assert name != null;
        ((GameDAO) this.gameDAO).load(name);
        this.setName(name);
    }

    @Override
    protected void save(String name) {
        assert name != null;
        ((GameDAO) this.gameDAO).save(name);
    }

}
