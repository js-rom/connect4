package views;

import models.MachinePlayer;
import utils.Console;

public class RandomMachinePlayerView extends MachinePlayerView {

    public RandomMachinePlayerView(MachinePlayer player) {
        super(player);
        this.title = "Randomly";
    }
}
