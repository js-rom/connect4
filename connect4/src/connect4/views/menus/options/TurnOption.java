package connect4.views.menus.options;

import connect4.models.Turn;
import utils.models.menu.Option;

public abstract class TurnOption extends Option {
    protected Turn model;

    public TurnOption(String string, Turn model) {
        super(string);
        this.model = model;
    }
}
