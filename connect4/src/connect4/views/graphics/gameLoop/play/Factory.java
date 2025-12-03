package connect4.views.graphics.gameLoop.play;

import java.util.concurrent.CountDownLatch;

import connect4.controllers.core.PlayController;
import connect4.views.graphics.gameLoop.play.panel.PlayPanelView;
import connect4.views.graphics.gameLoop.play.panel.board.BoardViewFactory;
import connect4.views.graphics.gameLoop.play.panel.commands.NextTurnCommand;
import connect4.views.graphics.gameLoop.play.panel.commands.RedoMachinePlayerCommand;
import connect4.views.graphics.gameLoop.play.panel.commands.RedoUserPlayerCommand;
import connect4.views.graphics.gameLoop.play.panel.commands.UndoMachinePlayerCommand;
import connect4.views.graphics.gameLoop.play.panel.commands.UndoUserPlayerCommand;
import connect4.views.graphics.gameLoop.play.panel.turn.TurnViewFactory;

public class Factory {

    PlayController playController;
    CountDownLatch latch;
    PlayPanelView playPanelView;

    public Factory(PlayController playController, CountDownLatch latch) {
        this.playController = playController;
        this.latch = latch;
        this.playPanelView = new PlayPanelView(this.playController,
                this.latch);
        this.playPanelView.associate(this.createBoardViewFactory());
        this.playPanelView.associate(this.createTurnViewFactory());
    }

    public PlayPanelView createPlayPanelView() {
        return this.playPanelView;
    }

    private BoardViewFactory createBoardViewFactory() {
        NextTurnCommand nextTurnCommand = new NextTurnCommand(this.playPanelView);
        BoardViewFactory boardViewFactory = new BoardViewFactory(this.playController, nextTurnCommand);
        return boardViewFactory;
    }

    private TurnViewFactory createTurnViewFactory() {
        TurnViewFactory turnViewFactory = new TurnViewFactory(this.playController);
        turnViewFactory.setUndoMachinePlayerCommand(new UndoMachinePlayerCommand(this.playPanelView));
        turnViewFactory.setRedoMachinePlayerCommand(new RedoMachinePlayerCommand(this.playPanelView));
        turnViewFactory.setUndoUserPlayerCommand(new UndoUserPlayerCommand(this.playPanelView));
        turnViewFactory.setRedoUserPlayerCommand(new RedoUserPlayerCommand(this.playPanelView));
        return turnViewFactory;
    }
}
