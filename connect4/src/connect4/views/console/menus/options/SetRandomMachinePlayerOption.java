package connect4.views.console.menus.options;

import connect4.controllers.Logic;

public class SetRandomMachinePlayerOption extends TurnOption {
    public SetRandomMachinePlayerOption(Logic model) {
        super("Easy Machine Player", model);
    }

    public void interact() {
        this.model.addPlayer(model.getUserPlayerPlayerType());
    }
}
