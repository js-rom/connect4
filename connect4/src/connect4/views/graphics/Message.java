package connect4.views.graphics;

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
    RESUME("Do you want to continue"),
    CHOOSEN_COLUMN("#METHOD choosen column: #COLUMN"),
    SAVE_GAME("Would you like to save the current game?"),
    ENTER_GAME_NAME("Enter the name of the game: "),
    NAME_ALREADY_EXISTS("The name already exists");

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
