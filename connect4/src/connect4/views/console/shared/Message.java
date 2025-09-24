package connect4.views.console.shared;

import utils.views.Console;

public enum Message {

    TITLE("--- CONNECT 4 ---"),
    NUM_PLAYERS("Enter number of users: "),
    HORIZONTAL_LINE("-"),
    VERTICAL_LINE("|"),
    TURN("Turn: "),
    ENTER_COLUMN_TO_DROP("Enter a column to drop a token: "),
    INVALID_COLUMN("Invalid columnn!!! Values [1-#maxColumns]"),
    COMPLETED_COLUMN("Invalid column!!! It's completed"),
    PLAYER_WIN("#colorS WIN!!! : -)"),
    PLAYERS_TIED("TIED!!!"),
    SAVE("Do you want to save the game"),
    NAME("Enter the name of the game: "),
    NAME_ALREADY_EXISTS("The name already exists"),
    RESUME("Do you want to continue"),
    CHOOSEN_COLUMN("#METHOD choosen column: #COLUMN"),
    GAME_SELECTED("Game selected: #NAME");

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
