package connect4.views.graphics.gameLoop.play.panel.board;

import connect4.types.PlayerType;

public class BoardViewPrototypeDirector {

    public BoardView get(BoardViewPrototypeRegistry boardViewRegistry, PlayerType type) {
        return boardViewRegistry.getPlayerView(type);
    }
}
