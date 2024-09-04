package me.reyretee.networkChecker;

import me.reyretee.networkChecker.task.PingTask;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Timer;

public final class NetworkChecker extends JavaPlugin {

    @Override
    public void onEnable() {
        Timer timer = new Timer();
        timer.schedule(new PingTask(this), 0, 5000);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
