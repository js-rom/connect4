package main.java.com.jsrom.connect4.controllers.proxies;

import java.io.IOException;

import main.java.com.jsrom.connect4.controllers.core.AcceptorController;
import main.java.com.jsrom.connect4.net.Client;
import main.java.com.jsrom.connect4.types.StateValue;

public class Logic extends main.java.com.jsrom.connect4.controllers.core.Logic {

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
        this.controllers.put(StateValue.OUT_GAME, new SaveController(this.client));
        this.controllers.put(StateValue.FINAL, new ResumeController(this.client));
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
