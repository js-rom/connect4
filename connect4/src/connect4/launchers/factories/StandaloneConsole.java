package connect4.launchers.factories;

import connect4.controllers.core.AcceptorController;
import connect4.controllers.implementation.Logic;
import connect4.views.View;
import connect4.views.console.ConsoleView;

public class StandaloneConsole extends LauncherProvider {

    public StandaloneConsole() {
        this.logic = new Logic();
        this.view = new ConsoleView();
    }

    @Override
    public AcceptorController getController() {
        return this.logic.getController();
    }

    @Override
    public View getView() {
        return this.view;
    }

}
