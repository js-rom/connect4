package connect4.launchers.distributed.server.dispatchers;

import java.io.IOException;

import connect4.controllers.implementation.SaveController;

public class ExistGameNameDispatcher extends Dispatcher {

    public ExistGameNameDispatcher(SaveController saveController) {
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
        this.server.send(((SaveController) this.acceptorController).exists(name));

    }

}
