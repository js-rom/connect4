package connect4.controllers.proxies;

import java.io.IOException;

import connect4.types.StateValue;
import connect4.controllers.core.AcceptorController;
import connect4.net.Client;

public class Logic extends connect4.controllers.core.Logic {

    private Session session;
    private Client client;

    public Logic() {
        try {
            this.client = new Client("localhost", 2020);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.session = new Session(this.client);
        this.controllers.put(StateValue.INITIAL, new StartController(this.client));
        this.controllers.put(StateValue.IN_GAME, new PlayController(this.client));
        this.controllers.put(StateValue.RESUME, new ResumeController(this.client));
        this.controllers.put(StateValue.EXIT, null);
    }

    public AcceptorController getController() {
        return this.controllers.get(this.session.getValueState());
    }

    public void close() {
        try {
            this.client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
