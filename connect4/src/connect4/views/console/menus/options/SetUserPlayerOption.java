package connect4.views.console.menus.options;

import connect4.controllers.Logic;

public class SetUserPlayerOption extends TurnOption {

    public SetUserPlayerOption(Logic model) {
        super("Human player", model);
    }

    public void interact() {
        this.model.addPlayer(model.getUserPlayerPlayerType());
    }

}
