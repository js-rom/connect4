package connect4.controllers.proxies;

import java.io.IOException;

import connect4.net.Client;
import connect4.types.FrameType;

public class SaveController extends connect4.controllers.core.SaveController {

	private Client client;

	public SaveController(Client client) {
		this.client = client;
	}

	@Override
	public boolean hasName() {
		this.client.send(FrameType.HAS_GAME_NAME.name());
		boolean hasName = false;
		try {
			hasName = this.client.receiveBoolean();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hasName;
	}

	@Override
	public boolean exists(String name) {
		this.client.send(FrameType.EXISTS_GAME_NAME.name());
		this.client.send(name);
		boolean exists = false;
		try {
			exists = this.client.receiveBoolean();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return exists;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}

	@Override
	public void setName(String name) {
		this.client.send(FrameType.SET_GAME_NAME.name());
		this.client.send(name);
	}

}
