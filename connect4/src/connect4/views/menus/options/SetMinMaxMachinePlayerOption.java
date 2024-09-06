package connect4.views.menus.options;

import connect4.models.Turn;

public class SetMinMaxMachinePlayerOption extends TurnOption {

    public SetMinMaxMachinePlayerOption(Turn model) {
        super("Dificult Machine Player", model);
    }

    public void interact() {
        this.model.setMinMaxMachinePlayer();
    }
}
