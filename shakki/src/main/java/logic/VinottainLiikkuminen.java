package logic;

import components.Lauta;
import components.Nappula;

/**
 *Luokka tarjoaa apumetodit jotka kertovat voiko aloitusruudusta kulkea 
 * lähetin lailla kohderuutuun.
 * @author Oskari
 */
public class VinottainLiikkuminen {

    public static boolean moveLeftDown(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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

    public static boolean moveLeftUp(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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

    public static boolean moveRightDown(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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

    public static boolean moveRightUp(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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
