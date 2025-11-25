package connect4.models;

import connect4.types.Color;
import connect4.types.PlayerType;
import utils.models.Coordinate;

public class Game {

    private Board board;
    private Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public Memento createMemento() {
        return new Memento(this.board, this.turn);
    }

    public void setMemento(Memento memento) {
        assert memento != null;
        //TODO set boar values instead of creating a new board and losing references
        this.board = memento.getBoard();
        this.turn.setBoard(this.board);
        this.turn.setActivePlayer(memento.getActivePlayer());
    } 

    public void reset() {
        this.board.reset();
        this.turn.reset();
    }

    public boolean isReset() {
        return this.board.isReset() & this.turn.isReset();
    }

    public Color getColor(Coordinate coordinate) {
        assert coordinate != null;
        return this.board.getColor(coordinate);
    }

    public boolean isWinner() {
        return this.board.isWinner();
    }

    public boolean isFinished() {
        return this.board.isFinished();
    }

    public Player getActivePlayer() {
        return this.turn.getActivePlayer();
    }

    public PlayerType getActivePlayerType() {
        return this.getActivePlayer().getType();
    }

    public String getPlayerTypeName(int index) {
        return this.turn.getPlayerTypeName(index);
    }

    public int getActivePlayerIndex() {
        return this.turn.getActivePlayerIndex();
    }

    public void setActivePlayer(int index) {
        this.turn.setActivePlayer(index);
    }

    public Color getActiveColor() {
        return this.getActivePlayer().getColor();
    }

    public String getPlayerColorName(int index) {
        return this.turn.getPlayerColorName(index);
    }

    public void next() {
        assert !this.isFinished();
        this.turn.next();
    }

    public int getNumberPlayers() {
        return Turn.NUMBER_PLAYERS;
    }

    public void addPlayer(PlayerType playerType) {
        this.turn.addPlayer(playerType);
    }

    public boolean isComplete(int column) {
        return this.board.isComplete(column);
    }

    public String[] getBoardColors() {
        return this.board.toStringArray();
    }

    public void setBoardColors(String[] boardColors) {
        this.board.setColors(boardColors);
    }

    public Coordinate getLastDrop() {
        return this.board.getLastDrop();
    }

    public void setLastDrop(Coordinate lastDrop) {
        this.board.setLastDrop(lastDrop);
    }

    public int getPlayersSize() {
        return this.turn.getPlayersSize();
    }

    public void setPlayersSize(int size) {
        this.turn.setPlayersSize(size);
    }
}
