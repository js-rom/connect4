package connect4.views.console.play;

import connect4.controllers.core.PlayController;

public class UndoOption extends PlayOption {

    public UndoOption(PlayController playController) {
        super(playController, "Undo Last Move");
    }

    @Override
    public void interact() {
       this.playController.undo();
    super.interact();
    }

    @Override
    public boolean isActive() {
       return this.playController.undoable();
    }

}
