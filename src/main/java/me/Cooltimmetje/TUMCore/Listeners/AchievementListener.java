package me.Cooltimmetje.TUMCore.Listeners;

import me.Cooltimmetje.TUMCore.Utilities.MiscUtils;
import org.bukkit.Achievement;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

/**
 * This class has been created on 10/28/2015 at 20:27 by Cooltimmetje.
 */
public class AchievementListener implements Listener {

    @EventHandler
    public void onAchievement(PlayerAchievementAwardedEvent event){
        MiscUtils.shootFirework(event.getPlayer().getLocation(), event.getPlayer().getWorld().getName(), true);
        MiscUtils.shootFirework(event.getPlayer().getLocation(), event.getPlayer().getWorld().getName(), false);
    }

}
