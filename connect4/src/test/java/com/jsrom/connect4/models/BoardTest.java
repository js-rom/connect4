package com.jsrom.connect4.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jsrom.connect4.models.builders.BoardBuilder;
import com.jsrom.connect4.types.Color;
import com.jsrom.utils.models.Coordinate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    private BoardBuilder board;

    @BeforeEach
    public void beforeEach() {
        this.board = new BoardBuilder();
    }

    @Test
    public void testGivenEmptyBoardWhenStartThenIsEmpty() {
        assertThat(this.board.build().isEmpty(), is(true));
    }

    @Test
    public void testGivenNotEmptyBoardWhenResetThenIsEmpty() {
        Board board = this.board
                .rows("R YRYRY",
                        "Y RYRYR",
                        "       ",
                        "       ",
                        "       ",
                        "       ")
                .build();
        board.reset();
        assertThat(board.isEmpty(), is(true));
    }

    @Test
    public void testGivenNewBoardWhenDropTokenThenIsOccupied() {
        Board board = this.board.build();
        board.dropToken(0, Color.RED);
        boolean isOccupied = board.isOccupied(new Coordinate(0, 0), Color.RED);
        assertThat(isOccupied, is(true));
    }

    @Test
    public void testGivenBoardWhenPutTokenCompletedColumnAssertionError() {
        Board board = this.board
                .rows("R YRYRY",
                        "Y RYRYR",
                        "R      ",
                        "Y      ",
                        "R      ",
                        "Y      ")
                .build();
        Assertions.assertThrows(AssertionError.class, () -> board.dropToken(0, Color.RED));
    }

    @Test
    public void testGivenNewBoardWhenIsCompletedThenFalse() {
        Board board = this.board.build();
        assertThat(board.isComplete(), is(false));
    }

    @Test
    public void testGivenCompletedBoardWhenIsCompletedThenTrue() {
        Board board = this.board
                .rows("RRYRYRY",
                        "YYRYRYR",
                        "RRYRYRY",
                        "YYRYRYR",
                        "RRYRYRY",
                        "YYRYRYR")
                .build();
        assertThat(board.isComplete(), is(true));
    }

    @Test
    public void testGivenCompletedNotWinnerBoardWhenIsFinishedThenTrue() {
        Board board = this.board
                .rows("RRYRYRY",
                        "YYRYRYR",
                        "RRYRYRY",
                        "YYRYRYR",
                        "RRYRYRY",
                        "YYRYRYR")
                .build();
        assertThat(board.isFinished(), is(true));
    }

    @Test
    public void testGivenWinnerCompletedBoardWhenIsFinishedThenTrue() {
        Board board = this.board
                .rows("RRYRYRY",
                        "YYRYRYR",
                        "RYRRYRY",
                        "YYRYRYR",
                        "RYRRYRY",
                        "YYRYRYR")
                .build();
        assertThat(board.isFinished(), is(true));
    }

    @Test
    public void testGivenWinnerNotCompletedBoardWhenIsFinishedThenTrue() {
        Board board = this.board
                .rows("RRYRYRY",
                        "RRYRYRY",
                        "RRYRYRY",
                        "R      ",
                        "       ",
                        "       ")
                .build();
        assertThat(board.isFinished(), is(true));
    }

    @Test
    public void testGivenWinnerBoardWhenIsWinnerThenTrue() {
        Board board = this.board
                .rows("RRYRYRY",
                        "RRYRYRY",
                        "RRYRYRY",
                        "R      ",
                        "       ",
                        "       ")
                .build();
        board.dropToken(0, Color.RED);
        assertThat(board.isWinner(), is(true));
    }

    @Test
    public void testGivenWinnerBoardWhenWinnerCoordinatesAreOcuppiedThenTrue() {
        Board board = this.board
                .rows("RRYRYRY",
                        "RRYRYRY",
                        "RRYRYRY",
                        "R      ",
                        "       ",
                        "       ")
                .build();
        assertThat(board.isOccupied(new Coordinate(0, 0), Color.RED), is(true));
        assertThat(board.isOccupied(new Coordinate(1, 0), Color.RED), is(true));
        assertThat(board.isOccupied(new Coordinate(2, 0), Color.RED), is(true));
        assertThat(board.isOccupied(new Coordinate(3, 0), Color.RED), is(true));
    }

    @Test
    public void testGivenEmptyBoardWhenIsWinnerThenFalse() {
        Board board = this.board.build();
        assertThat(board.isWinner(), is(false));
    }

    @Test
    public void testGivenBoardWhenDropTokenOutboundMaxThenThrowsAssertionError() {
        Board board = this.board.build();
        Assertions.assertThrows(AssertionError.class, () -> board.dropToken(Coordinate.NUMBER_COLUMNS, Color.RED));
    }

    @Test
    public void testGivenBoardWhenDropTokenOutboundMinThenThrowsAssertionError() {
        Board board = this.board.build();
        Assertions.assertThrows(AssertionError.class, () -> board.dropToken(-1, Color.RED));
    }

    @Test
    public void testGivenBoardWhenIsCopletedOutboundMaxThenThrowsAssertionError() {
        Board board = this.board.build();
        Assertions.assertThrows(AssertionError.class, () -> board.isComplete(Coordinate.NUMBER_COLUMNS));
    }

    @Test
    public void testGivenBoardWhenIsCopletedOutboundMinThenThrowsAssertionError() {
        Board board = this.board.build();
        Assertions.assertThrows(AssertionError.class, () -> board.isComplete(-1));
    }

    @Test
    public void testGivenNotEptyBoardWhenResetThenIsEmpty() {
        Board board = this.board
                .rows("R YRYRY",
                        "Y RYRYR",
                        "R      ",
                        "Y      ",
                        "R      ",
                        "Y      ")
                .build();
        board.reset();
        assertThat(board.isEmpty(), is(true));
    }

    @Test
    public void testGivenNotEptyBoardWhenResetThenIsReset() {
        Board board = this.board
                .rows("R YRYRY",
                        "Y RYRYR",
                        "R      ",
                        "Y      ",
                        "R      ",
                        "Y      ")
                .build();
        board.reset();
        assertThat(board.isReset(), is(true));
    }

    @Test
    public void testGivenEmptyBoardWhenColumnsIsEmprtyThenTrue() {
        Board board = this.board.build();
        assertThat(board.isEmpty(0), is(true));
        assertThat(board.isEmpty(1), is(true));
        assertThat(board.isEmpty(2), is(true));
        assertThat(board.isEmpty(3), is(true));
        assertThat(board.isEmpty(4), is(true));
        assertThat(board.isEmpty(5), is(true));
        assertThat(board.isEmpty(6), is(true));
    }

    @Test
    public void testGivenComletedBoardWhenGetUncompleteColumnsThenAssertionError() {
        Board board = this.board
                .rows("RRYRYRY",
                        "YYRYRYR",
                        "RRYRYRY",
                        "YYRYRYR",
                        "RRYRYRY",
                        "YYRYRYR")
                .build();
        Assertions.assertThrows(AssertionError.class, () -> board.getUncompletedColumns());
    }

    @Test
    public void testGivenUncompletedBoardWhenGetUncompletedColumnsThenReturnsExpectedColumns() {
        Board board = this.board
                .rows("RRYRYRY",
                        "YYRYRYR",
                        "RRYRYRY",
                        "YYRYRYR",
                        "RRYRYRY",
                        "Y Y R R")
                .build();
        assertThat(board.getUncompletedColumns(), is(new int[] { 1, 3, 5 }));
    }

    @Test
    public void testGivenBoardWhenRemoveTopThenTopIsRemoved() {
        Board board = this.board
                .rows("RRYRYRY",
                        "YYRYRYR",
                        "RRYRYRY",
                        "YYRYRYR",
                        "RRYRYRY",
                        "Y Y R R")
                .build();
        board.removeTop(0);
        assertThat(board.isEmpty(new Coordinate(5, 0)), is(true));
    }

    @Test
    public void testGivenBoardWhenGetTopThenReturnsTop() {
        Board board = this.board
                .rows("R R Y  ",
                        "       ",
                        "       ",
                        "       ",
                        "       ",
                        "       ")
                .build();
        board.removeTop(0);
        assertThat(board.isEmpty(new Coordinate(0, 0)), is(true));
    }

    @Test
    public void testGivenBoardWhenToStringArrayThenReturnsExpectedStringArray() {
        Board board = this.board
                .rows("R R Y  ",
                        "       ",
                        "       ",
                        "       ",
                        "       ",
                        "       ")
                .build();
        String[] expectedStringArray = new String[] { "Red", " ", "Red", " ", "Yellow", " ", " ",
                " ", " ", " ", " ", " ", " ", " ",
                " ", " ", " ", " ", " ", " ", " ",
                " ", " ", " ", " ", " ", " ", " ",
                " ", " ", " ", " ", " ", " ", " ",
                " ", " ", " ", " ", " ", " ", " ",
        };
        assertThat(board.toStringArray(), is(expectedStringArray));
    }

    @Test
    public void testGivenStringArrayWhenFromStringArrayThenReturnsExpectedBoard() {
        String[] stringArray = new String[] { "Red", " ", "Red", " ", "Yellow", " ", " ",
                " ", " ", " ", " ", " ", " ", " ",
                " ", " ", " ", " ", " ", " ", " ",
                " ", " ", " ", " ", " ", " ", " ",
                " ", " ", " ", " ", " ", " ", " ",
                " ", " ", " ", " ", " ", " ", " ",
        };
        Board board = Board.fromStringArray(stringArray);
        assertThat(board.isOccupied(new Coordinate(0, 0), Color.RED), is(true));
        assertThat(board.isOccupied(new Coordinate(0, 2), Color.RED), is(true));
        assertThat(board.isOccupied(new Coordinate(0, 4), Color.YELLOW), is(true));
    }

}
