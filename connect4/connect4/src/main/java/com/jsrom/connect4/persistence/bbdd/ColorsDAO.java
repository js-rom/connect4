package com.jsrom.connect4.persistence.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jsrom.connect4.models.Game;

public class ColorsDAO implements DAO {

    private Game game;
    private Connection connection;

    public ColorsDAO(Game game, Connection connection) {
        assert game != null;
        this.game = game;
        this.connection = connection;
    }

    @Override
    public void save(String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public void load(String name) {
        String sql = """
                SELECT color
                FROM colors
                WHERE game_name = ?
                ORDER BY index ASC
                """;
                String[] boardColors = this.game.getBoardColors();
                int i = 0;
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setString(1, name);
            var rs = ps.executeQuery();
            while (rs.next()) {
                boardColors[i] = rs.getString("color");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.game.setBoardColors(boardColors);

    }

    public void update(String name) {
        String[] colors = this.game.getBoardColors();
        for (int i = 0; i < colors.length; i++) {
            this.update(name, i, colors[i]);
        }
    }

    private void update(String name, int index, String color) {
        String sql = """
                UPDATE colors
                SET color = ?
                WHERE game_name = ? AND index = ?;
                """;
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setString(1, color);
            ps.setString(2, name);
            ps.setInt(3, index);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insert(String name) {
        String[] colors = this.game.getBoardColors();
        for (int i = 0; i < colors.length; i++) {
            this.insert(name, i, colors[i]);
        }
    }

    private void insert(String name, int index, String color) {
        String sql = """
                INSERT INTO colors (
                game_name,
                index,
                color)
                VALUES (?, ?, ?);
                """;
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, index);
            ps.setString(3, color);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
