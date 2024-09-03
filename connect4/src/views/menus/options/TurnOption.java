package views.menus.options;

import models.Turn;
import utils.menu.Option;

public abstract class TurnOption extends Option {
    protected Turn model;

    public TurnOption(String string, Turn model) {
        super(string);
        this.model = model;
    }
}
