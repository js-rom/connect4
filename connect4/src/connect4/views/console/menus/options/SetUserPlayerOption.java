package connect4.views.console.menus.options;

import connect4.controllers.core.StartController;

public class SetUserPlayerOption extends TurnOption {

    public SetUserPlayerOption(StartController startController) {
        super("Human player", startController);
    }

    public void interact() {
        this.startController.addPlayer(startController.getUserPlayerPlayerType());
    }

}
