package me.Cooltimmetje.TUMCore.Commands;

import me.Cooltimmetje.TUMCore.Utilities.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * This class has been created on 10/29/2015 at 19:38 by Cooltimmetje.
 */
public class Broadcast implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        if (cmd.getLabel().equalsIgnoreCase("mbc")) {
            Player p = (Player) sender;
            if(p.hasPermission("tum.cmd.mayorbroadcast")){
                StringBuilder sb = new StringBuilder();
                for (String arg1 : args) {
                    sb.append(" ").append(arg1);
                }
                ChatUtils.bcMsgTag("&lMAYOR", "&6&l" + sb.toString().trim());
            } else {
                ChatUtils.sendNoPremTag(p, "MBC");
            }
        }
        return false;
    }

}
