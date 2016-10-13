package util;

import components.Kuningas;
import components.*;
import components.Torni;
import history.Turn;
import history.TurnHistory;
import logic.liikkuminen.Liikkuminen;
import logic.Parser.Parser;
import logic.Shakitus;

/**
 * Luokka on vain main-metodi minne tulee välillä työnnettyä bugista koodia ajettavaksi.
 * @author Oskari
 */
public class GenericDebugger {
    public static void main(String[] args) {
        TurnHistory historia = new TurnHistory("1. d4 d5");
        System.out.println(historia);

    }
}
