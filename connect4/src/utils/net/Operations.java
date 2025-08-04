package utils.net;

import java.io.IOException;
import java.net.Socket;

import connect4.types.Color;
import connect4.types.PlayerType;

public interface Operations {

    public void associate(Socket socket) throws IOException;

    public void send(String value);

    public void send(Integer value);

    public void send(Boolean value);

    public void send(char value);

    public void send(PlayerType playerType);

    public void send(PlayerType[] playerTypes);

    public void send(Color color);

    public String receiveLine() throws IOException;

    public boolean receiveBoolean() throws IOException;

    public Integer receiveInt() throws IOException;

    public char receiveChar() throws IOException;

    public PlayerType receivePlayerType() throws IOException;

    public PlayerType[] receivePlayerTypes() throws IOException;

    public Color receiveColor() throws IOException;

    public void close() throws IOException;

    public String getHostAddress();

    public int getPort();
}
