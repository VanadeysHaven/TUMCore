package me.Cooltimmetje.TUMCore.Utilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * This class has been created on 10/28/2015 at 18:01 by Cooltimmetje.
 */
public class ChatUtils {

    public static void sendMsg(Player p, String msg){
        p.sendMessage(MiscUtils.color(msg));
    }

    public static void sendMsgTag(Player p, String tag, String msg){
        p.sendMessage(MiscUtils.color("&9" + tag + "&9> &a" + msg));
    }

    public static void bcMsgTag(String tag, String msg){
        Bukkit.broadcastMessage(MiscUtils.color("&9" + tag + "&9> &a" + msg));
    }

    public static void sendNoPremTag(Player p, String tag){
        p.sendMessage(MiscUtils.color("&9" + tag + "&9> &a" + error + "You do not have permission to do this!"));
    }

    public static void sendSoonTag(Player p, String tag){
        p.sendMessage(MiscUtils.color("&9" + tag + "&9> &a" + error + "SoonTM!"));
    }

    public static void clearChat(Player p){
        for(int i = 0; i < 100; i++){
            p.sendMessage(" ");
        }
    }


    public static String error = "&c&lERROR! &a";

}
