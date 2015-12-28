package me.Cooltimmetje.TUMCore.Timers;

import me.Cooltimmetje.TUMCore.Utilities.PlayerUtils;
import me.Cooltimmetje.TUMCore.Utilities.ScheduleUtils;
import org.bukkit.plugin.Plugin;

/**
 * Created by Cooltimmetje on 11/20/2015 at 9:01 PM.
 */
public class SetTabTimer {

    public static void start(Plugin plugin){
        ScheduleUtils.repeatTask(plugin, 6000, 6000, new Runnable() {
            @Override
            public void run() {
                PlayerUtils.setTab();
            }
        });
    }

}
