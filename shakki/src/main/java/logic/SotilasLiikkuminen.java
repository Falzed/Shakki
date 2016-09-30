package logic;

import components.Lauta;
import components.Nappula;

public class SotilasLiikkuminen {

    public static boolean sotilasVoikoLiikkua(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        if (captureMove(mista, minne, lauta, puoli)) {
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

    private static boolean captureMove(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        if (lauta.getNappula(minne).getPuoli() == puoli) {
            return false;
        }
        if (minne[0] != mista[0] + 1
                && minne[0] != mista[0] - 1) {
            return false;
        } else if (puoli == Nappula.Puoli.VALKOINEN) {
            if (minne[1] != mista[1] + 1) {
                return false;
            }
        } else if (puoli == Nappula.Puoli.MUSTA) {
            if (minne[1] != mista[1] - 1) {
                return false;
            }
        } else if (lauta.getNappula(minne).isEmpty()) {
            return false;
        } else if (lauta.getNappula(minne).getPuoli().equals(puoli)) {
            return false;
        }
        return Liikkuminen.eiOma(mista, minne, lauta);
    }

}
