package connect4.views.console.menus.options;

import connect4.controllers.PlayController;
import connect4.views.console.BoardView;
import utils.models.menu.Option;

public abstract class PlayOption extends Option {

    protected PlayController playController;

    public PlayOption(PlayController playController, String tittle) {
        super(tittle);
        this.playController = playController;
    }

    @Override
    public void interact() {
        new BoardView(this.playController).writeln();
    }

    public abstract boolean isActive();

}
