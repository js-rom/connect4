package connect4.views.console.play;

import connect4.controllers.core.PlayController;
import connect4.views.console.shared.MenuOption;

public abstract class PlayOption extends MenuOption {

    public PlayOption(PlayController playController, String tittle) {
        super(playController, tittle);
        this.acceptorController = playController;
    }

    @Override
    public void interact() {
        new BoardView((PlayController) this.acceptorController).writeln();
    }

}
