package connect4.views;

import connect4.models.MachinePlayer;

public class RandomMachinePlayerView extends MachinePlayerView {

    public RandomMachinePlayerView(MachinePlayer player) {
        super(player, "Randomly");
    }
}
