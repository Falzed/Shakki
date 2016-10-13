package logic.Parser;

import components.Nappula;
import java.util.regex.Pattern;
import components.Lauta;
import logic.liikkuminen.VoikoSiirtya;

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
        Pattern pattern = Pattern.compile("[a-z][0-9]*");
        if (!pattern.matcher(string).matches()) {
            return null;
        }
        int[] koordinaatit = new int[2];
        koordinaatit[0] = string.charAt(0) - 97;
        koordinaatit[1] = string.charAt(1) - 49;
        return koordinaatit;
    }

    /**
     * Tulkitsee algebrallisen komennon siirron alku- ja loppukoordinaateiksi.
     * Esim d2-d4 =&gt; ((3,1),(3,3)), d4 =&gt;((3,1),(3,3)), Qxd4 =&gt;
     * ((3,0),(3,3)) (syö jotain d4:stä)
     *
     * @param string annettu komento
     * @param vuoro onko valkoisen vai mustan vuoro param lauta lauta jolla
     * siirretään nappulaa
     * @param lauta lauta jolla koitetaan siirtyä
     * @return alku- ja loppukoordinaatit
     */
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
            return SotilasParser.parseSotilas(string, vuoro, lauta);
        }
        Pattern sotilasSyonti = Pattern.compile("x[a-z][1-8]");
        if (sotilasSyonti.matcher(string).matches()) {
            return SotilasParser.parseSotilasSyonti(string, vuoro, lauta);
        }
        Pattern upseeri = Pattern.compile("[A-Z][a-z][1-8]|[\\u2654-\\u265F][a-z][1-8]");
        if (upseeri.matcher(string).matches()) {
            return parseUpseeri(string, vuoro, lauta);
        }
        Pattern tornitus = Pattern.compile("(O-){1,2}O|(0-){1,2}0");
        if (tornitus.matcher(string).matches()) {
            return parseTornitus(string, vuoro, lauta);
        }
        System.out.println("No match");
        return null;
    }

    private static int[][] parseUpseeri(String string, Nappula.Puoli vuoro, Lauta lauta) {
        char notaatio = string.charAt(0);
        int[] koordinaatit = parseAlgebraic(string.substring(1));
        int[][] startEndPoints = new int[2][2];
        startEndPoints[1] = koordinaatit;
        int[] testKoord = new int[2];
        int n = 0;
        Nappula nappula;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                testKoord[0] = i;
                testKoord[1] = j;
                nappula = lauta.getNappula(testKoord);
                if ((nappula.getNotaatioMerkki() == notaatio
                        || nappula.getMerkki() == notaatio)
                        && nappula.getPuoli() == vuoro) {
                    if (VoikoSiirtya.voikoSiirtya(nappula, koordinaatit, lauta, null)) {
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
        return startEndPoints;
    }

    private static int[][] parseTornitus(String string, Nappula.Puoli vuoro, Lauta lauta) {
        Nappula kuningas = null;
        int[][] startEnd = new int[2][2];
        for (int i = 0; i < lauta.getLeveys(); i++) {
            for (int j = 0; j < lauta.getPituus(); j++) {
                int[] koord = {i, j};
                if (lauta.getNappula(koord).getPuoli() == vuoro
                        && lauta.getNappula(koord).getNotaatioMerkki() == 'K') {
                    kuningas = lauta.getNappula(koord);
                    break;
                }
            }
        }
        if (string.equals("O-O") || string.equals("0-0")) {
            if (kuningas == null) {
                return null;
            }
            startEnd[0] = kuningas.getKoordinaatit();
            int[] end = {kuningas.getKoordinaatit()[0] + 2,
                kuningas.getKoordinaatit()[1]};
            startEnd[1] = end;
            return startEnd;
        }
        if (string.equals("O-O-O") || string.equals("0-0-0")) {
            if (kuningas == null) {
                return null;
            }
            startEnd[0] = kuningas.getKoordinaatit();
            int[] end = {kuningas.getKoordinaatit()[0] - 2,
                kuningas.getKoordinaatit()[1]};
            startEnd[1] = end;
            return startEnd;
        }
        return null;
    }
}
