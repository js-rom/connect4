package views;

import models.MachinePlayer;

public class RandomMachinePlayerView extends MachinePlayerView {

    public RandomMachinePlayerView(MachinePlayer player) {
        super(player);
        this.title = "Randomly";
    }
}
