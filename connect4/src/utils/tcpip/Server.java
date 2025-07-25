package utils.tcpip;

import java.io.IOException;
import java.net.ServerSocket;

public class Server extends SocketFacade {

    private ServerSocket serverSocket;

    public Server(String port) throws IOException {
        this.serverSocket = new ServerSocket(2020);
    }

    @Override
    protected void _close() throws IOException {
        this.serverSocket.close();
        System.out.println("Server> Connection closed");
    }

    public void listen() throws IOException {
        System.out.println("Servidor> Esperando conexion...");
        this.associate(serverSocket.accept());
        System.out.println("Servidor> Recibida conexion de " + socket.getInetAddress().getHostAddress() + ":"
                + socket.getPort());

    }

}
