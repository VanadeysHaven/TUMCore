package me.Cooltimmetje.TUMCore;

import me.Cooltimmetje.TUMCore.Commands.Broadcast;
import me.Cooltimmetje.TUMCore.Commands.RoleCommand;
import me.Cooltimmetje.TUMCore.Listeners.AchievementListener;
import me.Cooltimmetje.TUMCore.Listeners.BodyslamListener;
import me.Cooltimmetje.TUMCore.Listeners.ChatListener;
import me.Cooltimmetje.TUMCore.Listeners.JoinQuitListener;
import me.Cooltimmetje.TUMCore.Utilities.MiscUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This class has been created on 10/28/2015 at 13:47 by Cooltimmetje.
 */
public class Main extends JavaPlugin {

    private long startTime;
    private static Plugin plugin;

    public void onEnable(){
        startTime = System.currentTimeMillis(); //Registers the plugin startTime to measure loading time afterwards...
        getLogger().info("Enabling plugin... Please wait.");
        sendDebug("&9Debug> &aStarting plugin load... &oPlease wait.");

        plugin = this; //Registering the plugin variable to allow other classes to access it

        getLogger().info("Starting pre-setup...."); //For everything that will cause issues if it gets done after registering stuff

        getLogger().info("Registering Listeners..."); //Well, this registers the listeners.
        registerListeners(this
                , new BodyslamListener(), new JoinQuitListener(), new AchievementListener(), new ChatListener()
        );

        getLogger().info("Registering Commands..."); //Can you guess what this does? Yes! It registers the commands.
        registerCommand("role", new RoleCommand());
        registerCommand("mbc", new Broadcast());
        //format: registerCommand("cmd", new ExecutorClass);

        getLogger().info("Starting setup"); //For stuff like, loading arraylists and databases.
        for(Player p : Bukkit.getOnlinePlayers()){
            p.setPlayerListName(p.getDisplayName());p.setPlayerListName(p.getDisplayName());
        }

        getLogger().info("Starting Timers..."); //Well, starts timers. Duh...


        getLogger().info("Starting post-setup"); //For frontend stuff, like scoreboards.


        getLogger().info("Finishing up..."); //For stuff that needs to be done after everything.


        getLogger().info("Plugin ready! (Loadtime: " + getLoad() + "ms)");
        sendDebug("&9Debug> &aPlugin load finished! &c(" + getLoad() + "ms) &3&oYou can take a look in the console for more load information.");
    }

    public void onDisable() {
        getLogger().info("Disabling plugin... Please wait.");



        plugin = null; //To prevent memory leaks
    }

    //Used to register Listeners.
    private void registerListeners(Plugin plugin, Listener... listeners){
        for(Listener listener : listeners){
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
            getLogger().info("Registered listener: " + listener.toString());
        }
    }

    //Used to resister commands.
    private void registerCommand(String cmd, CommandExecutor executor){
        getCommand(cmd).setExecutor(executor);
        getLogger().info("Registerd command \"" + cmd + "\" with executor\"" + executor.toString() + "\"");
    }

    //Used to hook API's
    private void hookApi(String api){
        if (getServer().getPluginManager().getPlugin(api) != null && getServer().getPluginManager().getPlugin(api).isEnabled())
            getLogger().info("Successfully hooked into " + api + "!");
        else {
            getLogger().warning("Failed to hook into " + api + ", disabling plugin!");
            getPluginLoader().disablePlugin(this);
        }
    }

    //Used to show the load time.
    private long getLoad(){
        return System.currentTimeMillis() - startTime;
    }

    //Used to send debug messages.
    public static void sendDebug(String msg){
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p.isOp()) {
                p.sendMessage(MiscUtils.color(msg));
            }
        }
    }

    //Returns the plugin instance.
    public static Plugin getPlugin() {
        return plugin;
    }

}
