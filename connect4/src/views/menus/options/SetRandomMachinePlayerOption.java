package views.menus.options;

import models.Turn;

public class SetRandomMachinePlayerOption extends TurnOption {
    public SetRandomMachinePlayerOption(Turn model) {
        super("Easy Machine Player", model);
    }

    public void interact() {
        this.model.setRandomMachinePlayer();
    }
}
