package utils.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import connect4.types.Color;
import connect4.types.PlayerType;

public abstract class CharactersTcpipSocket implements Operations {

	protected Socket socket;

	protected PrintWriter out;

	protected BufferedReader in;

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

	public void send(PlayerType playerType) {
		assert playerType != null : "Cannot send null PlayerType";
		this.send(playerType.name());
	}

	public void send(PlayerType[] playerTypes) {
		assert playerTypes != null : "Cannot send null PlayerType array";
		StringBuilder sb = new StringBuilder();
		final String SEPARATOR = ",";
		for (int i = 0; i < playerTypes.length; i++) {
			sb.append(playerTypes[i].name());
			if (i < playerTypes.length - 1) {
				sb.append(SEPARATOR);
			}
		}
		this.send(sb.toString());
	}

	public void send(Color color) {
		assert color != null : "Cannot send null Color";
		this.send(color.name());
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

	public PlayerType receivePlayerType() throws IOException {
		return PlayerType.valueOf(this.receiveLine());
	}

	public PlayerType[] receivePlayerTypes() throws IOException {
		String[] playerTypes = this.receiveLine().split(",");
		PlayerType[] result = new PlayerType[playerTypes.length];
		for (int i = 0; i < playerTypes.length; i++) {
			result[i] = PlayerType.valueOf(playerTypes[i]);
		}
		return result;
	}

	public Color receiveColor() throws IOException {
		return Color.valueOf(this.receiveLine());
	}

	public void close() throws IOException {
		this.in.close();
		this.out.close();
		this.socket.close();
		this._close();
	}

	protected abstract void _close() throws IOException;
}