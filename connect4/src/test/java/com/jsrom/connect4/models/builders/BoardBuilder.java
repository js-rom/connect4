package com.jsrom.connect4.models.builders;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.jsrom.connect4.models.Board;
import com.jsrom.connect4.types.Color;
import com.jsrom.utils.models.Coordinate;

public class BoardBuilder {

    private List<String> rows;

    public BoardBuilder() {
        this.rows = new ArrayList<>();
    }

    public BoardBuilder rowsFromBoardTopToBottom(String... rows) {
        assert rows.length == Coordinate.NUMBER_ROWS;

        for (String row : rows) {
            assert Pattern.matches("[RY ]{" + Coordinate.NUMBER_COLUMNS + "}", row);
            this.rows.add(row);
        }
        return this;
    }

    private Board boardFromRows() {
        Board board = new Board();
        Map<Character, Color> charToColor = Map.of('R', Color.RED, 'Y', Color.YELLOW, ' ', Color.NULL);
        for (int i = 0; i < this.rows.size(); i++) {
            int reverseRowIndex = Coordinate.NUMBER_ROWS - 1 - i;
            String row = this.rows.get(reverseRowIndex);
            for (int j = 0; j < row.length(); j++) {
                Color color = charToColor.get(row.charAt(j));
                if (color != Color.NULL) {
                    board.dropToken(j, color);
                }
            }
        }
        return board;
    }

    public Board build() {
        return this.boardFromRows();
    }
}
