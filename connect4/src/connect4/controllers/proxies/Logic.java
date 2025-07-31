package connect4.controllers.proxies;

import java.io.IOException;

import connect4.types.StateValue;
import utils.tcpip.Client;

public class Logic extends connect4.controllers.core.Logic {

    private Client client;
    private Session session;

    public Logic() {
        try {
            this.client = new Client("localhost", 2020);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.session = new Session(this.client);
        this.controllers.put(StateValue.INITIAL, new StartController(this.session, this.client));
        //this.acceptorControllers.put(StateValue.IN_GAME, new PlayController(this.session, this.client));
        //this.acceptorControllers.put(StateValue.RESUME, new ResumeController(this.session, this.client));
        this.controllers.put(StateValue.EXIT, null);
    }
}
