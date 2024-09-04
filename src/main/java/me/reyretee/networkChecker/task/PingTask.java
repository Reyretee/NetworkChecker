package me.reyretee.networkChecker.task;

import me.reyretee.networkChecker.network.SocketClient;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.TimerTask;

public class PingTask extends TimerTask {
    private final Plugin plugin;
    public PingTask(Plugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public void run() {
        StringBuilder data = new StringBuilder();
        for (Player player : Bukkit.getOnlinePlayers()){
            data.append(player.getName()).append(":").append(player.getPing()).append("\n");
        }

        SocketClient client = new SocketClient("VPS_IP", 25565);

        client.sendData(data.toString());
    }

}
