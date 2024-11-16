package connect4.views.graphics;

import connect4.models.Game;
import connect4.models.Player;
import connect4.views.graphics.commands.Command;

public abstract class PlayerBoardView extends BoardView {

    public PlayerBoardView(Game game, Command callback) {
        super(game, callback);
    }

    public PlayerBoardView(Game game, Command callback, Player player) {
        this(game, callback);
        this.setPlayer(player);
    }

    public abstract void setPlayer(Player player);
}
