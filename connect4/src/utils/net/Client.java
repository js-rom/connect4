package utils.net;

import java.io.IOException;
import java.net.Socket;

public class Client implements Operations {

    protected Operations socket;

    public Client(String host, int port) throws IOException {
        this.createSocket();
        socket.associate(new Socket(host, port));
        System.out.println("Cliente> Establecida conexion");
    }

    public void createSocket() {
        this.socket = new CharactersTcpipSocket();
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
    public String getHostAddress() {
        return this.socket.getHostAddress();
    }

    @Override
    public int getPort() {
        return this.socket.getPort();
    }

}
