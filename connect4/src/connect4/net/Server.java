package connect4.net;

import java.io.IOException;

import connect4.types.Color;
import connect4.types.PlayerType;

public class Server extends utils.net.Server implements Operations {

    public Server(int port) throws IOException {
        super(port);
    }

    @Override
    protected void createOperationsSocket() {
        this.OperationsSocket = new CharactersTcpipSocket();
    }

    @Override
    public void send(PlayerType playerType) {
        ((Operations)this.OperationsSocket).send(playerType);
    }

    @Override
    public void send(PlayerType[] playerTypes) {
        ((Operations)this.OperationsSocket).send(playerTypes);
    }

    @Override
    public void send(Color color) {
        ((Operations)this.OperationsSocket).send(color);
    }

    @Override
    public PlayerType receivePlayerType() throws IOException {
        return ((Operations)this.OperationsSocket).receivePlayerType();
    }

    @Override
    public PlayerType[] receivePlayerTypes() throws IOException {
        return ((Operations)this.OperationsSocket).receivePlayerTypes();
    }

    @Override
    public Color receiveColor() throws IOException {
        return ((Operations)this.OperationsSocket).receiveColor();
    }
}
