package connect4.views.console.start;

import connect4.controllers.core.StartController;

public class StartView {

    public void interact(StartController startController) {
        assert startController.isReset();
        new StartMenu(startController).interact();
        startController.nextState();
    }

}
