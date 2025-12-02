package connect4.views.graphics.gameLoop.play;

import java.awt.BorderLayout;
import java.util.concurrent.CountDownLatch;

import connect4.controllers.core.PlayController;
import connect4.views.graphics.gameLoop.GameLoopView;
import connect4.views.graphics.gameLoop.play.board.BoardView;
import connect4.views.graphics.gameLoop.play.board.BoardViewPrototypeDirector;
import connect4.views.graphics.gameLoop.play.board.BoardViewPrototypeRegistry;
import connect4.views.graphics.gameLoop.play.board.MachinePlayerBoardView;
import connect4.views.graphics.gameLoop.play.board.UserPlayerBoardView;
import connect4.views.graphics.gameLoop.play.commands.NextTurnCommand;
import connect4.views.graphics.gameLoop.play.commands.PlayPanelViewVisitor;
import connect4.views.graphics.gameLoop.play.commands.RedoMachinePlayerCommand;
import connect4.views.graphics.gameLoop.play.commands.RedoUserPlayerCommand;
import connect4.views.graphics.gameLoop.play.commands.UndoMachinePlayerCommand;
import connect4.views.graphics.gameLoop.play.commands.UndoUserPlayerCommand;

public class PlayPanelView extends GameLoopView implements PlayPanelViewVisitor {

    private PlayController playController;
    private CountDownLatch latch;
    protected BoardView boardView;
    protected TurnView turnView;

    public PlayPanelView(PlayController playController, CountDownLatch latch) {
        assert (playController != null);
        this.setLayout(new BorderLayout());
        this.playController = playController;
        this.latch = latch;
        this.turnView = new TurnView(playController);
        this.playController.registerMemento();
    }

    @Override
    public void write() {
        if (!this.playController.isFinished()) {
            this.removeBoard();
            BoardViewPrototypeRegistry boardViewPrototypeRegistry = new BoardViewPrototypeRegistry(playController,
                    new NextTurnCommand(this));
            this.boardView = new BoardViewPrototypeDirector().get(boardViewPrototypeRegistry,
                    this.playController.getActivePlayerType());
            this.boardView.accept(this);
            this.turnView.write();
            this.removeAll();
            this.setLayout(new BorderLayout());
            this.add(this.turnView, BorderLayout.NORTH);
            this.add(this.boardView, BorderLayout.CENTER);
            this.getParent().revalidate();
            this.getParent().repaint();
        } else {
            this.playController.nextState();
            this.latch.countDown();
        }
    }

    private void removeBoard() {
        if (this.boardView != null) {
            this.remove(this.boardView);
        }
    }

    public void visit(MachinePlayerBoardView machinePlayerBoardView) {
        this.turnView = new TurnFactory().createMachineTurnView(this.playController, this);
        machinePlayerBoardView.write();
        machinePlayerBoardView.dropToken();
    }

    public void visit(UserPlayerBoardView userPlayerBoardView) {
        this.turnView = new TurnFactory().createUserTurnView(this.playController, this);
        userPlayerBoardView.write();
    }

    public void interruptDropToken() {
        ((MachinePlayerBoardView) this.boardView).interruptDropToken();
    }

    public boolean undoable() {
        return this.playController.undoable();
    }

    public void undo() {
        assert this.playController.undoable();
        this.playController.undo();
        this.write();
    }

    public void redo() {
        assert this.playController.redoable();
        this.playController.redo();
        this.write();
    }

}
