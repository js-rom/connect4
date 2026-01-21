package com.jsrom.connect4.views.console.play;

import com.jsrom.connect4.controllers.core.PlayController;

public class RedoOption extends PlayOption {

    public RedoOption(PlayController playController) {
        super(playController, "Redo Last Move");
    }

    @Override
    public void interact() {
        ((PlayController) this.acceptorController).redo();
        super.interact();
    }

    @Override
    public boolean isActive() {
        return ((PlayController) this.acceptorController).redoable();
    }

}
