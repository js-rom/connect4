package views;

import models.Player;

public abstract class PlayerView {

    private Player player;

    PlayerView(Player player) {
        this.player = player;
    }

    public void dropToken() {
        this.player.dropToken(this.getColumn());
    }

    public abstract int getColumn();

    public Player getActivePlayer() {
        return this.player;
    }
}
