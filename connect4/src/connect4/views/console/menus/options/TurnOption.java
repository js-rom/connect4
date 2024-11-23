package connect4.views.console.menus.options;

import connect4.controllers.StartController;
import utils.models.menu.Option;

public abstract class TurnOption extends Option {
    protected StartController model;

    public TurnOption(String string, StartController model) {
        super(string);
        this.model = model;
    }
}
