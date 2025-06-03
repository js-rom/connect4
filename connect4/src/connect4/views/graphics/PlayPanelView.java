package connect4.views.graphics;

import java.awt.BorderLayout;
import connect4.controllers.Logic;
import connect4.views.graphics.commands.NextTurnCommand;

public class PlayPanelView extends GameLoopView implements PlayPanelViewVisitor {

    private Logic logic;
    protected BoardView boardView;
    protected TurnView turnView;
    private BoardViewPrototypeRegistry boardViewPrototypeRegistry;

    public PlayPanelView(Logic logic) {
        assert (logic != null);
        this.setLayout(new BorderLayout());
        this.logic = logic;
        this.turnView = new TurnView(this.logic);
        this.boardViewPrototypeRegistry = new BoardViewPrototypeRegistry(this.getLogic(),
                new NextTurnCommand(this));
    }

    @Override
    public void write() {
        if (!this.getLogic().isFinished()) {
            this.removeBoard();
            this.boardView = new BoardViewPrototypeDirector().get(this.boardViewPrototypeRegistry,
                    this.getLogic().getActivePlayerType());
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

        protected Logic getLogic() {
        assert (this.logic != null);
        return this.logic;
    }

    public void visit(MachinePlayerBoardView machinePlayerBoardView) {
        machinePlayerBoardView.write();
        machinePlayerBoardView.dropToken();
    }

    public void visit(UserPlayerBoardView userPlayerBoardView) {
        userPlayerBoardView.write();
    }

}
