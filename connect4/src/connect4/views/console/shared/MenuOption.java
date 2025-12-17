package connect4.views.console.shared;

import connect4.controllers.core.AcceptorController;
import utils.models.menu.Option;

public abstract class MenuOption extends Option {

    protected AcceptorController acceptorController;

    public MenuOption(AcceptorController acceptorController, String tittle) {
        super(tittle);
        this.acceptorController = acceptorController;
    }

}
