package util;

import components.Kuningas;
import components.*;
import components.Torni;
import history.Turn;
import history.TurnHistory;
import logic.Liikkuminen;
import logic.Parser;
import logic.Shakitus;

/**
 * Luokka on vain main-metodi minne tulee välillä työnnettyä bugista koodia ajettavaksi.
 * @author Oskari
 */
public class GenericDebugger {

    public static void main(String[] args) {
//        Lauta lauta = new Lauta();
//        lauta.alustaLauta();
//        lauta.aseta(new Kuningas("valkoinen"), "e1");
//        lauta.aseta(new Torni("musta"), "a1");
////        System.out.println(Shakitus.matissa(lauta, "valkoinen"));
//        lauta.aseta(new Torni("musta"), "a2");
//        System.out.println(Shakitus.matissa(lauta, "valkoinen"));

        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        lauta.aseta(new Kuningas("valkoinen"), "e1");
        lauta.aseta(new Torni("musta"), "a1");
        Lauta kopio = lauta.kopioi();
        
//        System.out.println(Shakitus.shakissa(lauta, "e1"));
//                System.out.println(Shakitus.shakissa(kopio, "e1"));
//        System.out.println(Liikkuminen.voikoSiirtya(Parser.parseAlgebraic("a1"), Parser.parseAlgebraic("e1"), lauta));
//        System.out.println("");
//        System.out.println(Liikkuminen.voikoSiirtya(Parser.parseAlgebraic("a1"), Parser.parseAlgebraic("e1"), kopio));
//        
        System.out.println(Shakitus.matissa(lauta, "valkoinen", null));
        System.out.println(Shakitus.matissa(kopio, "valkoinen", null));

    }
}
