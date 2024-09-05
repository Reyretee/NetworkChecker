package me.reyretee.networkChecker.task;

import me.reyretee.networkChecker.network.SocketClient;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.TimerTask;
import java.util.logging.Logger;

public class PingTask extends TimerTask {

    private final JavaPlugin plugin;
    private final SocketClient socketClient;
    private final Logger logger;

    public PingTask(JavaPlugin plugin, SocketClient socketClient) {
        this.plugin = plugin;
        this.socketClient = socketClient;
        this.logger = plugin.getLogger();
    }

    @Override
    public void run() {
        try {
            StringBuilder pingData = new StringBuilder();
            for (Player player : plugin.getServer().getOnlinePlayers()) {
                int ping = player.getPing();
                pingData.append(player.getName()).append(":").append(ping).append("\n");
            }

            if (pingData.length() > 0) {
                socketClient.sendData(pingData.toString());
                logger.info("Ping verisi bota gönderildi.");
            } else {
                logger.warning("Ping verisi gönderilecek oyuncu bulunamadı.");
            }

        } catch (Exception e) {
            logger.severe("Ping verisi alınırken veya gönderilirken bir hata oluştu: " + e.getMessage());
        }
    }
}
