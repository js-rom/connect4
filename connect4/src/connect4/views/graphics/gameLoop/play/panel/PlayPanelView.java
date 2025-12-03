package connect4.views.graphics.gameLoop.play.panel;

import java.awt.BorderLayout;
import java.util.concurrent.CountDownLatch;

import connect4.controllers.core.PlayController;
import connect4.views.graphics.gameLoop.GameLoopView;
import connect4.views.graphics.gameLoop.play.panel.board.BoardView;
import connect4.views.graphics.gameLoop.play.panel.board.BoardViewFactory;
import connect4.views.graphics.gameLoop.play.panel.board.BoardVisitor;
import connect4.views.graphics.gameLoop.play.panel.board.MachinePlayerBoardView;
import connect4.views.graphics.gameLoop.play.panel.board.UserPlayerBoardView;
import connect4.views.graphics.gameLoop.play.panel.turn.TurnView;
import connect4.views.graphics.gameLoop.play.panel.turn.TurnViewFactory;

public class PlayPanelView extends GameLoopView implements BoardVisitor {

    private PlayController playController;
    private CountDownLatch latch;
    protected BoardView boardView;
    protected BoardViewFactory boardViewFactory;
    protected TurnViewFactory turnViewFactory;
    protected TurnView turnView;

    public PlayPanelView(PlayController playController, CountDownLatch latch) {
        assert (playController != null);
        this.setLayout(new BorderLayout());
        this.playController = playController;
        this.latch = latch;
        //this.turnView = new TurnView(playController);
        this.playController.registerMemento();
    }

    public void associate(BoardViewFactory boardViewFactory) {
        this.boardViewFactory = boardViewFactory;
    }

    public void associate(TurnViewFactory turnViewFactory) {
        this.turnViewFactory = turnViewFactory;
    }

    @Override
    public void write() {
        if (!this.playController.isFinished()) {
            this.removeBoard();
            this.boardView = this.boardViewFactory.createBoardView();
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
        this.turnView = this.turnViewFactory.createMachineTurnView();
        machinePlayerBoardView.write();
        machinePlayerBoardView.dropToken();
    }

    public void visit(UserPlayerBoardView userPlayerBoardView) {
        this.turnView = this.turnViewFactory.createUserTurnView();
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
