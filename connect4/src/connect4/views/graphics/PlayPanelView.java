package connect4.views.graphics;

import java.awt.BorderLayout;
import connect4.controllers.PlayController;
import connect4.views.graphics.commands.NextTurnCommand;

public class PlayPanelView extends ResumenPanelView implements PlayPanelViewVisitor {

    private BoardViewPrototypeRegistry boardViewPrototypeRegistry;

    public PlayPanelView(PlayController playController) {
        super(playController);
        assert (playController != null);
        this.boardViewPrototypeRegistry = new BoardViewPrototypeRegistry(this.getPlayController(),
                new NextTurnCommand(this));
    }

    @Override
    public void write() {
        if (!this.getPlayController().isFinished()) {
            this.removeBoard();
            this.boardView = new BoardViewPrototypeDirector().get(this.boardViewPrototypeRegistry,
                    this.getPlayController().getActivePlayerType());
            this.turnView.write();
            this.boardView.accept(this);
            this.removeAll();
            this.setLayout(new BorderLayout());
            this.add(this.turnView, BorderLayout.WEST);
            this.add(this.boardView, BorderLayout.CENTER);
            this.getParent().revalidate();
            this.getParent().repaint();
        } else {
            this.getCallback().execute();
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

    public void visit(PauseBoardView pauseBoardView) {
        pauseBoardView.write();
    }

}
