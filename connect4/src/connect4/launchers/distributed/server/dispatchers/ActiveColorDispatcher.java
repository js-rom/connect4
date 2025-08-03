package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.PlayController;
import connect4.types.Color;

public class ActiveColorDispatcher extends Dispatcher {

    public ActiveColorDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        Color activeColor = ((PlayController) this.acceptorController).getActiveColor();
        this.server.send(activeColor);
    }

}
