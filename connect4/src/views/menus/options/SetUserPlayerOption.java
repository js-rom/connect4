package views.menus.options;

import models.Turn;

public class SetUserPlayerOption extends TurnOption {

    public SetUserPlayerOption(Turn model) {
        super("Human player", model);
    }

    public void interact() {
        this.model.setUserPlayer();
    }

}
