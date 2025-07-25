package connect4.views.console.menus;

import java.util.List;

import connect4.controllers.core.PlayController;
import connect4.views.console.menus.options.ActionOption;
import connect4.views.console.menus.options.PlayOption;
import connect4.views.console.menus.options.RedoOption;
import connect4.views.console.menus.options.UndoOption;
import utils.models.menu.Menu;

public class PlayMenu extends Menu {

    private PlayController playController;
    private List<PlayOption> playOption;

    public PlayMenu(PlayController playController) {
        super("Selecciona una opción: ");
        this.playController = playController;
        this.playOption = List.of(
            new ActionOption(this.playController),
            new UndoOption(this.playController),
            new RedoOption(playController)
        );
    }

    @Override
    protected void addOptions() {
        for (PlayOption option : this.playOption) {
            if (option.isActive()) {
                this.add(option);
            }
        }
    }

}
