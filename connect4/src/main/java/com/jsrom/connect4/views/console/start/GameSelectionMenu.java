package main.java.com.jsrom.connect4.views.console.start;

import main.java.com.jsrom.connect4.controllers.core.StartController;

import main.java.com.jsrom.utils.models.menu.Menu;

public class GameSelectionMenu extends Menu {

    private StartController startController;

    public GameSelectionMenu(StartController startController) {
        super("Selecciona una partida: ");
        this.startController = startController;
    }

    @Override
    protected void addOptions() {
        String[] gamesNames = this.startController.getGameNames();
		for (String title : gamesNames) {
			this.add(new GameSelectionCommand(title, startController));
		}
    }
}
