package me.Cooltimmetje.TUMCore.Commands;

import me.Cooltimmetje.TUMCore.Enums.RolesEnum;
import me.Cooltimmetje.TUMCore.Utilities.ChatUtils;
import me.Cooltimmetje.TUMCore.Utilities.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * This class has been created on 10/28/2015 at 17:48 by Cooltimmetje.
 */
public class RoleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        if(cmd.getLabel().equalsIgnoreCase("role")){
            Player p = (Player) sender;
            if(p.getName().equals("Thebluelegobrick")){
                ChatUtils.sendMsgTag(p, "Roles", "Erik nee...");
                return false;
            }
            if(args.length >= 1){
                switch(args[0]){
                    case "-list":
                        StringBuilder sb = new StringBuilder();
                        for(RolesEnum role : RolesEnum.values()){
                            if(p.hasPermission("tum.role." + role.toString().toLowerCase())) {
                                sb.append("&").append(role.getColor()).append(role.toString().toLowerCase()).append("&a, ");
                            }
                        }
                        ChatUtils.sendMsgTag(p, "Roles", "Available roles: " + sb.toString());
                        break;
                    default:
                        RolesEnum role = RolesEnum.valueOf(args[0].toUpperCase());
                        if(role != null){
                            if(!p.hasPermission("tum.role." + role.toString().toLowerCase())){
                                ChatUtils.sendMsgTag(p, "Roles", ChatUtils.error + "The role &" + role.getColor() + role.getName() + " &aisn't available to you!");
                            } else {
                                setRole(p, role);
                            }
                        } else {
                            ChatUtils.sendMsgTag(p, "Roles", ChatUtils.error + "Invalid role! &c" + args[0]);
                        }
                }
            }
        }
        return false;
    }

    private void setRole(Player p, RolesEnum role){

        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + p.getName() + " " + role.toString().toLowerCase());
        ChatUtils.sendMsgTag(p, "Roles", "You are now a &" + role.getColor() + role.getName() + "&a!");

        PlayerUtils.setTab();

    }

}
