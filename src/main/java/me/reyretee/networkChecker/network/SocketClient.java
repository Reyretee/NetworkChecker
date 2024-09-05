package me.reyretee.networkChecker.network;

import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.util.logging.Logger;

public class SocketClient {
    private final String serverIP;
    private final int port;
    private final Logger logger;

    public SocketClient(String serverIP, int port, Logger logger) {
        this.serverIP = serverIP;
        this.port = port;
        this.logger = logger;
    }

    public void sendData(String data) {
        try (Socket socket = new Socket(serverIP, port);
             OutputStream outputStream = socket.getOutputStream()) {

            outputStream.write(data.getBytes());
            outputStream.flush();

            logger.info("Veri başarıyla gönderildi: " + data);

        } catch (UnknownHostException e) {
            logger.warning("Botun IP adresi çözümlenemedi: " + serverIP);
        } catch (IOException e) {
            logger.warning("Botla bağlantı kurulamadı: " + e.getMessage());
        } catch (Exception e) {
            logger.severe("Beklenmeyen bir hata oluştu: " + e.getMessage());
        }
    }
}
