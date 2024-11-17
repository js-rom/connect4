package connect4.views.graphics;

import java.util.HashMap;
import connect4.models.Game;
import connect4.types.PlayerType;

public class BoardViewPrototypeRegistry {

    private Game game;
    private HashMap<PlayerType, BoardView> playerBoardViews;

    public BoardViewPrototypeRegistry(Game game, PanelViewCommand callback) {
        this.game = game;
        this.playerBoardViews = new HashMap<PlayerType, BoardView>();

        BoardView boardView;
        boardView = new UserPlayerBoardView(this.game, callback);
        this.addPlayerView(PlayerType.USER_PLAYER, boardView);
        boardView = new MachinePlayerBoardView(this.game, callback);
        this.addPlayerView(PlayerType.RANDOM_MACHINE_PLAYER, boardView);
        this.addPlayerView(PlayerType.MIN_MAX_MACHINE_PLAYER, boardView);
    }

    private void addPlayerView(PlayerType type, BoardView playerView) {
        this.playerBoardViews.put(type, playerView);
    }

    public BoardView getPlayerView(PlayerType type) {
        return this.playerBoardViews.get(type);
    }
}
