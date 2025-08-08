package connect4.views.console.turn.player;

import connect4.controllers.core.PlayController;

public abstract class PlayerView {

    protected PlayController playController;

    public PlayerView(PlayController playController) {
        this.playController = playController;
    }

    protected abstract int getColumn();
    public abstract void dropToken();
    public abstract PlayerView copy();

}
