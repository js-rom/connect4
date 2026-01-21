package main.java.com.jsrom.connect4.controllers.proxies;

import java.io.IOException;

import main.java.com.jsrom.connect4.types.FrameType;
import main.java.com.jsrom.connect4.types.StateValue;

import main.java.com.jsrom.utils.net.Client;

public class Session {

    private Client client;

    public Session(Client client) {
        this.client = client;
    }
	
	public StateValue getValueState() {
		this.client.send(FrameType.STATE.name());
		try {
            return StateValue.values()[this.client.receiveInt()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
	}
}
