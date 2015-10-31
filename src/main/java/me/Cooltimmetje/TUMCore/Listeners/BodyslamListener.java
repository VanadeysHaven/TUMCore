package me.Cooltimmetje.TUMCore.Listeners;

import me.Cooltimmetje.TUMCore.Utilities.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

/**
 * This class has been created on 10/28/2015 at 20:15 by Cooltimmetje.
 */
public class BodyslamListener implements Listener {

    @EventHandler
    public void onBodyslam(PlayerInteractEntityEvent event){
        if(event.getPlayer().getName().equals("Cooltimmetje")){
            if(event.getRightClicked() instanceof Player){
                event.getRightClicked().setPassenger(event.getPlayer());
                ChatUtils.bcMsgTag("BodySlam", event.getPlayer().getDisplayName() + " &a&lBODYSLAMMED " + ((Player)event.getRightClicked()).getDisplayName() + "&a! &oIt was very effective.");
            }
        }
    }

}
