/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.util.regex.Pattern;

/**
 *
 * @author Oskari
 */
public class Lauta {

    private int leveys = 8;
    private int pituus = 8;
    private Nappula[][] nappulat = new Nappula[leveys][pituus];

    public Nappula getNappula(int[] koordinaatit) {
        return nappulat[koordinaatit[0]][koordinaatit[1]];
    }

    public Nappula getNappula(String string) {
        int [] koordinaatit = parseAlgebraic(string);
        return getNappula(koordinaatit);
    }
    public void alustaLauta() {
        int[] koordinaatit = {0, 0};
        Tyhja tyhja = new Tyhja();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                nappulat[i][j] = tyhja;
            }
        }
    }

    public boolean aseta(Nappula nappula, int[] koordinaatit) {
        if (nappulat[koordinaatit[0]][koordinaatit[1]].isEmpty()) {
            nappulat[koordinaatit[0]][koordinaatit[1]] = nappula;
            if (!nappula.isEmpty()) {
                int[] vanhaSijainti = nappula.getKoordinaatit();
                if (vanhaSijainti[0] != -1) {
                    nappulat[vanhaSijainti[0]][vanhaSijainti[1]] = new Tyhja();
                }
                nappula.asetaKoordinaatit(koordinaatit);
            }
        } else {
            System.out.println("Ruudussa on jo nappula");
            return false;
        }
        return true;
    }

    public boolean syo(Nappula nappula, int[] koordinaatit) {
        if (nappulat[koordinaatit[0]][koordinaatit[1]].isEmpty()) {
            System.out.println("Ruudussa ei ole syötävää nappulaa");
            return false;
        } else {
            nappulat[koordinaatit[0]][koordinaatit[1]] = nappula;
            int[] vanhaSijainti = nappula.getKoordinaatit();
            nappulat[vanhaSijainti[0]][vanhaSijainti[1]] = new Tyhja();
            nappula.asetaKoordinaatit(koordinaatit);
        }
        return true;
    }

    public void printBoardState() {
        int[] koordinaatit = {0, 0};
        for (int i = 7; i >= 0; i--) {
            koordinaatit[1] = i;
            for (int j = 0; j < 8; j++) {
                koordinaatit[0] = j;
                System.out.print(getNappula(koordinaatit).getMerkki());
            }
            System.out.println("");
        }
    }

    public int[] parseAlgebraic(String string) {
        int[] koordinaatit = new int[2];
        koordinaatit[0] = string.charAt(0) - 97;
        koordinaatit[1] = string.charAt(1) - 49;
        return koordinaatit;
    }

    public int[][] parseCommand(String string, Nappula.Puoli vuoro) {
        Pattern pattern = Pattern.compile("[a-z][1-8]-[a-z][1-8]");
        int[][] startEndPoints = new int[2][2];
        if (pattern.matcher(string).matches()) {
            startEndPoints[0] = parseAlgebraic(string);
            startEndPoints[1] = parseAlgebraic(string.substring(3));
            return startEndPoints;
        }
        Pattern sotilas = Pattern.compile("[a-z][1-8]");
        if (sotilas.matcher(string).matches()) {
            return parseSotilas(string, vuoro);
        }
        Pattern sotilasSyonti = Pattern.compile("x[a-z][1-8]");
        if (sotilasSyonti.matcher(string).matches()) {
            return parseSotilasSyonti(string, vuoro);
        }
        Pattern upseeri = Pattern.compile("[A-Z][a-z][1-8]");
        if (upseeri.matcher(string).matches()) {
            System.out.println("Parsing for officers not done yet");
        }
        return null;
    }

    public int[][] parseSotilas(String string, Nappula.Puoli vuoro) {
        int[][] startEndPoints = new int[2][2];
        int[] koordinaatit = new int[2];
        koordinaatit[0] = string.charAt(0) - 97;
        koordinaatit[1] = string.charAt(1) - 49;
//        System.out.println(startEndPoints[0][0]+","+startEndPoints[0][1]+"-"+startEndPoints[1][0]+","+startEndPoints[1][0]);
        int[] testKoord = new int[2];

        if (vuoro == Nappula.Puoli.VALKOINEN) {
//            System.out.println((int) getNappula(testKoord).getMerkki());
            testKoord[0] = koordinaatit[0];
            testKoord[1] = koordinaatit[1] - 1;
            if (getNappula(testKoord).isEmpty()) {
                testKoord[1] = koordinaatit[1] - 2;
            }
            if (getNappula(testKoord).getMerkki() == '\u2659') {
                startEndPoints[1] = parseAlgebraic(string);
                startEndPoints[0] = testKoord;
            }
        }
        if (vuoro == Nappula.Puoli.MUSTA) {
            testKoord[0] = koordinaatit[0];
            testKoord[1] = koordinaatit[1] + 1;
            if (getNappula(testKoord).isEmpty()) {
                testKoord[1] = koordinaatit[1] + 2;
            }
            if (getNappula(testKoord).getMerkki() == '\u265F') {
                startEndPoints[1] = parseAlgebraic(string);
                startEndPoints[0] = testKoord;
            }
        }
        return startEndPoints;
    }

    public int[][] parseSotilasSyonti(String string, Nappula.Puoli vuoro) {
        int[] koordinaatit = parseAlgebraic(string.substring(1));
        int[][] startEndPoints = new int[2][2];
        startEndPoints[1] = koordinaatit;
        int[] testKoord = new int[2];
        int n = 0;

        if (vuoro == Nappula.Puoli.VALKOINEN) {
            testKoord[1] = koordinaatit[1] - 1;

            if (koordinaatit[0] > 0) {
                testKoord[0] = koordinaatit[0] - 1;
                if (getNappula(testKoord).getMerkki() == '\u2659') {
                    startEndPoints[0][0] = testKoord[0];
                    startEndPoints[0][1] = testKoord[1];
                    n++;
                }
            }
            if (koordinaatit[0] < 7) {
                testKoord[0] = koordinaatit[0] + 1;
                if (getNappula(testKoord).getMerkki() == '\u2659') {
                    startEndPoints[0] = testKoord;
                    n++;
                }
            }
        } else {
            testKoord[1] = koordinaatit[1] + 1;
            if (koordinaatit[0] > 0) {
                testKoord[0] = koordinaatit[0] - 1;
                if (getNappula(testKoord).getMerkki() == '\u265F') {
                    startEndPoints[0][0] = testKoord[0];
                    startEndPoints[0][1] = testKoord[1];
                    n++;
                }
            }
            if (koordinaatit[0] < 7) {
                testKoord[0] = koordinaatit[0] + 1;
                if (getNappula(testKoord).getMerkki() == '\u265F') {
                    startEndPoints[0] = testKoord;
                    n++;
                }
            }
        }
        if (n > 1) {
            System.out.println("Komento ei yksikäsitteinen");
            return null;
        }
        return startEndPoints;
    }
}
