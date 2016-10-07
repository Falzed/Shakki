package logic;

import components.Lauta;
import components.Nappula;
import java.util.Arrays;
import components.Tyhja;

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
     * @param puoli onko valkoisen vai mustan vuoro
     * @param enPassant ruutu, josta voi ohesta lyöda sotilaan (jos oma sotilas
     * oikeassa paikassa)
     *
     * @return onnistuiko siirto
     */
    public static boolean koitaSiirtyaTarkistaShakki(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli, int[] enPassant) {
        Lauta kopio = lauta.kopioi();
        if (!koitaSiirtya(mista, minne, kopio, enPassant)) {
            return false;
        }
        if (Shakitus.shakissa(kopio, puoli)) {
            return false;
        }
        return koitaSiirtya(mista, minne, lauta, enPassant);
    }

    /**
     * Metodi koittaa siirtää annetussa ruudussa olevan nappulan annettuun
     * kohderuutuun.
     *
     * @param nappula siirrettävä nappula
     * @param minne kohderuudun koordinaatit
     * @param lauta lauta jolla nappula ja ruudut ovat
     * @param puoli
     * @param enPassant ruutu, josta voi ohesta lyöda sotilaan (jos oma sotilas
     * oikeassa paikassa)
     *
     * @return onnistuiko siirto
     */
    public static boolean koitaSiirtyaTarkistaShakki(Nappula nappula, int[] minne, Lauta lauta, Nappula.Puoli puoli, int[] enPassant) {
        int[] mista = nappula.getKoordinaatit();
        Lauta kopio = lauta.kopioi();
        if (!koitaSiirtya(mista, minne, kopio, enPassant)) {
            return false;
        }
        if (Shakitus.shakissa(kopio, puoli)) {
            return false;
        }
        return koitaSiirtya(mista, minne, lauta, enPassant);
    }

    /**
     * Metodi koittaa siirtää annetussa ruudussa olevan nappulan annettuun
     * kohderuutuun. Ei huomioi siirrytäänkö shakkiin.
     *
     * @param mista lähtöruudun koordinaatit
     * @param minne kohderuudun koordinaatit
     * @param lauta lauta jolla nappula ja ruudut ovat
     * @param enPassant ruutu, josta voi ohesta lyöda sotilaan (jos oma sotilas
     * oikeassa paikassa)
     *
     * @return onnistuiko siirto
     */
    public static boolean koitaSiirtya(int[] mista, int[] minne, Lauta lauta, int[] enPassant) {
        Nappula nappula = lauta.getNappula(mista);
        if (!voikoSiirtya(mista, minne, lauta, enPassant)) {
            return false;
        }
        if (lauta.getNappula(mista).getNotaatioMerkki() == 'K'
                && Math.abs(mista[0] - minne[0]) == 2) {
            tornita(mista, minne, lauta);
            return true;
        }
        return siirry(mista, minne, lauta, enPassant);
    }

    /**
     * Metodi koittaa siirtää annetun nappulan annettuun kohderuutuun. Ei
     * huomioi siirrytäänkö shakkiin.
     *
     * @param nappula siirrettävä nappula
     * @param minne kohderuudun koordinaatit
     * @param lauta lauta jolla nappula ja ruudut ovat
     * @param enPassant ruutu, josta voi ohesta lyöda sotilaan (jos oma sotilas
     * oikeassa paikassa)
     * @return onnistuiko siirto
     */
    public static boolean koitaSiirtya(Nappula nappula, int[] minne, Lauta lauta, int[] enPassant) {
        if (nappula.isEmpty()) {
            return false;
        }
        int[] mista = nappula.getKoordinaatit();
        return Liikkuminen.koitaSiirtya(mista, minne, lauta, enPassant);
    }

    /**
     * Metodi koittaa siirtää annetun nappulan annettuun kohderuutuun. Ei
     * huomioi siirrytäänkö shakkiin, ja olettaa ettei voi ohestalyödä.
     *
     * @param nappula siirrettävä nappula
     * @param minne kohderuudun koordinaatit
     * @param lauta lauta jolla nappula ja ruudut ovat
     * @return onnistuiko siirto
     */
    public static boolean koitaSiirtya(Nappula nappula, int[] minne, Lauta lauta) {
        if (nappula.isEmpty()) {
            return false;
        }
        int[] mista = nappula.getKoordinaatit();
        return Liikkuminen.koitaSiirtya(mista, minne, lauta, null);
    }

    /**
     * Metodi suorittaa ohestalyönnin.
     *
     * @param nappula ohestalyövä sotilas
     * @param minne ohestalyötävän sotilaan koordinaatit
     * @param lauta lauta jolla sotilaat ovat
     */
    public static void enPassant(Nappula nappula, int[] minne, Lauta lauta) {
        if (nappula.getPuoli() == Nappula.Puoli.VALKOINEN) {
            int[] syotavanKoordinaatit = {minne[0], minne[1] - 1};
            lauta.enPassantPoistaSyoty(syotavanKoordinaatit);
        } else {
            int[] syotavanKoordinaatit = {minne[0], minne[1] + 1};
            lauta.enPassantPoistaSyoty(syotavanKoordinaatit);
        }
        lauta.aseta(nappula, minne);
    }

    private static boolean tornitaOikealle(Nappula kuningas, Nappula torni, Lauta lauta) {
        int[] minne = kuningas.getKoordinaatit();
        if (kuningas.getNotaatioMerkki() != 'K' || torni.getNotaatioMerkki() != 'R') {
            return false;
        }
        if (kuningas.onkoLiikkunut() || torni.onkoLiikkunut()) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            int[] koordinaatit = {minne[0] + i, minne[1]};
            if (Shakitus.uhattu(lauta, koordinaatit, kuningas.getPuoli())) {
                return false;
            }
        }
        minne[0] = minne[0] + 2;
        siirry(kuningas.getKoordinaatit(), minne, lauta);
        minne[0] = minne[0] - 1;
        siirry(torni.getKoordinaatit(), minne, lauta);
        return true;
    }

    private static boolean tornitaVasemmalle(Nappula kuningas, Nappula torni, Lauta lauta) {
        int[] minne = kuningas.getKoordinaatit();
        if (kuningas.getNotaatioMerkki() != 'K' || torni.getNotaatioMerkki() != 'R') {
            return false;
        }
        if (kuningas.onkoLiikkunut() || torni.onkoLiikkunut()) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            int[] koordinaatit = {minne[0] - i, minne[1]};
            if (Shakitus.uhattu(lauta, koordinaatit, kuningas.getPuoli())) {
                return false;
            }
        }
        minne[0] = minne[0] - 2;
        siirry(kuningas.getKoordinaatit(), minne, lauta);
        minne[0] = minne[0] + 1;
        siirry(torni.getKoordinaatit(), minne, lauta);
        return true;
    }

    /**
     *
     * Metodi tarkistaa, onko annetussa ruudussa olevan nappulan annettuun
     * kohderuutuun siirtäminen laillinen siirto.
     *
     * @param mista lähtöruudun koordinaatit
     * @param minne kohderuudun koordinaatit
     * @param lauta lauta jolla nappula ja ruudut ovat
     * @param enPassant ruutu, josta voi ohesta lyöda sotilaan (jos oma sotilas
     * oikeassa paikassa)
     * @return onko siirto laillinen
     */
    public static boolean voikoSiirtya(int[] mista, int[] minne, Lauta lauta, int[] enPassant) {
        if (lauta.getNappula(mista).isEmpty()) {
            return false;
        }
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
            voiko = SotilasLiikkuminen.sotilasVoikoLiikkua(mista, minne, lauta, nappula.getPuoli(), enPassant);
        }

        return voiko;
    }

    /**
     *
     * @param mista
     * @param minne
     * @param lauta
     * @param enPassant
     * @return
     */
    public static boolean voikoSiirtyaTornittamatta(int[] mista, int[] minne, Lauta lauta, int[] enPassant) {
        if (lauta.getNappula(mista).isEmpty()) {
            return false;
        }
        Nappula nappula = lauta.getNappula(mista);
        boolean voiko = false;
        if (nappula.getMerkki() == '\u2655' || nappula.getMerkki() == '\u265B') {
            voiko = kuningatarVoikoLiikkua(mista, minne, lauta, nappula.getPuoli());
        }
        if (nappula.getMerkki() == '\u2654' || nappula.getMerkki() == '\u265A') {
            voiko = kuningasVoikoLiikkuaTornittamatta(mista, minne, lauta, nappula.getPuoli());
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
            voiko = SotilasLiikkuminen.sotilasVoikoLiikkua(mista, minne, lauta, nappula.getPuoli(), enPassant);
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
     * @param enPassant ruutu, josta voi ohesta lyöda sotilaan (jos oma sotilas
     * oikeassa paikassa)
     * @return onko siirto laillinen
     */
    public static boolean voikoSiirtya(Nappula nappula, int[] minne, Lauta lauta, int[] enPassant) {
        return voikoSiirtya(nappula.getKoordinaatit(), minne, lauta, enPassant);
    }

    private static boolean siirry(int[] mista, int[] minne, Lauta lauta, int[] enPassant) {
        if (Arrays.equals(minne, enPassant) && lauta.getNappula(mista).onSotilas()) {
            enPassant(lauta.getNappula(mista), minne, lauta);
            return true;
        }
        Nappula nappula = lauta.getNappula(mista);
        if (lauta.getNappula(minne).isEmpty()) {
            lauta.aseta(nappula, minne);
        } else if (lauta.getNappula(minne).getPuoli() == nappula.getPuoli()) {
            System.out.println("Et voi syödä omaa nappulaasi");
            return false;
        } else {
            lauta.syo(nappula, minne);
        }
        nappula.setLiikkunut();
        return true;
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

    private static boolean siirry(Nappula nappula, int[] minne, Lauta lauta) {
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

    /**
     *
     * @param mista aloitusruudun koordinaatit
     * @param minne kohderuudun koordinaatit
     * @param lauta jolla liikutaan
     * @return onko kohde ruutu eri puolta kuin aloitusruudussa oleva nappula
     */
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
        if (voikoTornittaa(mista, minne, lauta, puoli)) {
            return true;
        }
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

    private static boolean kuningasVoikoLiikkuaTornittamatta(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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

    private static boolean voikoTornittaa(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        Nappula kuningas = lauta.getNappula(mista);
        if (Math.abs(minne[0] - mista[0]) != 2) {
            return false;
        }
        if (Shakitus.shakissa(lauta, puoli)) {
            return false;
        }
        Nappula torni = new Nappula();
        if (minne[0] > mista[0]) {
            int[] torninKoordinaatit = {lauta.getLeveys() - 1, minne[1]};
            torni = lauta.getNappula(torninKoordinaatit);
            for (int i = 0; i < 3; i++) {
                int[] koordinaatit = {mista[0] + i, minne[1]};
                if (Shakitus.uhattu(lauta, koordinaatit, puoli)
                        || (!lauta.getNappula(koordinaatit).isEmpty() && i != 0)) {
//                    System.out.println(Arrays.toString(koordinaatit));
//                    System.out.println("Shakissa: "+Shakitus.uhattu(lauta, koordinaatit, kuningas.getPuoli()));
//                    System.out.println("Ei tyhjä: "+!lauta.getNappula(koordinaatit).isEmpty());
//                    System.out.println(lauta.getNappula(koordinaatit).getPuoli());
//                    System.out.println(lauta.getNappula(koordinaatit).getNotaatioMerkki());
                    return false;
                }
            }
        } else {
            int[] torninKoordinaatit = {0, minne[1]};
            torni = lauta.getNappula(torninKoordinaatit);
            for (int i = 0; i < 3; i++) {
                int[] koordinaatit = {mista[0] - i, minne[1]};
                if (Shakitus.uhattu(lauta, koordinaatit, puoli)
                        || (!lauta.getNappula(koordinaatit).isEmpty() && i != 0)) {
                    return false;
                }
            }
        }
        if (kuningas.getPuoli() != torni.getPuoli()) {
            return false;
        }
        if (kuningas.getNotaatioMerkki() != 'K' || torni.getNotaatioMerkki() != 'R') {
            return false;
        }
        if (kuningas.onkoLiikkunut() || torni.onkoLiikkunut()) {
            return false;
        }
        return true;
    }

    private static void tornita(int[] mista, int[] minne, Lauta lauta) {
        Nappula kuningas = lauta.getNappula(mista);
        Nappula torni = new Nappula();
        if (minne[0] > mista[0]) {
            int[] torninKoordinaatit = {lauta.getLeveys() - 1, minne[1]};
            torni = lauta.getNappula(torninKoordinaatit);
            siirry(kuningas, minne, lauta);
            int[] torniMinne = {minne[0] - 1, minne[1]};
            siirry(torni, torniMinne, lauta);
        } else {
            int[] torninKoordinaatit = {0, minne[1]};
            torni = lauta.getNappula(torninKoordinaatit);
            int[] torniMinne = {minne[0] + 1, minne[1]};
            siirry(kuningas, minne, lauta);
            siirry(torni, torniMinne, lauta);
        }
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
