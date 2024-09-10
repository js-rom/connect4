package connect4.views.menus.options;

import connect4.models.Turn;

public class SetRandomMachinePlayerOption extends TurnOption {
    public SetRandomMachinePlayerOption(Turn model) {
        super("Easy Machine Player", model);
    }

    public void interact() {
        this.model.setRandomMachinePlayer();
    }
}
