package logic;

import components.Lauta;
import components.Nappula;

public class Liikkuminen {

    public static boolean koitaSiirtya(int[] mista, int[] minne, Lauta lauta) {
        Nappula nappula = lauta.getNappula(mista);
        if (nappula.getMerkki() == 'Q' || nappula.getMerkki() == 'q') {
            return kuningatarLiikkuminen(mista, minne, lauta, nappula.getPuoli());
        }
        if (nappula.getMerkki() == 'K' || nappula.getMerkki() == 'k') {
            return kuningasLiikkuminen(mista, minne, lauta, nappula.getPuoli());
        }
        if (nappula.getMerkki() == 'R' || nappula.getMerkki() == 'r') {
            return torniLiikkuminen(mista, minne, lauta, nappula.getPuoli());
        }
        if (nappula.getMerkki() == 'N' || nappula.getMerkki() == 'n') {
            return ratsuLiikkuminen(mista, minne, lauta, nappula.getPuoli());
        }
        if (nappula.getMerkki() == 'B' || nappula.getMerkki() == 'b') {
            return lahettiLiikkuminen(mista, minne, lauta, nappula.getPuoli());
        }
        if (nappula.getMerkki() == 'P' || nappula.getMerkki() == 'p') {
            return sotilasLiikkuminen(mista, minne, lauta, nappula.getPuoli());
        }

        return false;
    }

    public static boolean koitaSiirtya(Nappula nappula, int[] minne, Lauta lauta) {
        int[] mista = nappula.getKoordinaatit();
        return Liikkuminen.koitaSiirtya(mista, minne, lauta);
    }

    //TODO: Tornitus, ei voi liikkua uhattuun ruutuun
    private static boolean kuningasLiikkuminen(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {

        //TODO: tarkista ettei ruutu uhattu
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
        return siirry(mista, minne, lauta);
    }

    private static boolean siirry(int[] mista, int[] minne, Lauta lauta) {
        Nappula nappula = lauta.getNappula(mista);
        if (lauta.getNappula(minne).isEmpty()) {
            lauta.aseta(nappula, minne);
        } else {
            if (lauta.getNappula(minne).getPuoli() == nappula.getPuoli()) {
                System.out.println("Et voi syödä omaa nappulaasi");
                return false;
            } else {
                lauta.syo(nappula, minne);
            }
        }
        return true;
    }

    private static boolean kuningatarLiikkuminen(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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
        return siirry(mista, minne, lauta);
    }

    private static boolean torniLiikkuminen(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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
        return siirry(mista, minne, lauta);
    }

    private static boolean lahettiLiikkuminen(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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
        return siirry(mista, minne, lauta);
    }

    private static boolean ratsuLiikkuminen(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
        if (!oneTwo(mista, minne, lauta, puoli)) {
            return false;
        }
        return siirry(mista, minne, lauta);
    }

    private static boolean sotilasLiikkuminen(int[] mista, int[] minne, Lauta lauta, Nappula.Puoli puoli) {
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
        return siirry(mista, minne, lauta);
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
        return siirry(mista, minne, lauta);
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
        return siirry(mista, minne, lauta);
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
        return siirry(mista, minne, lauta);
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
        return siirry(mista, minne, lauta);
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
        return siirry(mista, minne, lauta);
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
        return siirry(mista, minne, lauta);
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
        return siirry(mista, minne, lauta);
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
        return siirry(mista, minne, lauta);
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
        return siirry(mista, minne, lauta);
    }
}
