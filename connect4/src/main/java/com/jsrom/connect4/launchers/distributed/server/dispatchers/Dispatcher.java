package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import main.java.com.jsrom.connect4.controllers.core.AcceptorController;
import main.java.com.jsrom.connect4.net.Server;

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
