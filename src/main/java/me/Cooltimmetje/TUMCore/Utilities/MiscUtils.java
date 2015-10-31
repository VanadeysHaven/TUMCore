package me.Cooltimmetje.TUMCore.Utilities;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

/**
 * This class has been created on 10/28/2015 at 17:55 by Cooltimmetje.
 */
public class MiscUtils {

    public static String color(String s){
        return s.replace('&', '\u00A7');
    }

    public static int randomInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static void shootFirework(Location loc, String world, boolean instant){
        //Spawn the Firework, get the FireworkMeta.
        final Firework fw = (Firework) Bukkit.getWorld(world).spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();

        //Our random generator
        Random r = new Random();

        //Get the type
        int rt = r.nextInt(4) + 1;
        FireworkEffect.Type type = FireworkEffect.Type.BALL;
        if (rt == 1) type = FireworkEffect.Type.BALL;
        if (rt == 2) type = FireworkEffect.Type.BURST;
        if (rt == 3) type = FireworkEffect.Type.STAR;
        if (rt == 4) type = FireworkEffect.Type.CREEPER;
        if (rt == 5) type = FireworkEffect.Type.BALL_LARGE;

        //Get our random colours
        int r1i = r.nextInt(17) + 1;
        int r2i = r.nextInt(17) + 1;
        Color c1 = getColor(r1i);
        Color c2 = getColor(r2i);

        //Create our effect with this
        FireworkEffect effect = FireworkEffect.builder().flicker(false).withColor(c1).withFade(c2).with(type).trail(true).build();

        //Then apply the effect to the meta
        fwm.addEffect(effect);

        //Generate some random power and set it
        int rp = r.nextInt(2) + 1;
        fwm.setPower(rp);

        //Then apply this to our rocket
        fw.setFireworkMeta(fwm);

        if(instant){
            ScheduleUtils.scheduleTask(2, new Runnable() {
                @Override
                public void run() {
                    fw.detonate();
                }
            });
        }
    }

    private static Color getColor(int i) {
        Color c = null;
        if(i==1){
            c=Color.AQUA;
        }
        if(i==2){
            c=Color.BLACK;
        }
        if(i==3){
            c=Color.BLUE;
        }
        if(i==4){
            c=Color.FUCHSIA;
        }
        if(i==5){
            c=Color.GRAY;
        }
        if(i==6){
            c=Color.GREEN;
        }
        if(i==7){
            c=Color.LIME;
        }
        if(i==8){
            c=Color.MAROON;
        }
        if(i==9){
            c=Color.NAVY;
        }
        if(i==10){
            c=Color.OLIVE;
        }
        if(i==11){
            c=Color.ORANGE;
        }
        if(i==12){
            c=Color.PURPLE;
        }
        if(i==13){
            c=Color.RED;
        }
        if(i==14){
            c=Color.SILVER;
        }
        if(i==15){
            c=Color.TEAL;
        }
        if(i==16){
            c=Color.WHITE;
        }
        if(i==17){
            c= Color.YELLOW;
        }

        return c;
    }

    public static String formatTime(int cooldown) {
        int sec,min,hour;
        sec = cooldown;
        min = 0;
        hour = 0;
        while (sec >= 60){
            min = min + 1;
            sec = sec - 60;
        }
        while (min >= 60){
            hour = hour + 1;
            min = min - 60;
        }

        StringBuilder sb = new StringBuilder();
        if(hour != 0) {
            sb.append(hour + "h");
        }
        if (min != 0){
            sb.append(min + "m");
        }
        if (sec != 0){
            sb.append(sec + "s");
        }

        return sb.toString();
    }

    public static boolean cooldownCheck(long lastused, int cdtime){
        long currentTime = System.currentTimeMillis();
        int cdmillis = cdtime * 1000;
        return currentTime - lastused >= cdmillis;
    }

    public static int getTimeRemaining(long lastUsed, int cdtime){
        long currentTime = System.currentTimeMillis();

        return (int) (((currentTime - lastUsed ) / 1000) - cdtime) * -1;
    }

    public static boolean isInt(String str){
        try{
            int num = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
