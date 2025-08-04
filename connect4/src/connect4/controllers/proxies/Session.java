package connect4.controllers.proxies;

import java.io.IOException;

import connect4.launchers.distributed.server.dispatchers.FrameType;
import connect4.types.StateValue;
import utils.net.Client;

public class Session extends connect4.models.Session {

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
