package util;

import components.Kuningas;
import components.*;
import components.Torni;
import history.Turn;
import history.TurnHistory;
import logic.liikkuminen.Liikkuminen;
import logic.parser.*;
import logic.Shakitus;

/**
 * Luokka on vain main-metodi minne tulee välillä työnnettyä bugista koodia ajettavaksi.
 * @author Oskari
 */
public class GenericDebugger {
    public static void main(String[] args) {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = new int[2];
        koordinaatit[0] = 4;
        koordinaatit[1] = 4;
        Sotilas sotilas = new Sotilas("valkoinen");
        logic.LaudanMuutokset.aseta(sotilas, koordinaatit, lauta);
        ParserReturn parserRet = logic.parser.Parser.parseCommand("0-0-0", Nappula.Puoli.VALKOINEN, lauta);
        System.out.println(parserRet);
    }
}
