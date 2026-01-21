package main.java.com.jsrom.connect4.launchers.distributed.server;

import java.io.IOException;

import main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers.DispatcherPrototype;
import main.java.com.jsrom.connect4.persistence.SessionDAO;

public abstract class Server {

	private DispatcherPrototype dispatcherPrototype;

	private LogicImplementationServer logic;

	protected Server() {
		try {
			this.dispatcherPrototype = new DispatcherPrototype();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.logic = new LogicImplementationServer(this.createSessionDAO());
		this.logic.createDispatchers(this.dispatcherPrototype);
	}

	protected abstract SessionDAO createSessionDAO();

	protected void serve() {
		this.dispatcherPrototype.serve();
	}

}
