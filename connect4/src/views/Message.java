package views;

import utils.Console;

enum Message {

    TITLE("--- CONNECT 4 ---"),
    NUM_PLAYERS("Enter number of users: "),
    HORIZONTAL_LINE("-"),
    VERTICAL_LINE("|"),
    TURN("Turn: "),
    ENTER_COLUMN_TO_DROP("Enter a column to drop a token: "),
    INVALID_COLUMN("Invalid columnn!!! Values [1-7]"), // TODO reemplzar 1 y 7 por // valor de las constantes
    COMPLETED_COLUMN("Invalid column!!! It's completed"),
    PLAYER_WIN("#colorS WIN!!! : -)"),
    PLAYERS_TIED("TIED!!!"),
    RESUME("Do you want to continue");

    private String string;

    private Message(String string) {
        this.string = string;
    }

    public void write() {
        Console.getInstance().write(this.string);
    }

    public void writeln() {
        Console.getInstance().writeln(this.string);
    }

    public String toString() {
        return this.string;
    }

}
