package connect4.views.console.start;

import connect4.controllers.core.StartController;
import utils.models.menu.Menu;

public class StartMenu extends Menu {

    private StartController startController;

    public StartMenu(StartController startController) {
        super("Selecciona una opción: ");
        this.startController = startController;
    }

    @Override
    protected void addOptions() {
        this.add(new NewGameCommand(this.startController));
        //this.add(new OpenGameCommand(this.startController));
    }

}
