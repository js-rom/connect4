package utils.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import connect4.types.Color;
import connect4.types.PlayerType;

public class Server implements Operations {

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

    @Override
    public void associate(Socket socket) throws IOException {
        this.socket.associate(socket);
    }

    @Override
    public void send(String value) {
        this.socket.send(value);
    }

    @Override
    public void send(Integer value) {
        this.socket.send(value);
    }

    @Override
    public void send(Boolean value) {
        this.socket.send(value);
    }

    @Override
    public void send(char value) {
        this.socket.send(value);
    }

    @Override
    public void send(PlayerType playerType) {
        this.socket.send(playerType);
    }

    @Override
    public void send(PlayerType[] playerTypes) {
        this.socket.send(playerTypes);
    }

    @Override
    public void send(Color color) {
        this.socket.send(color);
    }

    @Override
    public String receiveLine() throws IOException {
        return this.socket.receiveLine();
    }

    @Override
    public boolean receiveBoolean() throws IOException {
        return this.socket.receiveBoolean();
    }

    @Override
    public Integer receiveInt() throws IOException {
        return this.socket.receiveInt();
    }

    @Override
    public char receiveChar() throws IOException {
        return this.socket.receiveChar();
    }

    @Override
    public PlayerType receivePlayerType() throws IOException {
        return this.socket.receivePlayerType();
    }

    @Override
    public PlayerType[] receivePlayerTypes() throws IOException {
        return this.socket.receivePlayerTypes();
    }

    @Override
    public Color receiveColor() throws IOException {
        return this.socket.receiveColor();
    }

    @Override
    public String getHostAddress() {
        return this.socket.getHostAddress();
    }

    @Override
    public int getPort() {
        return this.socket.getPort();
    }

}
