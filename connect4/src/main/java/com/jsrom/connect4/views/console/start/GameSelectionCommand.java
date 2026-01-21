package main.java.com.jsrom.connect4.views.console.start;

import main.java.com.jsrom.connect4.controllers.core.StartController;
import main.java.com.jsrom.connect4.views.console.shared.MenuOption;
import main.java.com.jsrom.connect4.views.console.shared.Message;

import main.java.com.jsrom.utils.views.Console;

public class GameSelectionCommand extends MenuOption {

    private String gameName;

    public GameSelectionCommand(String gameTitle, StartController startController) {
        super(startController, gameTitle);
        this.gameName = gameTitle;
    }

    @Override
    public void interact() {
        Console.getInstance().writeln(Message.GAME_SELECTED.toString().replace("#NAME", this.gameName));
        ((StartController)this.acceptorController).start(this.gameName);

    }

    @Override
    public boolean isActive() {
        return true;
    }

}
