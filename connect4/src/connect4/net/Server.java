package connect4.net;

import java.io.IOException;

import connect4.types.Color;
import connect4.types.PlayerType;

public class Server extends utils.net.Server implements Operations {

    public Server(int port) throws IOException {
        super(port);
    }

    @Override
    public void createSocket() {
        this.socket = new CharactersTcpipSocket();
    }

    @Override
    public void send(PlayerType playerType) {
        ((Operations)this.socket).send(playerType);
    }

    @Override
    public void send(PlayerType[] playerTypes) {
        ((Operations)this.socket).send(playerTypes);
    }

    @Override
    public void send(Color color) {
        ((Operations)this.socket).send(color);
    }

    @Override
    public PlayerType receivePlayerType() throws IOException {
        return ((Operations)this.socket).receivePlayerType();
    }

    @Override
    public PlayerType[] receivePlayerTypes() throws IOException {
        return ((Operations)this.socket).receivePlayerTypes();
    }

    @Override
    public Color receiveColor() throws IOException {
        return ((Operations)this.socket).receiveColor();
    }
}
