package utils.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CharactersTcpipSocket implements Operations {

	private Socket socket;

	private PrintWriter out;

	private BufferedReader in;

	public void associate(Socket socket) throws IOException {
		this.socket = socket;
		this.out = new PrintWriter(socket.getOutputStream());
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	public void send(String value) {
		assert value != null : "Cannot send null value";
		this.out.println(value);
		this.out.flush();
	}

	public void send(Integer value) {
		assert value != null : "Cannot send null value";
		this.send("" + value);
	}

	public void send(Boolean value) {
		assert value != null : "Cannot send null value";
		this.send("" + value);
	}

	public void send(char value) {
		this.send("" + value);
	}

	public String receiveLine() throws IOException {
		String result = null;
		do {
			result = this.in.readLine();
		} while (result == null);
		return result;
	}

	public boolean receiveBoolean() throws IOException {
		return Boolean.parseBoolean(this.receiveLine());
	}

	public Integer receiveInt() throws IOException {
		try {
			return Integer.parseInt(this.receiveLine());
		} catch (NumberFormatException e) {
			assert false : "Error parsing integer from input stream";
		}
		return null;
	}

	public char receiveChar() throws IOException {
		return this.receiveLine().charAt(0);
	}

	public void close() throws IOException {
		this.in.close();
		this.out.close();
		this.socket.close();
	}

	public String getHostAddress() {
		return this.socket.getInetAddress().getHostAddress();
	}

	public int getPort() {
		return this.socket.getPort();
	}

}