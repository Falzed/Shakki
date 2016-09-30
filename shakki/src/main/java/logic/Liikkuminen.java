package logic;

import components.Lauta;
import components.Nappula;

/**
 * Luokka hoitaa kaiken laudalla liikkumisen, ja tarjoaa myös metodit jotka
 * kertovat voisiko nappula liikkua tiettyyn ruutuun.
 *
 *
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
     * Metodi koittaa siirtää annetun nappulan annettuun kohderuutuun.
     *
     * @param nappula siirrettävä nappula
     * @param minne kohderuudun koordinaatit
     * @param lauta lauta jolla nappula ja ruudut ovat
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
            voiko = SotilasLiikkuminen.sotilasVoikoLiikkua(mista, minne, lauta, nappula.getPuoli());
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

    public static boolean eiOma(int[] mista, int[] minne, Lauta lauta) {
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
        if (!torniVoikoLiikkua(mista, minne, lauta, puoli) && !lahettiVoikoLiikkua(mista, minne, lauta, puoli)) {
            return false;
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean torniVoikoLiikkua(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        if (minne[0] != mista[0] && minne[1] != mista[1]) {
            return false;
        } else if (minne[0] == mista[0] && minne[1] == mista[1]) {
            return false;
        } else if (minne[0] < mista[0]) {
            return OrtogonaalisestiLiikkuminen.moveLeft(mista, minne, lauta, puoli);
        } else if (minne[0] > mista[0]) {
            return OrtogonaalisestiLiikkuminen.moveRight(mista, minne, lauta, puoli);
        } else if (minne[1] < mista[1]) {
            return OrtogonaalisestiLiikkuminen.moveDown(mista, minne, lauta, puoli);
        } else if (minne[1] > mista[1]) {
            return OrtogonaalisestiLiikkuminen.moveUp(mista, minne, lauta, puoli);
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean lahettiVoikoLiikkua(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        if (minne[0] - mista[0] != minne[1] - mista[1]
                && minne[0] - mista[0] != mista[1] - minne[1]) {
            return false;
        } else if (minne[0] == mista[0] && minne[0] == mista[0]) {
            return false;
        } else if (minne[0] < mista[0] && minne[1] < mista[1]) {
            return VinottainLiikkuminen.moveLeftDown(mista, minne, lauta, puoli);
        } else if (minne[0] > mista[0] && minne[1] < mista[1]) {
            return VinottainLiikkuminen.moveRightDown(mista, minne, lauta, puoli);
        } else if (minne[0] < mista[0] && minne[1] > mista[1]) {
            return VinottainLiikkuminen.moveLeftUp(mista, minne, lauta, puoli);
        } else if (minne[0] > mista[0] && minne[1] > mista[1]) {
            return VinottainLiikkuminen.moveRightUp(mista, minne, lauta, puoli);
        }
        return eiOma(mista, minne, lauta);
    }

    private static boolean ratsuVoikoLiikkua(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        if (!RatsuLiikkuminen.oneTwo(mista, minne, lauta, puoli)) {
            return false;
        }
        return eiOma(mista, minne, lauta);
    }
}
