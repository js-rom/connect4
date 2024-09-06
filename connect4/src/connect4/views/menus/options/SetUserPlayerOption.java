package connect4.views.menus.options;

import connect4.models.Turn;

public class SetUserPlayerOption extends TurnOption {

    public SetUserPlayerOption(Turn model) {
        super("Human player", model);
    }

    public void interact() {
        this.model.setUserPlayer();
    }

}
