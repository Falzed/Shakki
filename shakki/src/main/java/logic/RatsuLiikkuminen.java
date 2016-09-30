package logic;

import components.Lauta;
import components.Nappula;

public class RatsuLiikkuminen {

    public static boolean oneTwo(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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
}
