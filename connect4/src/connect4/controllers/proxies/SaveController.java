package connect4.controllers.proxies;

import connect4.net.Client;

public class SaveController extends connect4.controllers.core.SaveController {

    private Client client;

    public SaveController(Client client) {
        this.client = client;
    }

	@Override
	public boolean hasName() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'hasName'");
	}

	@Override
	public boolean exists(String name) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'exists'");
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setName'");
	}

}
