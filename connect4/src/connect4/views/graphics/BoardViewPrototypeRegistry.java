package connect4.views.graphics;

import java.util.EnumMap;
import java.util.Map;

import connect4.controllers.PlayController;
import connect4.types.PlayerType;

public class BoardViewPrototypeRegistry {

    private Map<PlayerType, BoardView> playerBoardViews;

    public BoardViewPrototypeRegistry(PlayController playController, PanelViewCommand nextTurnCommand) {
        assert (playController != null);
        this.playerBoardViews = new EnumMap<>(PlayerType.class);

        BoardView boardView;
        boardView = new UserPlayerBoardView(playController, nextTurnCommand);
        this.addPlayerView(PlayerType.USER_PLAYER, boardView);
        boardView = new MachinePlayerBoardView(playController, nextTurnCommand);
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
