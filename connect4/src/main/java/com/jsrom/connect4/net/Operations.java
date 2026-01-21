package main.java.com.jsrom.connect4.net;

import java.io.IOException;

import main.java.com.jsrom.connect4.types.Color;
import main.java.com.jsrom.connect4.types.PlayerType;

public interface Operations extends main.java.com.jsrom.utils.net.Operations {

    public void send(PlayerType playerType);

    public void send(PlayerType[] playerTypes);

    public void send(Color color);

    public PlayerType receivePlayerType() throws IOException;

    public PlayerType[] receivePlayerTypes() throws IOException;

    public Color receiveColor() throws IOException;

}
