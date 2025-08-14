package connect4.views.console.start;

import connect4.controllers.core.StartController;
import connect4.views.console.turn.TurnView;
import utils.models.menu.Option;

public class NewGameCommand extends Option {

    private StartController startController;

    public NewGameCommand(StartController startController) {
        super("Nueva partida");
        this.startController = startController;
    }

    @Override
    public void interact() {
        new TurnView().selectPlayers(startController);
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
