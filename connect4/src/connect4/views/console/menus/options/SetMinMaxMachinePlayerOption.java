package connect4.views.console.menus.options;

import connect4.controllers.Logic;

public class SetMinMaxMachinePlayerOption extends TurnOption {

    public SetMinMaxMachinePlayerOption(Logic model) {
        super("Dificult Machine Player", model);
    }

    public void interact() {
        this.model.addPlayer(model.getMinMaxMachinePlayerType());
    }
}
