package utils.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Operations {

    protected Operations OperationsSocket;
    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        this.createOperationsSocket();
        this.serverSocket = new ServerSocket(port);
    }

    protected void createOperationsSocket() {
        this.OperationsSocket = new CharactersTcpipSocket();
    }

    public void close() throws IOException {
        this.OperationsSocket.close();
        this.serverSocket.close();
        System.out.println("Server> Connection closed");
    }

    public void listen() throws IOException {
        System.out.println("Servidor> Esperando conexion...");
        this.associate(serverSocket.accept());
        System.out.println("Servidor> Recibida conexion de " + this.OperationsSocket.getHostAddress() + ":"
                + this.OperationsSocket.getPort());

    }

    @Override
    public void associate(Socket socket) throws IOException {
        this.OperationsSocket.associate(socket);
    }

    @Override
    public void send(String value) {
        this.OperationsSocket.send(value);
    }

    @Override
    public void send(Integer value) {
        this.OperationsSocket.send(value);
    }

    @Override
    public void send(Boolean value) {
        this.OperationsSocket.send(value);
    }

    @Override
    public void send(char value) {
        this.OperationsSocket.send(value);
    }

    @Override
    public void send(String[] strings) {
        this.OperationsSocket.send(strings);
    }

    @Override
    public String receiveLine() throws IOException {
        return this.OperationsSocket.receiveLine();
    }

    @Override
    public boolean receiveBoolean() throws IOException {
        return this.OperationsSocket.receiveBoolean();
    }

    @Override
    public Integer receiveInt() throws IOException {
        return this.OperationsSocket.receiveInt();
    }

    @Override
    public char receiveChar() throws IOException {
        return this.OperationsSocket.receiveChar();
    }

    @Override
    public String getHostAddress() {
        return this.OperationsSocket.getHostAddress();
    }

    @Override
    public int getPort() {
        return this.OperationsSocket.getPort();
    }

    @Override
    public String[] receiveStringArray() throws IOException {
        return this.OperationsSocket.receiveStringArray();
    }

}
