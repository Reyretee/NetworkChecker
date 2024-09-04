package me.reyretee.networkChecker.network;

import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
    private final String serverIP;
    private final int port;

    public SocketClient(String serverIP, int port) {
        this.serverIP = serverIP;
        this.port = port;
    }

    public void sendData(String data){
        try (Socket socket = new Socket(serverIP, port);
             OutputStream outputStream = socket.getOutputStream()) {

            outputStream.write(data.getBytes());
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
