package views;

import models.MachinePlayer;
import models.Player;
import utils.console.Console;

public class MachinePlayerView extends PlayerView {

    public MachinePlayerView(MachinePlayer player) {
        super(player);
    }

    public int getColumn() {
        int column = this.getActivePlayer().getColumn();
        Console.getInstance().writeln("Columna escogida aleatoriamente: " + column);
        return column;
    }
}
