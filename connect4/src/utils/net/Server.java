package utils.net;

import java.io.IOException;
import java.net.ServerSocket;

public class Server extends CharactersTcpipSocket {

    private Operations socket;
    private ServerSocket serverSocket;

    public Server(String port) throws IOException {
        this.socket = new CharactersTcpipSocket();
        this.serverSocket = new ServerSocket(2020);
    }

    public void close() throws IOException {
        this.socket.close();
        this.serverSocket.close();
        System.out.println("Server> Connection closed");
    }

    public void listen() throws IOException {
        System.out.println("Servidor> Esperando conexion...");
        this.associate(serverSocket.accept());
        System.out.println("Servidor> Recibida conexion de " + this.socket.getHostAddress() + ":"
                + this.socket.getPort());

    }

}
