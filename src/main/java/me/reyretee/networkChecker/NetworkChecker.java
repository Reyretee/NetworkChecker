package me.reyretee.networkChecker;

import me.reyretee.networkChecker.network.SocketClient;
import me.reyretee.networkChecker.task.PingTask;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Timer;
import java.util.logging.Logger;

public final class NetworkChecker extends JavaPlugin {

    private SocketClient socketClient;
    private Timer timer;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        saveDefaultMessages();
        loadMessages();

        setupTask();
    }

    @Override
    public void onDisable() {
        if (timer != null) {
            timer.cancel();
        }

        getLogger().info("NetworkChecker kapatıldı.");
    }

    private void saveDefaultMessages() {
        if (!getConfig().contains("messages")) {
            saveResource("messages.yml", false);
        }
    }

    private void loadMessages() {
        reloadConfig();
    }

    private void setupTask() {
        reloadConfig();  // Config'i yeniden yükle

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

        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();
        timer.schedule(new PingTask(this, socketClient), 0, interval * 1000L);

        logger.info("NetworkChecker başlatıldı ve ping görevleri " + interval + " saniye aralıklarla çalışacak.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("networkchecker")) {
            if (args.length == 1) {
                String subCommand = args[0].toLowerCase();

                switch (subCommand) {
                    case "reload":
                        try {
                            reloadConfig();
                            loadMessages();
                            setupTask();
                            String successMessage = getConfig().getString("messages.reload_success", "Ayarlar başarıyla yeniden yüklendi!");
                            sender.sendMessage(successMessage.replace("&", "§"));
                        } catch (Exception e) {
                            String errorMessage = getConfig().getString("messages.reload_fail", "Ayarlar yeniden yüklenirken bir hata oluştu!");
                            sender.sendMessage(errorMessage.replace("&", "§"));
                        }
                        return true;
                    default:
                        sender.sendMessage("Geçersiz komut. Kullanılabilir komut: /networkchecker reload");
                        return false;
                }
            } else {
                sender.sendMessage("Geçersiz komut. Kullanılabilir komut: /networkchecker reload");
                return false;
            }
        }
        return false;
    }
}
