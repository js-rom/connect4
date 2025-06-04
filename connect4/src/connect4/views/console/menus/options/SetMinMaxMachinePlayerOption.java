package connect4.views.console.menus.options;

import connect4.controllers.StartController;

public class SetMinMaxMachinePlayerOption extends TurnOption {

    public SetMinMaxMachinePlayerOption(StartController startController) {
        super("Dificult Machine Player", startController);
    }

    public void interact() {
        this.startController.addPlayer(startController.getMinMaxMachinePlayerType());
    }
}
