package me.Cooltimmetje.TUMCore.Listeners;

import me.Cooltimmetje.TUMCore.Utilities.ChatUtils;
import me.Cooltimmetje.TUMCore.Utilities.MiscUtils;
import me.Cooltimmetje.TUMCore.Utilities.ScheduleUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

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

        if(event.getPlayer().getName().equals("Tornado0611")){
            maike(event.getPlayer());
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        event.setQuitMessage(MiscUtils.color("&9RageQuit> &a" + event.getPlayer().getName()));
    }

    private void maike(Player p){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String date = dateFormat.format(cal.getTime());
        Random random = new Random();

        if(date.contains("11/06")){
            for(int i=0; i<169; i++){
                MiscUtils.shootFirework(p.getLocation(), p.getWorld().getName(), random.nextBoolean());
            }
            for(int i=0; i<10; i++) {
                Bukkit.broadcastMessage(MiscUtils.color("&a&lGEFELICITEERD MAIKE!!!"));
            }
        }
    }

}
