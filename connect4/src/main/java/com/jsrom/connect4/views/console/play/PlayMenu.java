package main.java.com.jsrom.connect4.views.console.play;

import java.util.List;

import main.java.com.jsrom.connect4.controllers.core.PlayController;

import main.java.com.jsrom.utils.models.menu.Menu;

public class PlayMenu extends Menu {

    private PlayController playController;
    private List<PlayOption> playOption;

    public PlayMenu(PlayController playController) {
        super("Selecciona una opción: ");
        this.playController = playController;
        this.playOption = List.of(
            new ActionOption(this.playController),
            new UndoOption(this.playController),
            new RedoOption(this.playController),
            new ExitOption(this.playController)
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
