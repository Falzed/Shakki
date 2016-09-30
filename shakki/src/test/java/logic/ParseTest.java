package logic;

import components.Lauta;
import components.Nappula;
import components.Torni;
import org.junit.Test;
import logic.Liikkuminen;
import org.junit.Assert;
import static org.junit.Assert.*;

public class ParseTest {

    @Test
    public void stuff() {
        //Standardi setup
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = new int[2];
        variants.Standard.setUp(lauta);

        System.out.print("1. d4");
        Nappula.Puoli vuoro = Nappula.Puoli.VALKOINEN;

        int[][] startEndPoints = new int[2][2];
        int[] startPoint = {3, 1};
        int[] endPoint = {3, 3};
        startEndPoints[0] = startPoint;
        startEndPoints[1] = endPoint;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertTrue(logic.Parser.parseCommand("d4", vuoro, lauta)[i][j] == startEndPoints[i][j]);
            }
        }
        Liikkuminen.koitaSiirtya(lauta.getNappula(startPoint), endPoint, lauta);

        System.out.println(" d6");
        vuoro = Nappula.Puoli.MUSTA;
        startPoint[0] = 3;
        startPoint[1] = 6;
        endPoint[0] = 3;
        endPoint[1] = 5;
        startEndPoints[0] = startPoint;
        startEndPoints[1] = endPoint;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertTrue(logic.Parser.parseCommand("d6", vuoro, lauta)[i][j] == startEndPoints[i][j]);
            }
        }
        Liikkuminen.koitaSiirtya(lauta.getNappula(startPoint), endPoint, lauta);

        System.out.print("2. c4");
        vuoro = Nappula.Puoli.VALKOINEN;
        startPoint[0] = 2;
        startPoint[1] = 1;
        endPoint[0] = 2;
        endPoint[1] = 3;
        startEndPoints[0] = startPoint;
        startEndPoints[1] = endPoint;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertTrue(logic.Parser.parseCommand("c4", vuoro, lauta)[i][j] == startEndPoints[i][j]);
            }
        }
        Liikkuminen.koitaSiirtya(lauta.getNappula(startPoint), endPoint, lauta);

        System.out.println(" e5");
        vuoro = Nappula.Puoli.MUSTA;
        startPoint[0] = 4;
        startPoint[1] = 6;
        endPoint[0] = 4;
        endPoint[1] = 4;
        startEndPoints[0] = startPoint;
        startEndPoints[1] = endPoint;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertTrue(logic.Parser.parseCommand("e5", vuoro, lauta)[i][j] == startEndPoints[i][j]);
            }
        }
        Liikkuminen.koitaSiirtya(lauta.getNappula(startPoint), endPoint, lauta);

        System.out.print("3. xe5");
        vuoro = Nappula.Puoli.VALKOINEN;
        startPoint[0] = 3;
        startPoint[1] = 3;
        endPoint[0] = 4;
        endPoint[1] = 4;
        startEndPoints[0] = startPoint;
        startEndPoints[1] = endPoint;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertTrue(logic.Parser.parseCommand("xe5", vuoro, lauta)[i][j] == startEndPoints[i][j]);
            }
        }
        Liikkuminen.koitaSiirtya(lauta.getNappula(startPoint), endPoint, lauta);
    }

    @Test
    public void upseeriTest() {
        //Standardi setup
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = new int[2];
        variants.Standard.setUp(lauta);

        Nappula.Puoli vuoro = Nappula.Puoli.VALKOINEN;

        int[][] startEndPoints = new int[2][2];
        int[] startPoint = {1, 0};
        int[] endPoint = {2, 2};
        startEndPoints[0] = startPoint;
        startEndPoints[1] = endPoint;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertTrue(logic.Parser.parseCommand("Nc3", vuoro, lauta)[i][j] == startEndPoints[i][j]);
            }
        }
        Liikkuminen.koitaSiirtya(lauta.getNappula(startPoint), endPoint, lauta);

        vuoro = Nappula.Puoli.MUSTA;
        startPoint[0] = 1;
        startPoint[1] = 7;
        endPoint[0] = 2;
        endPoint[1] = 4;
        startEndPoints[0] = startPoint;
        startEndPoints[1] = endPoint;
        assertTrue(logic.Parser.parseCommand("Nc5", vuoro, lauta) == null);
    }

    @Test
    public void komentoEiYksikasitteinen() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = new int[2];
        koordinaatit[0] = 4;
        koordinaatit[1] = 4;
        Torni torni = new Torni("valkoinen");
        Torni torni2 = new Torni("valkoinen");
        lauta.aseta(torni, koordinaatit);
        koordinaatit[0] = 4;
        koordinaatit[1] = 7;
        lauta.aseta(torni2, koordinaatit);
        assertTrue(logic.Parser.parseCommand("Re6", Nappula.Puoli.VALKOINEN, lauta) == null);

    }
}
