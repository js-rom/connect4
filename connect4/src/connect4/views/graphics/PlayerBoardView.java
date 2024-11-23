package connect4.views.graphics;

import connect4.controllers.PlayController;
import connect4.models.Player;

public abstract class PlayerBoardView extends BoardView {

    private PanelViewCommand callback;

    public PlayerBoardView(PlayController playController, PanelViewCommand callback) {
        super(playController);
        assert (playController != null && callback != null);
        this.callback = callback;

    }

    public PlayerBoardView(PlayController playController, PanelViewCommand callback, Player player) {
        this(playController, callback);
        assert (player != null);
        this.setPlayer(player);
    }

    public abstract void setPlayer(Player player);

    public PanelViewCommand getCallback() {
        return this.callback;
    }

}
