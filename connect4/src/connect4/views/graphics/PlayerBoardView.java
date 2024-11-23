package connect4.views.graphics;

import connect4.controllers.Logic;

public abstract class PlayerBoardView extends BoardView {

    private PanelViewCommand callback;

    public PlayerBoardView(Logic logic, PanelViewCommand callback) {
        super(logic);
        assert (logic != null && callback != null);
        this.callback = callback;

    }

    public PanelViewCommand getCallback() {
        return this.callback;
    }

}
