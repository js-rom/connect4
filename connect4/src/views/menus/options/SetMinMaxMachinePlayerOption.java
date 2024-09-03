package views.menus.options;

import models.Turn;

public class SetMinMaxMachinePlayerOption extends TurnOption {

    public SetMinMaxMachinePlayerOption(Turn model) {
        super("Dificult Machine Player", model);
    }

    public void interact() {
        this.model.setMinMaxMachinePlayer();
    }
}
