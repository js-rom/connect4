package connect4.views.graphics.gameLoop.play;

import connect4.controllers.core.PlayController;
import connect4.views.graphics.gameLoop.play.board.BoardView;
import connect4.views.graphics.gameLoop.play.board.BoardViewPrototypeDirector;
import connect4.views.graphics.gameLoop.play.board.BoardViewPrototypeRegistry;
import connect4.views.graphics.gameLoop.play.commands.NextTurnCommand;
import connect4.views.graphics.gameLoop.play.commands.PlayPanelViewVisitor;

public class BoardViewFactory {

    private PlayController playController;

    public BoardViewFactory(PlayController playController) {
        this.playController = playController;
    }

    public BoardView createBoardView(PlayPanelViewVisitor visitor) {
        BoardViewPrototypeRegistry boardViewPrototypeRegistry = new BoardViewPrototypeRegistry(this.playController,
                new NextTurnCommand(visitor));
        BoardView board = new BoardViewPrototypeDirector().get(boardViewPrototypeRegistry,
                this.playController.getActivePlayerType());
        return board;
    }

}
