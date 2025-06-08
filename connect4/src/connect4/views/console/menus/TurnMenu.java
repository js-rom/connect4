package connect4.views.console.menus;

import connect4.controllers.StartController;
import connect4.views.console.menus.options.SetMinMaxMachinePlayerOption;
import connect4.views.console.menus.options.SetRandomMachinePlayerOption;
import connect4.views.console.menus.options.SetUserPlayerOption;
import utils.models.menu.SecuentialMenu;

public class TurnMenu extends SecuentialMenu {

    private StartController startController;

    public TurnMenu(StartController startController, int maxSecuences) {
        super("Elige un tipo de jugador: ", maxSecuences);
        this.startController = startController;
    }

    @Override
    public void addOptions() {
        this.add(new SetUserPlayerOption(this.startController));
        this.add(new SetRandomMachinePlayerOption(this.startController));
        this.add(new SetMinMaxMachinePlayerOption(this.startController));
    }

}
