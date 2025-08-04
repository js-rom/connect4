package utils.net;

import java.io.IOException;
import java.net.Socket;

import connect4.types.Color;
import connect4.types.PlayerType;

public class Client implements Operations {

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
