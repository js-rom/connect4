package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.core.AcceptorController;
import utils.tcpip.Server;

public abstract class Dispatcher {

    protected AcceptorController acceptorController;
	
	protected Server server;
	
	public Dispatcher (AcceptorController acceptorController) {
		this.acceptorController = acceptorController;
	}

	public abstract void dispatch();
	
	public void associate(Server server) {
		this.server = server;
	}
}
