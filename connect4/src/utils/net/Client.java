package utils.net;

import java.io.IOException;
import java.net.Socket;

public class Client {

    private Operations socket;

    public Client(String host, int port) throws IOException {
        this.socket = new CharactersTcpipSocket();
        socket.associate(new Socket(host, port));
        System.out.println("Cliente> Establecida conexion");
    }

    public void close() throws IOException {
        this.socket.close();
        System.out.println("Client> Connection closed");
    }

}
