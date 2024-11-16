package connect4.views.graphics;

import connect4.types.PlayerType;

public class BoardViewPrototypeDirector {

    public BoardView get(BoardViewPrototypeRegistry boardViewRegistry, PlayerType type) {
        BoardView playerView = boardViewRegistry.getPlayerView(type);
        return playerView.copy();
    }
}
