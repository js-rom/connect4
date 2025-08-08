package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.PlayController;

public class RegisterMementoDispatcher extends Dispatcher {

    public RegisterMementoDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((PlayController) this.acceptorController).registerMemento();
    }

}
