package connect4.views.console.menus.options;

import connect4.controllers.Logic;
import utils.models.menu.Option;

public abstract class TurnOption extends Option {
    protected Logic model;

    public TurnOption(String string, Logic model) {
        super(string);
        this.model = model;
    }
}
