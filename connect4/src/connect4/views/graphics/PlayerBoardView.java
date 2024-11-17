package connect4.views.graphics;

import connect4.models.Game;
import connect4.models.Player;

public abstract class PlayerBoardView extends BoardView {

    private PanelViewCommand callback;

    public PlayerBoardView(Game game, PanelViewCommand callback) {
        super(game);
        this.callback = callback;
    }

    public PlayerBoardView(Game game, PanelViewCommand callback, Player player) {
        this(game, callback);
        this.setPlayer(player);
    }

    public abstract void setPlayer(Player player);

    public PanelViewCommand getCallback() {
        return this.callback;
    }
}
