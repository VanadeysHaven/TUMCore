package me.Cooltimmetje.TUMCore.Utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by Cooltimmetje on 11/20/2015 at 8:35 PM.
 */
public class PlayerUtils {

    public static void setTab() {
        ScheduleUtils.scheduleTask(20, new Runnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if(ChatColor.stripColor(p.getDisplayName()).contains(p.getName()) || p.getName().equals("Jasper_visser")) {
                        p.setPlayerListName(p.getDisplayName());
                    } else {
                        p.setPlayerListName(MiscUtils.color(p.getDisplayName() + " &7&o(" + p.getName() + ")"));
                    }
                }
            }
        });
    }

}
