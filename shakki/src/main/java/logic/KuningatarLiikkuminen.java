package logic;

import components.Lauta;
import components.Nappula;

public class KuningatarLiikkuminen {
    public static boolean move(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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
        return true;
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
        return onkoTyhja(mista, minne, lauta, puoli);
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
        return onkoTyhja(mista, minne, lauta, puoli);
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
        return onkoTyhja(mista, minne, lauta, puoli);
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
        return onkoTyhja(mista, minne, lauta, puoli);
    }

    private static boolean onkoTyhja(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        if (!lauta.getNappula(minne).isEmpty()) {
            if (lauta.getNappula(minne).getPuoli().equals(puoli)) {
                return false;
            }
        }
        return true;
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
        return onkoTyhja(mista, minne, lauta, puoli);
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
        return onkoTyhja(mista, minne, lauta, puoli);
    }

    private static boolean moveUp(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        int delta = mista[1] - minne[1];
        int[] testiKoordinaatit = {0, 0};
        for (int i = 1; i < delta; i++) {
            testiKoordinaatit[1] = mista[1] - i;
            testiKoordinaatit[0] = mista[0];
            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return onkoTyhja(mista, minne, lauta, puoli);
    }

    private static boolean moveDown(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        int delta = minne[1] - mista[1];
        int[] testiKoordinaatit = {0, 0};
        for (int i = 1; i < delta; i++) {
            testiKoordinaatit[1] = mista[1] + i;
            testiKoordinaatit[0] = mista[0];
            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return onkoTyhja(mista, minne, lauta, puoli);
    }
}
