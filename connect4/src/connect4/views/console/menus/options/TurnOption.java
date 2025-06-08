package connect4.views.console.menus.options;

import connect4.controllers.StartController;
import utils.models.menu.Option;

public abstract class TurnOption extends Option {
    protected StartController startController;

    public TurnOption(String string, StartController startController) {
        super(string);
        this.startController = startController;
    }
}
