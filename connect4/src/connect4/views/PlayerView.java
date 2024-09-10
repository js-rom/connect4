package connect4.views;

import connect4.models.Player;

public abstract class PlayerView {

    protected abstract int getColumn();
    public abstract void dropToken();
    public abstract void setPlayer(Player player);
    public abstract PlayerView copy();

}
