package connect4.views.console.menus;

import connect4.controllers.Logic;
import connect4.views.console.menus.options.SetMinMaxMachinePlayerOption;
import connect4.views.console.menus.options.SetRandomMachinePlayerOption;
import connect4.views.console.menus.options.SetUserPlayerOption;
import utils.models.menu.SecuentialMenu;

public class TurnMenu extends SecuentialMenu {

    private Logic model;

    public TurnMenu(Logic model, int maxSecuences) {
        super("Elige un tipo de jugador: ", maxSecuences);
        this.model = model;
    }

    @Override
    public void addOptions() {
        this.add(new SetUserPlayerOption(this.model));
        this.add(new SetRandomMachinePlayerOption(this.model));
        this.add(new SetMinMaxMachinePlayerOption(this.model));
    }

}
