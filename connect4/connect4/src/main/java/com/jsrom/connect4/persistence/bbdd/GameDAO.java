package com.jsrom.connect4.persistence.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsrom.connect4.models.Game;
import com.jsrom.connect4.types.PlayerType;
import com.jsrom.utils.models.Coordinate;

public class GameDAO extends com.jsrom.connect4.persistence.GameDAO implements DAO {

    private Connection connection;
    private ColorsDAO colorsDAO;

    public GameDAO(Game game, Connection connection) {
        super(game);
        assert game != null && connection != null;
        this.connection = connection;
        this.colorsDAO = new ColorsDAO(this.game, this.connection);
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
                SET last_drop_row = ?,
                    last_drop_column = ?,
                    active_player = ?,
                    first_player_type = ?,
                    second_player_type = ?
                WHERE game_name = ?
                """;
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, this.game.getLastDrop().getRow());
            ps.setInt(2, this.game.getLastDrop().getColumn());
            ps.setInt(3, this.game.getActivePlayerIndex());
            ps.setString(4, this.game.getPlayerTypeName(0));
            ps.setString(5, this.game.getPlayerTypeName(1));
            ps.setString(6, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.colorsDAO.update(name);

    }

    private void insert(String name) {
        String sql = """
                INSERT INTO games (
                    game_name,
                    last_drop_row,
                    last_drop_column,
                    active_player,
                    first_player_type,
                    second_player_type
                ) VALUES (?, ?, ?, ?, ?, ?)
                """;
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, this.game.getLastDrop().getRow());
            ps.setInt(3, this.game.getLastDrop().getColumn());
            ps.setInt(4, this.game.getActivePlayerIndex());
            ps.setString(5, this.game.getPlayerTypeName(0));
            ps.setString(6, this.game.getPlayerTypeName(1));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.colorsDAO.insert(name);
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
    public void load(String name) {
        String sql = "SELECT * FROM games WHERE game_name = ?";
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Coordinate lastDrop = new Coordinate(rs.getInt("last_drop_row"), rs.getInt("last_drop_column"));
                    this.game.setLastDrop(lastDrop);
                    this.game.setActivePlayer(rs.getInt("active_player"));
                    this.game.addPlayer(PlayerType.valueOf(rs.getString("first_player_type")));
                    this.game.addPlayer(PlayerType.valueOf(rs.getString("second_player_type")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.colorsDAO.load(name);
    }

}