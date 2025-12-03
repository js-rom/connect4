package connect4.views.graphics.gameLoop.play.panel.board;

import connect4.controllers.core.PlayController;
import connect4.views.graphics.gameLoop.play.panel.commands.Command;

public class BoardViewFactory {

    private PlayController playController;
    Command nextTurnCommand;

    public BoardViewFactory(PlayController playController, Command nextTurnCommand) {
        this.playController = playController;
        this.nextTurnCommand = nextTurnCommand;
    }

    public BoardView createBoardView() {
        BoardViewPrototypeRegistry boardViewPrototypeRegistry = new BoardViewPrototypeRegistry(this.playController,
                nextTurnCommand);
        BoardView board = new BoardViewPrototypeDirector().get(boardViewPrototypeRegistry,
                this.playController.getActivePlayerType());
        return board;
    }

}
