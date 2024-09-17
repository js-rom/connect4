package connect4.views;

import connect4.models.MachinePlayer;
import connect4.models.Player;
import utils.views.Console;

public abstract class MachinePlayerView extends PlayerView {
    private String title;
    private MachinePlayer player;

    public MachinePlayerView(String title) {
        this.title = title;
    }

    public void setPlayer(Player player) {
        this.player = (MachinePlayer) player;
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

 /*    protected String getTitle() {
        return title;
    } */

    protected MachinePlayer getPlayer() {
        return player;
    }
}
