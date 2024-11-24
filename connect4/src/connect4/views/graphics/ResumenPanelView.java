package connect4.views.graphics;

import java.awt.BorderLayout;
import connect4.controllers.Logic;

public class ResumenPanelView extends GameLoopView {

    private Logic logic;
    protected BoardView boardView;
    protected TurnView turnView;

    public ResumenPanelView(Logic logic) {
        assert (logic != null);
        this.setLayout(new BorderLayout());
        this.logic = logic;
        this.turnView = new TurnView(this.logic);
    }

    @Override
    public void write() {
        assert (this.logic != null);
        this.boardView = new PauseBoardView(this.logic);
        this.turnView.write();
        this.boardView.write();
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(this.turnView, BorderLayout.WEST);
        this.add(this.boardView, BorderLayout.CENTER);
    }

    protected Logic getLogic() {
        assert (this.logic != null);
        return this.logic;
    }
}
