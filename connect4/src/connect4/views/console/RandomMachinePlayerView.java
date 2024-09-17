package connect4.views.console;

import connect4.models.MachinePlayer;

public class RandomMachinePlayerView extends MachinePlayerView {

    public RandomMachinePlayerView() {
        super("Randomly");
    }

    public RandomMachinePlayerView(MachinePlayer player) {
        this();
        this.setPlayer(player);
    }

    public PlayerView copy() {
        return new RandomMachinePlayerView(this.getPlayer());
    }
}
