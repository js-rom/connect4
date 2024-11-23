package connect4.views.graphics;

import connect4.controllers.PlayController;

public abstract class PlayerBoardView extends BoardView {

    private PanelViewCommand callback;

    public PlayerBoardView(PlayController playController, PanelViewCommand callback) {
        super(playController);
        assert (playController != null && callback != null);
        this.callback = callback;

    }

    public PanelViewCommand getCallback() {
        return this.callback;
    }

}
