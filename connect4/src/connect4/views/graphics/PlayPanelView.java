package connect4.views.graphics;

import java.awt.BorderLayout;
import java.util.concurrent.CountDownLatch;

import connect4.controllers.core.PlayController;
import connect4.views.graphics.commands.NextTurnCommand;
import connect4.views.graphics.commands.RedoMachinePlayerCommand;
import connect4.views.graphics.commands.RedoUserPlayerCommand;
import connect4.views.graphics.commands.UndoMachinePlayerCommand;
import connect4.views.graphics.commands.UndoUserPlayerCommand;

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
        this.turnView.setUndoCommand(new UndoMachinePlayerCommand(this));
        this.turnView.setRedoComand(new RedoMachinePlayerCommand(this));
        machinePlayerBoardView.write();
        machinePlayerBoardView.dropToken();
    }

    public void visit(UserPlayerBoardView userPlayerBoardView) {
        this.turnView.setUndoCommand(new UndoUserPlayerCommand(this));
        this.turnView.setRedoComand(new RedoUserPlayerCommand(this));
        userPlayerBoardView.write();
    }

    public void undo(UndoMachinePlayerCommand undoMachinePlayerCommand) {
        if (this.playController.undoable()) {
            ((MachinePlayerBoardView) this.boardView).interruptDropToken();
            this.undo();
        }
    }

    public void undo(UndoUserPlayerCommand undoUserPlayerCommand) {
        if (this.playController.undoable()) {
            this.undo();
        }
    }

    private void undo() {
        assert this.playController.undoable();
        this.playController.undo();
        this.write();
    }

    public void redo(RedoUserPlayerCommand redoUserPlayerCommand) {
        this.redo();
    }

    public void redo(RedoMachinePlayerCommand redoMachinePlayerCommand) {
        ((MachinePlayerBoardView) this.boardView).interruptDropToken();
        this.redo();
    }

    private void redo() {
        assert this.playController.redoable();
        this.playController.redo();
        this.write();
    }

}
