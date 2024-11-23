package connect4.views.graphics;

import java.util.HashMap;
import connect4.controllers.Logic;
import connect4.types.PlayerType;

public class BoardViewPrototypeRegistry {

    private HashMap<PlayerType, PlayerBoardView> playerBoardViews;

    public BoardViewPrototypeRegistry(Logic logic, PanelViewCommand callback) {
        assert (logic != null);
        this.playerBoardViews = new HashMap<PlayerType, PlayerBoardView>();

        PlayerBoardView boardView;
        boardView = new UserPlayerBoardView(logic, callback);
        this.addPlayerView(PlayerType.USER_PLAYER, boardView);
        boardView = new MachinePlayerBoardView(logic, callback);
        this.addPlayerView(PlayerType.RANDOM_MACHINE_PLAYER, boardView);
        this.addPlayerView(PlayerType.MIN_MAX_MACHINE_PLAYER, boardView);
    }

    private void addPlayerView(PlayerType type, PlayerBoardView playerView) {
        this.playerBoardViews.put(type, playerView);
    }

    public BoardView getPlayerView(PlayerType type) {
        return this.playerBoardViews.get(type);
    }
}
