package connect4.views.graphics;

import java.awt.BorderLayout;
import java.util.concurrent.CountDownLatch;

import connect4.controllers.PlayController;
import connect4.views.graphics.commands.NextTurnCommand;

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
    }

    @Override
    public void write() {
        if (!this.playController.isFinished()) {
            this.removeBoard();
            BoardViewPrototypeRegistry boardViewPrototypeRegistry = new BoardViewPrototypeRegistry(playController,
                new NextTurnCommand(this));
            this.boardView = new BoardViewPrototypeDirector().get(boardViewPrototypeRegistry,
                    this.playController.getActivePlayerType());
            this.turnView.write();
            this.boardView.accept(this);
            this.removeAll();
            this.setLayout(new BorderLayout());
            this.add(this.turnView, BorderLayout.WEST);
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
        machinePlayerBoardView.write();
        machinePlayerBoardView.dropToken();
    }

    public void visit(UserPlayerBoardView userPlayerBoardView) {
        userPlayerBoardView.write();
    }

}
