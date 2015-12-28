package me.Cooltimmetje.TUMCore.Enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Coolt on 11/15/2015.
 */
public enum PingMessages {

    TIM_DIK("Tim is dik."),
    TIM_DIK_Q("Zou Tim dik zijn?"),
    PRAISE_LORD("PRAISE THE LORD!"),
    HAIL_LORD("ALL HAIL LORT GEEBEN!"),
    AMY_FAT("Amy: \"Tim is a lazy fat fuk\""),
    DIRTY_JELLE("Vieze Jelle"),
    LEKKER_ERIK("LEKKER ERIK!"),
    POM_POM("Pom pom"),
    THIJS_PEASANT("Thijs you fucking peasant."),
    PCMR("/r/PCMASTERRACE"),
    STICKER("Nu met een gratis dora sticker!"),
    FAT_FREE("Fat Free! (psst.. I lied)"),
    DIKKE_BMW("Dikke BMW jongens, DIKKE BMW!"),
    JD_POAH("Een 6320, poah, een mooi ding."),
    XANDER_SMIKKELBEER("Xander Smikkelbeer."),
    LEKKER_SMIKKELEN("Lekker Smikkelen"),
    FLINTERMAND("FlinterMAND"),
    BUG_FREE("No bugs included, but they may occur."),
    JELLE_GRAMMARNAZI("Jelle = Grammarnazi"),
    MARTIJN_MESTKEVER("MARTIJN MESTKEVER"),
    JELLE_FATFUK("As Jelle would say: \"Tim you fat fuck\""),
    XANDER_VERRASING("Geef de speeltjes aan Xander.");

    private String s;

    PingMessages(String s) {
        this.s = s;
    }

    public String getMOTD() {
        return s;
    }

    private static final List<PingMessages> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static PingMessages randomMessage()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
