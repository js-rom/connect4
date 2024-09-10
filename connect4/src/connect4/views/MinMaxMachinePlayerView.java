package connect4.views;

import connect4.models.MachinePlayer;

public class MinMaxMachinePlayerView extends MachinePlayerView {

    public MinMaxMachinePlayerView() {
        super("IA");
    }

    public MinMaxMachinePlayerView(MachinePlayer player) {
        this();
        this.setPlayer(player);
    }

    public PlayerView copy() {
        return new MinMaxMachinePlayerView(this.getPlayer());
    }
}
