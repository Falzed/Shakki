package logic;

import components.Lauta;
import components.Nappula;

/**
 * Luokka tarjoaa apumetodit jotka kertovat voiko aloitusruudusta kulkea 
 * tornin lailla kohderuutuun.
 * @author Oskari
 */
public class OrtogonaalisestiLiikkuminen {
    public static boolean moveLeft(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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

    public static boolean moveRight(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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

    public static boolean moveUp(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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

    public static boolean moveDown(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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
    
    private static boolean eiOma(int[] mista, int[] minne, Lauta lauta) {
        Nappula nappula = lauta.getNappula(mista);
        if (!lauta.getNappula(minne).isEmpty()) {
            if (lauta.getNappula(minne).getPuoli() == nappula.getPuoli()) {
                return false;
            }
        }
        return true;
    }
}
