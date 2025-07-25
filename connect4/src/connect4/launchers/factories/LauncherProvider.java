package connect4.launchers.factories;

import connect4.controllers.core.AcceptorController;
import connect4.controllers.core.Logic;
import connect4.views.View;

public abstract class LauncherProvider {

    protected Logic logic;
    protected View view;

    public abstract AcceptorController getController();
    public abstract View getView();
}
