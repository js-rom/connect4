package connect4.views.menus;

import connect4.models.Turn;
import utils.menu.SecuentialMenu;
import connect4.views.menus.options.SetMinMaxMachinePlayerOption;
import connect4.views.menus.options.SetRandomMachinePlayerOption;
import connect4.views.menus.options.SetUserPlayerOption;

public class TurnMenu extends SecuentialMenu {

    private Turn model;

    public TurnMenu(Turn model, int maxSecuences) {
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
