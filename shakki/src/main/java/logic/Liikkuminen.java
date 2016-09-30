package logic;

import components.Lauta;
import components.Nappula;

/**
 * Luokka hoitaa kaiken laudalla liikkumisen, ja tarjoaa myös metodit jotka
 * kertovat voisiko nappula liikkua tiettyyn ruutuun. *
 * @author oemkulma
 */
public class Liikkuminen {

    /**
     * Metodi koittaa siirtää annetussa ruudussa olevan nappulan annettuun
     * kohderuutuun.
     *
     * @param mista lähtöruudun koordinaatit
     * @param minne kohderuudun koordinaatit
     * @param lauta lauta jolla nappula ja ruudut ovat
     *
     * @return onnistuiko siirto
     */
    public static boolean koitaSiirtya(int[] mista, int[] minne, Lauta lauta) {
        Nappula nappula = lauta.getNappula(mista);
        if (!voikoSiirtya(mista, minne, lauta)) {
            return false;
        }

        return siirry(mista, minne, lauta);
    }

    /**
     *
     * Metodi koittaa siirtää annetun nappulan annettuun kohderuutuun.
     *
     * @param nappula siirrettävä nappula
     * @param minne kohderuudun koordinaatit
     * @param lauta lauta jolla nappula ja ruudut ovat
     *
     * @return onnistuiko siirto
     */
    public static boolean koitaSiirtya(Nappula nappula, int[] minne, Lauta lauta) {
        int[] mista = nappula.getKoordinaatit();
        return Liikkuminen.koitaSiirtya(mista, minne, lauta);
    }

    
    /**
     *
     * Metodi tarkistaa, onko annetussa ruudussa olevan nappulan annettuun
     * kohderuutuun siirtäminen laillinen siirto.
     *
     * @param mista lähtöruudun koordinaatit
     * @param minne kohderuudun koordinaatit
     * @param lauta lauta jolla nappula ja ruudut ovat
     *
     * @return onko siirto laillinen
     */
    public static boolean voikoSiirtya(int[] mista, int[] minne, Lauta lauta) {
        Nappula nappula = lauta.getNappula(mista);
        boolean voiko = false;
        if (nappula.getMerkki() == '\u2655' || nappula.getMerkki() == '\u265B') {
            voiko = kuningatarVoikoLiikkua(mista, minne, lauta, nappula.getPuoli());
        }
        if (nappula.getMerkki() == '\u2654' || nappula.getMerkki() == '\u265A') {
            voiko = kuningasVoikoLiikkua(mista, minne, lauta, nappula.getPuoli());
        }
        if (nappula.getMerkki() == '\u2656' || nappula.getMerkki() == '\u265C') {
            voiko = torniVoikoLiikkua(mista, minne, lauta, nappula.getPuoli());
        }
        if (nappula.getMerkki() == '\u2658' || nappula.getMerkki() == '\u265E') {
            voiko = ratsuVoikoLiikkua(mista, minne, lauta, nappula.getPuoli());
        }
        if (nappula.getMerkki() == '\u2657' || nappula.getMerkki() == '\u265D') {
            voiko = lahettiVoikoLiikkua(mista, minne, lauta, nappula.getPuoli());
        }
        if (nappula.getMerkki() == '\u2659' || nappula.getMerkki() == '\u265F') {
            voiko = sotilasVoikoLiikkua(mista, minne, lauta, nappula.getPuoli());
        }

        return voiko;
    }

    /**
     *
     * Metodi tarkistaa, onko annetussa ruudussa olevan nappulan annettuun
     * kohderuutuun siirtäminen laillinen siirto.
     *
     * @param nappula siirrettävä nappula
     * @param minne kohderuudun koordinaatit
     * @param lauta lauta jolla nappula ja ruudut ovat
     *
     * @return onko siirto laillinen
     */
    public static boolean voikoSiirtya(Nappula nappula, int[] minne, Lauta lauta) {
        return voikoSiirtya(nappula.getKoordinaatit(), minne, lauta);
    }

    private static boolean siirry(int[] mista, int[] minne, Lauta lauta) {
        Nappula nappula = lauta.getNappula(mista);
        if (lauta.getNappula(minne).isEmpty()) {
            lauta.aseta(nappula, minne);
        } else if (lauta.getNappula(minne).getPuoli() == nappula.getPuoli()) {
            System.out.println("Et voi syödä omaa nappulaasi");
            return false;
        } else {
            lauta.syo(nappula, minne);
        }
        return true;
    }

    private static boolean eiOma(int[] mista, int[] minne, Lauta lauta) {
        Nappula nappula = lauta.getNappula(mista);
        if (!lauta.getNappula(minne).isEmpty()) {
            if (lauta.getNappula(minne).getPuoli() == nappula.getPuoli()) {
                return false;
            }
        }
        return true;
    }

