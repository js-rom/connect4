package com.jsrom.connect4.views.console.turn.player;

import com.jsrom.connect4.controllers.core.PlayController;

public class RandomMachinePlayerView extends MachinePlayerView {

    public RandomMachinePlayerView(PlayController playController) {
        super(playController, "Randomly");
    }

    public PlayerView copy() {
        return new RandomMachinePlayerView(this.playController);
    }
}
