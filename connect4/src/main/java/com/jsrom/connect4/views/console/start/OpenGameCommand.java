package main.java.com.jsrom.connect4.views.console.start;

import main.java.com.jsrom.connect4.controllers.core.StartController;
import main.java.com.jsrom.connect4.views.console.shared.MenuOption;

public class OpenGameCommand extends MenuOption {

    public OpenGameCommand(StartController startController) {
        super(startController, "Abrir partida");
    }

    @Override
    public void interact() {
        new GameSelectionMenu((StartController) this.acceptorController).interact();
    }

    @Override
    public boolean isActive() {
        return ((StartController) this.acceptorController).hasSavedGames();
    }

}
