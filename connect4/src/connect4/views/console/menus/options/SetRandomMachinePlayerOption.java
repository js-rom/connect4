package connect4.views.console.menus.options;

import connect4.controllers.core.StartController;

public class SetRandomMachinePlayerOption extends TurnOption {
    public SetRandomMachinePlayerOption(StartController startController) {
        super("Easy Machine Player", startController);
    }

    public void interact() {
        this.startController.addPlayer(startController.getRandomMachinePlayerType());
    }
}
