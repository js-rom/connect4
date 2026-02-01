package com.jsrom.connect4.launchers.distributed.server;

import java.io.IOException;
import java.util.Map;

import com.jsrom.connect4.launchers.distributed.server.dispatchers.DispatcherPrototype;
import com.jsrom.connect4.persistence.SessionDAO;

public class Server {

	private DispatcherPrototype dispatcherPrototype;
	private LogicImplementationServer logic;
	private SessionDAO sessionDAO;
	private Map<String, SessionDAO> sessionDAOMap;

	protected Server(String[] config) {
		this.sessionDAOMap = Map.of(
				"files", new com.jsrom.connect4.persistence.files.SessionDAO(),
				"postgresql", new com.jsrom.connect4.persistence.bbdd.SessionDAO());
		this.configure(config);

	}

	private void configure(String[] config) {
		try {
			this.dispatcherPrototype = new DispatcherPrototype();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (config.length == 0) {
			System.out.println("Usage: java ...Server <persistence: files|postgresql> ");
			System.exit(1);
		}
		this.sessionDAO = this.sessionDAOMap.get(config[0]);
		if (this.sessionDAO == null) {
			System.out.println("Unknown persistence system: " + config[0]);
			System.exit(1);
		}
		this.logic = new LogicImplementationServer(this.sessionDAO);
		this.logic.createDispatchers(this.dispatcherPrototype);

	}

	protected void serve() {
		this.dispatcherPrototype.serve();
	}

	public static void main(String[] config) {
		new Server(config).serve();
	}

}
