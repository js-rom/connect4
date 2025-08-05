package connect4.views.console.menus.play;

import connect4.controllers.core.PlayController;

public class RedoOption extends PlayOption {

    public RedoOption(PlayController playController) {
        super(playController, "Redo Last Move");
    }

    @Override
    public void interact() {
        this.playController.redo();
        super.interact();
    }

    @Override
    public boolean isActive() {
        return this.playController.redoable();
    }

}
