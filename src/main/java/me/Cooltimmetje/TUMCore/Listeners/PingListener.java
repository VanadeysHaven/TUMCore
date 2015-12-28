package me.Cooltimmetje.TUMCore.Listeners;

import me.Cooltimmetje.TUMCore.Enums.PingMessages;
import me.Cooltimmetje.TUMCore.Utilities.MiscUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * Created by Coolt on 11/15/2015.
 */
public class PingListener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event){
        event.setMotd(MiscUtils.color("&8[&6&o1.8 &8- &e&oVanilla&8] &9&lDe Ultimu MineKreftKroew \n&9&lTUM &8\u00BB &b&o" + PingMessages.randomMessage().getMOTD()));
    }


}
