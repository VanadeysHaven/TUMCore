package me.Cooltimmetje.TUMCore.Listeners;

import me.Cooltimmetje.TUMCore.Utilities.MiscUtils;
import me.Cooltimmetje.TUMCore.Utilities.ScheduleUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * This class has been created on 10/28/2015 at 20:25 by Cooltimmetje.
 */
public class JoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        event.setJoinMessage(MiscUtils.color("&9Join> &a" + event.getPlayer().getName()));

        ScheduleUtils.scheduleTask(20, new Runnable() {
            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){
                    p.setPlayerListName(p.getDisplayName());
                }
            }
        });
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        event.setQuitMessage(MiscUtils.color("&9RageQuit> &a" + event.getPlayer().getName()));
    }

}
