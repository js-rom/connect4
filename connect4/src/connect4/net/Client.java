package connect4.net;

import java.io.IOException;

import connect4.types.Color;
import connect4.types.PlayerType;

public class Client extends utils.net.Client implements Operations {

    public Client(String host, int port) throws IOException {
        super(host, port);
    }

    @Override
    public void createSocket() {
        this.socket = new CharactersTcpipSocket();
    }

    public void send(PlayerType playerType) {
        ((Operations)this.socket).send(playerType);
    }

    public void send(PlayerType[] playerTypes) {
        ((Operations)this.socket).send(playerTypes);
    }

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
