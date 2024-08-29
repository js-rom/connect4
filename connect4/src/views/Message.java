package views;

import utils.console.Console;

public class Message {

    public static Message TITLE = new Message("--- CONNECT 4 ---");
    public static Message NUM_PLAYERS = new Message("Enter number of users: ");
    public static Message HORIZONTAL_LINE = new Message("-");
    public static Message VERTICAL_LINE = new Message("|");
    public static Message TURN = new Message("Turn: ");
    public static Message ENTER_COLUMN_TO_DROP = new Message("Enter a column to drop a token: ");
    public static Message INVALID_COLUMN = new Message("Invalid columnn!!! Values [1-7]");
    public static Message COMPLETED_COLUMN = new Message("Invalid column!!! It's completed");
    public static Message PLAYER_WIN = new Message("#colorS WIN!!! : -)");
    public static Message PLAYERS_TIED = new Message("TIED!!!");
    public static Message RESUME = new Message("Do you want to continue");

    private String string;

    public Message(String string) {
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