    private static boolean kuningasVoikoLiikkua(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        //TODO: tornitus, tarkista ettei ruutu uhattu
        //if(getLauta().ruutuShakissa(minne)) { return false }
        if (Math.abs(minne[0] - mista[0]) > 1) {
            return false;
        }
        if (Math.abs(minne[1] - mista[1]) > 1) {
            return false;
        }
        if (minne[1] - mista[1] == 0
                && minne[0] - mista[0] == 0) {
            return false;
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean kuningatarVoikoLiikkua(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        //Tornimaisesti liikkuminen
        if (minne[0] == mista[0]) {
            if (minne[1] < mista[1]) {
                return moveDown(mista, minne, lauta, puoli);
            } else if (minne[1] > mista[1]) {
                return moveUp(mista, minne, lauta, puoli);
            }
            return false;
        }
        if (minne[1] == mista[1]) {
            if (minne[0] < mista[0]) {
                return moveLeft(mista, minne, lauta, puoli);
            } else if (minne[0] > mista[0]) {
                return moveRight(mista, minne, lauta, puoli);
            }
            return false;
        }
        //Lähetin lailla
        if (minne[0] - mista[0] != minne[1] - mista[1]
                && minne[0] - mista[0] != mista[1] - minne[1]) {
            return false;
        } else if (minne[0] == mista[0]
                && minne[0] == mista[0]) {
            return false;
        } else if (minne[0] < mista[0]
                && minne[1] < mista[1]) {
            return moveLeftDown(mista, minne, lauta, puoli);
        } else if (minne[0] > mista[0]
                && minne[1] < mista[1]) {
            return moveRightDown(mista, minne, lauta, puoli);
        } else if (minne[0] < mista[0]
                && minne[1] > mista[1]) {
            return moveLeftUp(mista, minne, lauta, puoli);
        } else if (minne[0] > mista[0]
                && minne[1] > mista[1]) {
            return moveRightUp(mista, minne, lauta, puoli);
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean torniVoikoLiikkua(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        if (minne[0] != mista[0]
                && minne[1] != mista[1]) {
            return false;
        } else if (minne[0] == mista[0]
                && minne[1] == mista[1]) {
            return false;
        } else if (minne[0] < mista[0]) {
            return moveLeft(mista, minne, lauta, puoli);
        } else if (minne[0] > mista[0]) {
            return moveRight(mista, minne, lauta, puoli);
        } else if (minne[1] < mista[1]) {
            return moveDown(mista, minne, lauta, puoli);
        } else if (minne[1] > mista[1]) {
            return moveUp(mista, minne, lauta, puoli);
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean lahettiVoikoLiikkua(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        if (minne[0] - mista[0] != minne[1] - mista[1]
                && minne[0] - mista[0] != mista[1] - minne[1]) {
            return false;
        } else if (minne[0] == mista[0]
                && minne[0] == mista[0]) {
            return false;
        } else if (minne[0] < mista[0]
                && minne[1] < mista[1]) {
            return moveLeftDown(mista, minne, lauta, puoli);
        } else if (minne[0] > mista[0]
                && minne[1] < mista[1]) {
            return moveRightDown(mista, minne, lauta, puoli);
        } else if (minne[0] < mista[0]
                && minne[1] > mista[1]) {
            return moveLeftUp(mista, minne, lauta, puoli);
        } else if (minne[0] > mista[0]
                && minne[1] > mista[1]) {
            return moveRightUp(mista, minne, lauta, puoli);
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean ratsuVoikoLiikkua(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        if (!oneTwo(mista, minne, lauta, puoli)) {
            return false;
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean sotilasVoikoLiikkua(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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
        return eiOma(mista, minne, lauta);
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
        return eiOma(mista, minne, lauta);
    }

    private static boolean oneTwo(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        if (Math.abs(minne[0] - mista[0]) == 1) {
            if (Math.abs(minne[1] - mista[1]) == 2) {
                return true;
            } else {
                return false;
            }
        }
        if (Math.abs(minne[0] - mista[0]) == 2) {
            if (Math.abs(minne[1] - mista[1]) == 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private static boolean moveLeftDown(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        int delta = mista[0] - minne[0];
        for (int i = 1; i < delta; i++) {
            int[] testiKoordinaatit
                    = {mista[0] - i, mista[1] - i};
            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean moveLeftUp(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        int delta = mista[0] - minne[0];
        for (int i = 1; i < delta; i++) {
            int[] testiKoordinaatit
                    = {mista[0] - i, mista[1] + i};
            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean moveRightDown(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        int delta = minne[0] - mista[0];
        for (int i = 1; i < delta; i++) {
            int[] testiKoordinaatit
                    = {mista[0] + i, mista[1] - i};
            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean moveRightUp(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        int delta = minne[0] - mista[0];
        for (int i = 1; i < delta; i++) {
            int[] testiKoordinaatit
                    = {mista[0] + i, mista[1] + i};
            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean moveLeft(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
//    private boolean moveLeft(int[] minne, String suunta) {
        int delta = 0;
//        if (suunta.equals("vasen")) {
        delta = mista[0] - minne[0];
//        } else if (suunta.equals("oikea")) {
//            delta = minne[0] - mista[0];
//        } else {
//            return false;
//        }

        int[] testiKoordinaatit = {0, 0};
        for (int i = 1; i < delta; i++) {
//            if (suunta.equals("vasen")) {
            testiKoordinaatit[0] = mista[0] - i;
//            } else {
            testiKoordinaatit[0] = mista[0] + i;
//            }
            testiKoordinaatit[1] = mista[1];
            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean moveRight(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        int delta = minne[0] - mista[0];
        int[] testiKoordinaatit = {0, 0};
        for (int i = 1; i < delta; i++) {
            testiKoordinaatit[0] = mista[0] + i;
            testiKoordinaatit[1] = mista[1];
            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean moveUp(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        int delta = minne[1] - mista[1];
        int[] testiKoordinaatit = {0, 0};
        for (int i = 1; i < delta; i++) {
            testiKoordinaatit[1] = mista[1] + i;
            testiKoordinaatit[0] = mista[0];
            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean moveDown(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        int delta = mista[1] - minne[1];
        int[] testiKoordinaatit = {0, 0};
        for (int i = 1; i < delta; i++) {
            testiKoordinaatit[1] = mista[1] - i;
            testiKoordinaatit[0] = mista[0];
            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return eiOma(mista, minne, lauta);
    }
}
