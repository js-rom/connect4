package main.java.com.jsrom.connect4.net;

import java.io.IOException;

import main.java.com.jsrom.connect4.types.Color;
import main.java.com.jsrom.connect4.types.FrameType;
import main.java.com.jsrom.connect4.types.PlayerType;

public class Client extends main.java.com.jsrom.utils.net.Client implements Operations {

    public Client(String host, int port) throws IOException {
        super(host, port);
    }

    @Override
    protected void createOperationsSocket() {
        this.OperationsSocket = new CharactersTcpipSocket();
    }

    @Override
    public void close() throws IOException {
        this.send(FrameType.CLOSE.name());
        super.close();
    }

    public void send(PlayerType playerType) {
        ((Operations) this.OperationsSocket).send(playerType);
    }

    public void send(PlayerType[] playerTypes) {
        ((Operations) this.OperationsSocket).send(playerTypes);
    }

    public void send(Color color) {
        ((Operations) this.OperationsSocket).send(color);
    }

    @Override
    public PlayerType receivePlayerType() throws IOException {
        return ((Operations) this.OperationsSocket).receivePlayerType();
    }

    @Override
    public PlayerType[] receivePlayerTypes() throws IOException {
        return ((Operations) this.OperationsSocket).receivePlayerTypes();
    }

    @Override
    public Color receiveColor() throws IOException {
        return ((Operations) this.OperationsSocket).receiveColor();
    }

}
