package main.java.com.jsrom.connect4.views.console.start;

import main.java.com.jsrom.connect4.controllers.core.StartController;
import main.java.com.jsrom.connect4.views.console.shared.MenuOption;
import main.java.com.jsrom.connect4.views.console.turn.TurnView;

public class NewGameCommand extends MenuOption {

    private StartController startController;

    public NewGameCommand(StartController startController) {
        super(startController,"Nueva partida");
        this.startController = startController;
    }

    @Override
    public void interact() {
        new TurnView().selectPlayers(startController);
         this.startController.start();
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
