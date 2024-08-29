package models;

public class Game {

    private Board board;
    private Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void reset(int userplayers) {
        this.board.reset();
        this.turn.reset(userplayers);
    }

    public Color getColor (coordinate coordinate) {

        return this.board.getColor(coordinate);
    }

    public boolean isWinner() {
        return this.board.isWinner();
    }

    public boolean isFinished() {
        return this.board.isFinished();
    }

    public Player getActivePlayer(){ // OJO que cabrón polimorfico es este
        return this.turn.getActivePlayer();
    }

    public Color getActiveColor(){
        return this.getActivePlayer().getColor();
    }

    public void next(){
        this.turn.next();
    }

}
