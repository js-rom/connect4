package connect4.views.console.play;

import java.util.List;

import connect4.controllers.core.PlayController;
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
