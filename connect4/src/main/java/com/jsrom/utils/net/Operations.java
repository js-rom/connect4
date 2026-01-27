package com.jsrom.utils.net;

import java.io.IOException;
import java.net.Socket;

public interface Operations {

    public void associate(Socket socket) throws IOException;

    public void send(String value);

    public void send(Integer value);

    public void send(Boolean value);

    public void send(char value);

    public void send(String[] strings);

    public String receiveLine() throws IOException;

    public boolean receiveBoolean() throws IOException;

    public Integer receiveInt() throws IOException;

    public char receiveChar() throws IOException;

    public String[] receiveStringArray() throws IOException;

    public void close() throws IOException;

    public String getHostAddress();

    public int getPort();
}
