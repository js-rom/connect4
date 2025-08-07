package connect4.views.console.turn.player;

import connect4.controllers.core.PlayController;

public class MinMaxMachinePlayerView extends MachinePlayerView {

    public MinMaxMachinePlayerView(PlayController playController) {
        super(playController, "IA");
    }

    public PlayerView copy() {
        return new MinMaxMachinePlayerView(this.playController);
    }
}
