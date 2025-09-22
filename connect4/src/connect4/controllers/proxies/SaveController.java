package connect4.controllers.proxies;

import connect4.net.Client;

public class SaveController extends connect4.controllers.core.SaveController {

    private Client client;

    public SaveController(Client client) {
        this.client = client;
    }

}
