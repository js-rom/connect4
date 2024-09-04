package views;

import models.MachinePlayer;

public class MinMaxMachinePlayerView extends MachinePlayerView {

    public MinMaxMachinePlayerView(MachinePlayer player) {
        super(player);
        this.title = "IA";
    }
}
