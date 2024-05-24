package org.example.connection;

import org.example.Dto.CommandRequest;
import org.example.Dto.Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.SocketException;

public class Sender {
    private final TCPClient tcpClient;

    public Sender(TCPClient tcpClient){
        this.tcpClient = tcpClient;
    }

    public Response sendRequest(CommandRequest request) throws IOException, SocketException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(request);
        oos.close();

        tcpClient.getOutputStream().write(baos.toByteArray());

        try {
            return (Response) recieveObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    private Object recieveObject() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(tcpClient.getInputStream());
        return objectInputStream.readObject();
    }
}
