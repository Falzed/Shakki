package logic;

import components.Lauta;
import components.Nappula;
import java.util.Arrays;

/**
 * Luokka tarjoaa apumetodit jotka kertovat voiko aloitusruudusta kulkea sotilas
 * kohderuutuun.
 *
 * @author Oskari
 */
public class SotilasLiikkuminen {

    /**
     * Metodi kertoo, voiko annetussa ruudussa oleva sotilas liikkua annettuun 
     * kohderuutuun.
     * @param mista aloitusruudun koordinaatit
     * @param minne kohderuudun koordinaatit
     * @param lauta lauta jolla ollaan
     * @param puoli onko siirrettävä nappula vlakoinen vai musta
     * @param enPassant ruutu, johon voi tällä vuorolla ohestalyödä
     * @return onko siirto mahdollinen
     */
    public static boolean sotilasVoikoLiikkua(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli, int[] enPassant) {
        if (captureMove(mista, minne, lauta, puoli, enPassant)) {
            return true;
        }
        if (minne[0] != mista[0]) {
            return false;
        } else if (minne[0] == mista[0]
                && minne[1] == mista[1]) {
            return false;
        } else if (puoli == Nappula.Puoli.VALKOINEN) {
            if (minne[1] > mista[1] + 2) {
                return false;
            }
            if (minne[1] < mista[1] + 1) {
                return false;
            }
            if (minne[1] == mista[1] + 1
                    && lauta.getNappula(minne).isEmpty()) {
                return true;
            }
            int[] valissa = {mista[0], mista[1] + 1};
            if (!lauta.getNappula(valissa).isEmpty()) {
                return false;
            }
        } else if (puoli == Nappula.Puoli.MUSTA) {
            if (minne[1] != mista[1] - 1) {
                if (mista[1] != 6) {
                    return false;
                }
                if (minne[1] != mista[1] - 2) {
                    return false;
                }
                int[] valissa = {mista[0], mista[1] - 1};
                if (!lauta.getNappula(valissa).isEmpty()) {
                    return false;
                }
            }
        } else if (!lauta.getNappula(minne).isEmpty()) {
            return false;
        }
        if (lauta.getNappula(minne).getPuoli() != lauta.getNappula(mista).getPuoli()
                && !lauta.getNappula(minne).isEmpty()) {
            return false;
        }
        return Liikkuminen.eiOma(mista, minne, lauta);
    }

    private static boolean captureMove(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli, int[] enPassant) {
        if (enPassant != null) {
            if (Arrays.equals(minne, enPassant)) {
//                Liikkuminen.enPassant(lauta.getNappula(mista), minne, lauta);
                return true;
            } 
//            else {
//                System.out.println(Arrays.toString(minne));
//                System.out.println(Arrays.toString(enPassant));
//            }
        }
        if (lauta.getNappula(minne).getPuoli() == puoli) {
            return false;
        }
        if (minne[0] != mista[0] + 1
                && minne[0] != mista[0] - 1) {
            return false;
        }
        if (puoli == Nappula.Puoli.VALKOINEN) {
            if (minne[1] != mista[1] + 1) {
                return false;
            }
        } else if (puoli == Nappula.Puoli.MUSTA) {
            if (minne[1] != mista[1] - 1) {
                return false;
            }
        }
        if (lauta.getNappula(minne).isEmpty()) {
            return false;
        }
        if (lauta.getNappula(minne).getPuoli().equals(puoli)) {
            return false;
        }
        return Liikkuminen.eiOma(mista, minne, lauta);
    }
}
