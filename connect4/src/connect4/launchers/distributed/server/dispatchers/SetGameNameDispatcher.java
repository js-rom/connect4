package connect4.launchers.distributed.server.dispatchers;

import java.io.IOException;

import connect4.controllers.implementation.SaveController;

public class SetGameNameDispatcher extends Dispatcher {

    public SetGameNameDispatcher(SaveController saveController) {
        super(saveController);
    }

    @Override
    public void dispatch() {
        String name = "";
        try {
            name = this.server.receiveLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((SaveController) this.acceptorController).setName(name);
    }

}
