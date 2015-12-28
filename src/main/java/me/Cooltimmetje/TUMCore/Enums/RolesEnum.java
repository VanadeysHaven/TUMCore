package me.Cooltimmetje.TUMCore.Enums;

/**
 * This class has been created on 10/28/2015 at 13:49 by Cooltimmetje.
 */
public enum RolesEnum {

    NOOB("N00B",'7'),
    FARMER("Farmer",'e'),
    LUMBERJACK("Lumberjack",'2'),
    MINER("Miner",'d'),
    ERIK("Erik",'9'),
    BUTCHER("Butcher",'6'),
    BUILDER("Builder",'b'),
    ADMIN("Admin",'c'),
    MAYOR("Mayor",'3'),
    OWNER("Owner",'c'),
    ALIEN("Alien",'6'),
    ROOD("R00D",'4');

    private String name;
    private char color;

    RolesEnum(String s, char c){
        this.name = s;
        this.color = c;
    }


    public String getName() {
        return name;
    }

    public char getColor() {
        return color;
    }

}
