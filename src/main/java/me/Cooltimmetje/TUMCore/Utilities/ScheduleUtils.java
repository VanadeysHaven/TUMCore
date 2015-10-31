package me.Cooltimmetje.TUMCore.Utilities;

import me.Cooltimmetje.TUMCore.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 * This class has been created on 10/28/2015 at 17:56 by Cooltimmetje.
 */
public class ScheduleUtils {

    public static void scheduleTask(long delayTicks, Runnable runnable){
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), runnable, delayTicks);
    }

    public static void repeatTask(long startDelay, long repeatDelay, Runnable runnable){
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), runnable, startDelay, repeatDelay);
    }

    public static void repeatTask(Plugin plugin, long startDelay, long repeatDelay, Runnable runnable) {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, runnable, startDelay, repeatDelay);
    }

}
