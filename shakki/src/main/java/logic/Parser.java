package logic;

import components.Nappula;
import java.util.regex.Pattern;
import components.Lauta;

/**
 * Luokka tulkitsee annetut komennot ja algebralliset koordinaatit.
 */
public class Parser {

    /**
     * Tulkitsee algebrallisen koordinaatin (esim d4) x,y koordinaateiksi (esim
     * 3,3).
     *
     * @param string algebralliset koordinaatit
     * @return x,y koordinaatit
     */
    public static int[] parseAlgebraic(String string) {
//        Pattern pattern = Pattern.compile("[a-z][1-8]");
//        if(!pattern.matcher(string).matches()) {
//            return null;
//        }
        int[] koordinaatit = new int[2];
        koordinaatit[0] = string.charAt(0) - 97;
        koordinaatit[1] = string.charAt(1) - 49;
        return koordinaatit;
    }
    
//    private static String parseFirstPart(String string) {
//        String ret = "";
//        for(int i=0; i<string.length(); i++) {
//            if(string.charAt(i)>96 && string.charAt(i)<123) {
//                ret = ret.concat(Character.toString(string.charAt(i)));
//            }
//        }
//    }

    /**
     * Tulkitsee algebrallisen komennon siirron alku- ja loppukoordinaateiksi.
     * Esim d2-d4 =&gt; ((3,1),(3,3)), d4 =&gt;((3,1),(3,3)),
     * Qxd4 =&gt; ((3,0),(3,3)) (syö jotain d4:stä)
     * @param string annettu komento
     * @param vuoro onko valkoisen vai mustan vuoro
     * param lauta lauta jolla siirretään nappulaa
     * @return alku- ja loppukoordinaatit
     */
    public static int[][] parseCommand(String string, Nappula.Puoli vuoro, Lauta lauta) {
        Pattern pattern = Pattern.compile("[a-z][1-8]-[a-z][1-8]");
        int[][] startEndPoints = new int[2][2];
        if (pattern.matcher(string).matches()) {
            startEndPoints[0] = parseAlgebraic(string);
            System.out.println(startEndPoints[0]);
            startEndPoints[1] = parseAlgebraic(string.substring(3));
            System.out.println(startEndPoints[0]);
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

    private static int[][] parseSotilas(String string, Nappula.Puoli vuoro, Lauta lauta) {
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

    private static int[][] parseSotilasSyonti(String string, Nappula.Puoli vuoro, Lauta lauta) {
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

    private static int[][] parseUpseeri(String string, Nappula.Puoli vuoro, Lauta lauta) {
        char notaatio = string.charAt(0);
        int[] koordinaatit = parseAlgebraic(string.substring(1));
        System.out.println(koordinaatit[0]+","+koordinaatit[1]);
        int[][] startEndPoints = new int[2][2];
        startEndPoints[1] = koordinaatit;
        System.out.println(startEndPoints[1][0]+","+startEndPoints[1][1]);
        int[] testKoord = new int[2];
        int n = 0;
        Nappula nappula;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                testKoord[0] = i;
                testKoord[1] = j;
                nappula = lauta.getNappula(testKoord);
                if (nappula.getNotaatioMerkki() == notaatio && nappula.getPuoli() == vuoro) {
                    if (Liikkuminen.voikoSiirtya(nappula, koordinaatit, lauta)) {
                        n++;
                        startEndPoints[0][0] = testKoord[0];
                        startEndPoints[0][1] = testKoord[1];
                    }
                }
            }
        }
        if (n > 1) {
            System.out.println("Komento ei yksikäsitteinen");
            return null;
        }
        if (n == 0) {
            return null;
        }
        System.out.println(startEndPoints[1][0]+","+startEndPoints[1][1]);
        return startEndPoints;
    }
}
