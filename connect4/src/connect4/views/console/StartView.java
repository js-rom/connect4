package connect4.views.console;

import connect4.controllers.core.StartController;
import connect4.views.console.turn.TurnView;

public class StartView {

    public void interact(StartController startController) {
        assert startController.isReset();
        new TurnView().selectPlayers(startController);
        startController.nextState();
    }

}
