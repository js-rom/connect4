package connect4.net;

import java.io.IOException;

import connect4.launchers.distributed.server.dispatchers.FrameType;
import connect4.types.Color;
import connect4.types.PlayerType;

public class Client extends utils.net.Client implements Operations {

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
