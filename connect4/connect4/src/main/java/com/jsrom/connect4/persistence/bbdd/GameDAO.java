package com.jsrom.connect4.persistence.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import com.jsrom.connect4.models.Game;

public class GameDAO extends com.jsrom.connect4.persistence.GameDAO implements DAO {

    private Connection connection;

    public GameDAO(Game game, Connection connection) {
        super(game);
        assert game != null && connection != null;
        this.connection = connection;
    }

    public void save(String name) {
        if (this.exists(name)) {
            this.update(name);
        } else {
            this.insert(name);
        }
    }

    private void update(String name) {
        String sql = """
                UPDATE games
                SET colors = ?,
                    last_drop_row = ?,
                    last_drop_column = ?,
                    active_player = ?,
                    first_player_type = ?,
                    second_player_type = ?
                WHERE game_name = ?
                """;
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setString(1, Arrays.toString(this.game.getBoardColors()));
            ps.setInt(2, this.game.getLastDrop().getRow());
            ps.setInt(3, this.game.getLastDrop().getColumn());
            ps.setInt(4, this.game.getActivePlayerIndex());
            ps.setString(5, this.game.getPlayerTypeName(0));
            ps.setString(6, this.game.getPlayerTypeName(1));
            ps.setString(7, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert(String name) {
        String sql = """
                INSERT INTO games (
                    game_name,
                    colors,
                    last_drop_row,
                    last_drop_column,
                    active_player,
                    first_player_type,
                    second_player_type
                ) VALUES (?, ?, ?, ?, ?, ?, ?)
                """;
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, Arrays.toString(this.game.getBoardColors()));
            ps.setInt(3, this.game.getLastDrop().getRow());
            ps.setInt(4, this.game.getLastDrop().getColumn());
            ps.setInt(5, this.game.getActivePlayerIndex());
            ps.setString(6, this.game.getPlayerTypeName(0));
            ps.setString(7, this.game.getPlayerTypeName(1));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
    public void load() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

}
