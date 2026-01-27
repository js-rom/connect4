package com.jsrom.connect4.views.console.play;

import com.jsrom.connect4.controllers.core.PlayController;

public class UndoOption extends PlayOption {

    public UndoOption(PlayController playController) {
        super(playController, "Undo Last Move");
    }

    @Override
    public void interact() {
        ((PlayController) this.acceptorController).undo();
        super.interact();
    }

    @Override
    public boolean isActive() {
        return ((PlayController) this.acceptorController).undoable();
    }

}
