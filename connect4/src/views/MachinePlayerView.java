package views;

import models.MachinePlayer;
import utils.console.Console;

public class MachinePlayerView implements PlayerView {

    private MachinePlayer player;

    public MachinePlayerView(MachinePlayer player) {
        this.player = player;
    }

    public int getColumn() {
        int column = this.player.getColumn();
        Console.getInstance().writeln("Columna escogida aleatoriamente: " + column);
        return column;
    }

    public void dropToken() {
        this.player.dropToken(this.getColumn());
    }

}
