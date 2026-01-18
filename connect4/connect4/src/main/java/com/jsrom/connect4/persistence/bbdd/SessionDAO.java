package com.jsrom.connect4.persistence.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jsrom.connect4.models.Game;

public class SessionDAO extends com.jsrom.connect4.persistence.SessionDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/Connect4";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    protected Connection connection;

    public SessionDAO() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.createtableIfNotExists();
    }

    private void createtableIfNotExists() {
        try {
            Statement statement = this.connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS games"
                    + "(game_name varchar(20) UNIQUE NOT NULL,"
                    + "colors varchar(50),"
                    + "last_drop_row INTEGER,"
                    + "last_drop_column INTEGER,"
                    + "active_player SMALLINT CHECK (active_player IN (1, 2)),"
                    + "first_player_type varchar(20),"
                    + "second_player_type varchar(20),"
                    + "PRIMARY KEY (game_name));";
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected GameDAO createGameDAO(Game game) {
        return new GameDAO(game);
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
        String sql = """
                SELECT EXISTS (
                    SELECT game_name
                    FROM games
                    WHERE game_name = ?
                )
                """;
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void load(String gameName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

    @Override
    protected void save(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
