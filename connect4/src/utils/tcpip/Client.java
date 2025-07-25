package utils.tcpip;

import java.io.IOException;
import java.net.Socket;


public class Client extends SocketFacade {

    public Client(String host, int port) throws IOException {
        this.associate(new Socket(host, port));
        		System.out.println("Cliente> Establecida conexion");
    }

    @Override
    protected void _close() throws IOException {
       System.out.println("Client> Connection closed");
    }

}
