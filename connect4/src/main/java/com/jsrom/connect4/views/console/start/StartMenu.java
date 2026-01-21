package main.java.com.jsrom.connect4.views.console.start;

import java.util.List;

import main.java.com.jsrom.connect4.controllers.core.StartController;
import main.java.com.jsrom.connect4.views.console.shared.MenuOption;

import main.java.com.jsrom.utils.models.menu.Menu;

public class StartMenu extends Menu {

    private StartController startController;
    private List<MenuOption> options;

    public StartMenu(StartController startController) {
        super("Selecciona una opción: ");
        this.startController = startController;
        this.options = List.of(
            new NewGameCommand(this.startController),
            new OpenGameCommand(this.startController)
        );
    }

    @Override
    protected void addOptions() {
        for (MenuOption option : this.options) {
            if (option.isActive()) {
                this.add(option);
            }
        }
    }

}
