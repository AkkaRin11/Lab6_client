package org.example.connection;

import lombok.Getter;
import org.example.exception.ClosureFailedException;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient {
    private final String host;
    private final int port;
    private Socket socket;
    @Getter
    private InputStream inputStream;
    @Getter
    private OutputStream outputStream;

    public TCPClient(String host, int port){
        this.host = host;
        this.port = port;
    }
    public void run() throws IOException {
        connect();
    }
    private void connect() throws IOException {
        socket = new Socket();
        socket.connect(new InetSocketAddress(host, port));

        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
    }
    public void close() throws ClosureFailedException {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            throw new ClosureFailedException();
        }
    }

}
