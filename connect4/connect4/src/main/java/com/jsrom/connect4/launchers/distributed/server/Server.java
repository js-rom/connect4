package com.jsrom.connect4.launchers.distributed.server;

import java.io.IOException;

import com.jsrom.connect4.launchers.distributed.server.dispatchers.DispatcherPrototype;

public class Server {

    private DispatcherPrototype dispatcherPrototype;

	private LogicImplementationServer logic;

	private Server() {
		try {
			this.dispatcherPrototype = new DispatcherPrototype();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.logic = new LogicImplementationServer();
		this.logic.createDispatchers(this.dispatcherPrototype);
	}

	private void serve() {
		this.dispatcherPrototype.serve();
	}

	public static void main(String[] args) {
		new Server().serve();
	}
}
