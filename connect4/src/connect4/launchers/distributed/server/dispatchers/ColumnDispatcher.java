package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.PlayController;

public class ColumnDispatcher extends Dispatcher {

    public ColumnDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        int column = ((PlayController) this.acceptorController).getColumn();
        this.server.send(column);
    }

}
