package logic;

import components.Nappula;
import java.util.regex.Pattern;
import components.Lauta;

public class Parser {

    public static int[] parseAlgebraic(String string) {
        int[] koordinaatit = new int[2];
        koordinaatit[0] = string.charAt(0) - 97;
        koordinaatit[1] = string.charAt(1) - 49;
        return koordinaatit;
    }

    public static int[][] parseCommand(String string, Nappula.Puoli vuoro, Lauta lauta) {
        Pattern pattern = Pattern.compile("[a-z][1-8]-[a-z][1-8]");
        int[][] startEndPoints = new int[2][2];
        if (pattern.matcher(string).matches()) {
            startEndPoints[0] = parseAlgebraic(string);
            startEndPoints[1] = parseAlgebraic(string.substring(3));
            return startEndPoints;
        }
        Pattern sotilas = Pattern.compile("[a-z][1-8]");
        if (sotilas.matcher(string).matches()) {
            return parseSotilas(string, vuoro, lauta);
        }
        Pattern sotilasSyonti = Pattern.compile("x[a-z][1-8]");
        if (sotilasSyonti.matcher(string).matches()) {
            return parseSotilasSyonti(string, vuoro, lauta);
        }
        Pattern upseeri = Pattern.compile("[A-Z][a-z][1-8]");
        if (upseeri.matcher(string).matches()) {
            return parseUpseeri(string, vuoro, lauta);
        }
        return null;
    }

    public static int[][] parseSotilas(String string, Nappula.Puoli vuoro, Lauta lauta) {
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
            if (lauta.getNappula(testKoord).isEmpty()) {
                testKoord[1] = koordinaatit[1] - 2;
            }
            if (lauta.getNappula(testKoord).getMerkki() == '\u2659') {
                startEndPoints[1] = parseAlgebraic(string);
                startEndPoints[0] = testKoord;
            }
        }
        if (vuoro == Nappula.Puoli.MUSTA) {
            testKoord[0] = koordinaatit[0];
            testKoord[1] = koordinaatit[1] + 1;
            if (lauta.getNappula(testKoord).isEmpty()) {
                testKoord[1] = koordinaatit[1] + 2;
            }
            if (lauta.getNappula(testKoord).getMerkki() == '\u265F') {
                startEndPoints[1] = parseAlgebraic(string);
                startEndPoints[0] = testKoord;
            }
        }
        return startEndPoints;
    }

    public static int[][] parseSotilasSyonti(String string, Nappula.Puoli vuoro, Lauta lauta) {
        int[] koordinaatit = parseAlgebraic(string.substring(1));
        int[][] startEndPoints = new int[2][2];
        startEndPoints[1] = koordinaatit;
        int[] testKoord = new int[2];
        int n = 0;

        if (vuoro == Nappula.Puoli.VALKOINEN) {
            testKoord[1] = koordinaatit[1] - 1;

            if (koordinaatit[0] > 0) {
                testKoord[0] = koordinaatit[0] - 1;
                if (lauta.getNappula(testKoord).getMerkki() == '\u2659') {
                    startEndPoints[0][0] = testKoord[0];
                    startEndPoints[0][1] = testKoord[1];
                    n++;
                }
            }
            if (koordinaatit[0] < 7) {
                testKoord[0] = koordinaatit[0] + 1;
                if (lauta.getNappula(testKoord).getMerkki() == '\u2659') {
                    startEndPoints[0] = testKoord;
                    n++;
                }
            }
        } else {
            testKoord[1] = koordinaatit[1] + 1;
            if (koordinaatit[0] > 0) {
                testKoord[0] = koordinaatit[0] - 1;
                if (lauta.getNappula(testKoord).getMerkki() == '\u265F') {
                    startEndPoints[0][0] = testKoord[0];
                    startEndPoints[0][1] = testKoord[1];
                    n++;
                }
            }
            if (koordinaatit[0] < 7) {
                testKoord[0] = koordinaatit[0] + 1;
                if (lauta.getNappula(testKoord).getMerkki() == '\u265F') {
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
    
    public static int[][] parseUpseeri(String string, Nappula.Puoli vuoro, Lauta lauta) {
        char notaatio = string.charAt(0);
        int[] koordinaatit = parseAlgebraic(string.substring(1));
        int[][] startEndPoints = new int[2][2];
        startEndPoints[1] = koordinaatit;
        int[] testKoord = new int[2];
        int n = 0;
        Nappula nappula;
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                testKoord[0]=i;
                testKoord[1]=j;
                nappula = lauta.getNappula(testKoord);
                if(nappula.getNotaatioMerkki()==notaatio && nappula.getPuoli()==vuoro) {
                    if(Liikkuminen.voikoSiirtya(nappula, koordinaatit, lauta)) {
                        n++;
                        startEndPoints[0][0] = testKoord[0];
                        startEndPoints[0][1] = testKoord[1];
                    }
                } 
            }
        }
        if(n>1) {
            System.out.println("Komento ei yksikäsitteinen");
            return null;
        }
        if(n==0) {
            return null;
        }
        return startEndPoints;        
    }
}
