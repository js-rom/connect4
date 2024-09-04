package views;

import models.MachinePlayer;
import utils.Console;

public abstract class MachinePlayerView extends PlayerView {
    private String title;
    private MachinePlayer player;

    public MachinePlayerView(MachinePlayer player, String title) {
        this.player = player;
        this.title = title;
    }

    public int getColumn() {
        int column = this.player.getColumn();
        this.writeChoosenColumn(column);
        return column;
    }

    private void  writeChoosenColumn(int column) {
        String message = Message.CHOOSEN_COLUMN.toString();
        message = message.replace("#METHOD", this.title);
        message = message.replace("#COLUMN", String.valueOf(column + 1));
        Console.getInstance().writeln(message);
    };

    public void dropToken() {
        this.player.dropToken(this.getColumn());
    }
}
