package connect4.views.graphics;

import java.awt.BorderLayout;
import connect4.controllers.PlayController;


public class ResumenPanelView extends GameLoopView {

    private PlayController playController;
    protected BoardView boardView;
    protected TurnView turnView;

    public ResumenPanelView(PlayController playController) {
        assert(playController != null);
        this.setLayout(new BorderLayout());
        this.playController = playController;
        this.turnView = new TurnView(this.playController);
    }


    @Override
    public void write() {
        assert(this.playController != null);
        this.boardView = new PauseBoardView(this.playController);
        this.turnView.write();
        this.boardView.write();
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(this.turnView, BorderLayout.WEST);
        this.add(this.boardView, BorderLayout.CENTER);
    }

    protected PlayController getPlayController() {
        assert(this.playController != null);
        return this.playController;
    }
}
