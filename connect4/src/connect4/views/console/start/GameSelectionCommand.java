package connect4.views.console.start;

import connect4.controllers.core.StartController;
import connect4.views.console.shared.MenuOption;
import utils.views.Console;
import connect4.views.console.shared.Message;

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
