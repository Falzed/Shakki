package components;

import org.junit.Test;
import logic.Liikkuminen;
import static org.junit.Assert.*;

public class ParseTest {

    @Test
    public void stuff() {
        //Standardi setup
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = new int[2];
        variants.Standard.setUp(lauta);
//        koordinaatit[0] = 0;
//        koordinaatit[1] = 0;
//        lauta.aseta(new Torni("valkoinen", lauta), koordinaatit);
//        koordinaatit[0] = 7;
//        lauta.aseta(new Torni("valkoinen", lauta), koordinaatit);
//
//        koordinaatit[1] = 7;
//        lauta.aseta(new Torni("musta", lauta), koordinaatit);
//        koordinaatit[0] = 0;
//        lauta.aseta(new Torni("musta", lauta), koordinaatit);
//        koordinaatit[0] = 1;
//        koordinaatit[1] = 0;
//        lauta.aseta(new Ratsu("valkoinen", lauta), koordinaatit);
//        koordinaatit[0] = 6;
//        lauta.aseta(new Ratsu("valkoinen", lauta), koordinaatit);
//
//        koordinaatit[1] = 7;
//        lauta.aseta(new Ratsu("musta", lauta), koordinaatit);
//        koordinaatit[0] = 1;
//        lauta.aseta(new Ratsu("musta", lauta), koordinaatit);
//        koordinaatit[0] = 2;
//        koordinaatit[1] = 0;
//        lauta.aseta(new Lahetti("valkoinen", lauta), koordinaatit);
//        koordinaatit[0] = 5;
//        lauta.aseta(new Lahetti("valkoinen", lauta), koordinaatit);
//
//        koordinaatit[1] = 7;
//        lauta.aseta(new Lahetti("musta", lauta), koordinaatit);
//        koordinaatit[0] = 2;
//        lauta.aseta(new Lahetti("musta", lauta), koordinaatit);
//        koordinaatit[0] = 3;
//        koordinaatit[1] = 0;
//        lauta.aseta(new Kuningatar("valkoinen", lauta), koordinaatit);
//        koordinaatit[1] = 7;
//        lauta.aseta(new Kuningatar("musta", lauta), koordinaatit);
//        koordinaatit[0] = 4;
//        koordinaatit[1] = 0;
//        lauta.aseta(new Kuningas("valkoinen", lauta), koordinaatit);
//        koordinaatit[1] = 7;
//        lauta.aseta(new Kuningas("musta", lauta), koordinaatit);
//
//        koordinaatit[1] = 1;
//        for (int i = 0; i < 8; i++) {
//            koordinaatit[0] = i;
//            lauta.aseta(new Sotilas("valkoinen", lauta), koordinaatit);
//        }
//        koordinaatit[1] = 6;
//        for (int i = 0; i < 8; i++) {
//            koordinaatit[0] = i;
//            lauta.aseta(new Sotilas("musta", lauta), koordinaatit);
//        }

        System.out.print("1. d4");
        Nappula.Puoli vuoro = Nappula.Puoli.VALKOINEN;

        int[][] startEndPoints = new int[2][2];
        int[] startPoint = {3, 1};
        int[] endPoint = {3, 3};
        startEndPoints[0] = startPoint;
        startEndPoints[1] = endPoint;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertTrue(lauta.parseCommand("d4", vuoro)[i][j] == startEndPoints[i][j]);
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
                assertTrue(lauta.parseCommand("d6", vuoro)[i][j] == startEndPoints[i][j]);
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
                assertTrue(lauta.parseCommand("c4", vuoro)[i][j] == startEndPoints[i][j]);
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
                assertTrue(lauta.parseCommand("e5", vuoro)[i][j] == startEndPoints[i][j]);
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
                assertTrue(lauta.parseCommand("xe5", vuoro)[i][j] == startEndPoints[i][j]);
            }
        }
        Liikkuminen.koitaSiirtya(lauta.getNappula(startPoint), endPoint, lauta);
    }
}
