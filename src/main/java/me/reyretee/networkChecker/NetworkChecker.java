package me.reyretee.networkChecker;

import me.reyretee.networkChecker.network.SocketClient;
import me.reyretee.networkChecker.task.PingTask;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Timer;
import java.util.logging.Logger;

public final class NetworkChecker extends JavaPlugin {

    private SocketClient socketClient;
    private Timer timer;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();

        String ip = getConfig().getString("bot.ip");
        int port = getConfig().getInt("bot.port");
        int interval = getConfig().getInt("bot.interval", 300);

        Logger logger = getLogger();

        if (ip == null || ip.isEmpty()) {
            logger.severe("Config dosyasındaki IP adresi eksik.");
            return;
        }

        if (port == 0) {
            logger.severe("Config dosyasındaki port değeri geçersiz.");
            return;
        }

        socketClient = new SocketClient(ip, port, logger);

        timer = new Timer();
        timer.schedule(new PingTask(this, socketClient), 0, interval * 1000L);

        logger.info("NetworkChecker başlatıldı. Ping verileri " + interval + " saniye aralıkla gönderilecek.");
    }

    @Override
    public void onDisable() {
        if (timer != null) {
            timer.cancel();
        }

        getLogger().info("NetworkChecker kapatıldı.");
    }
}
