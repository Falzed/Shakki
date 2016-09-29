package components;

public class Kuningatar extends Nappula {

    public static char valkoinenMerkki = '\u2655';
    public static char mustaMerkki = '\u265B';

    public Kuningatar(String puoli, Lauta lauta) {
        super(puoli, lauta);
    }

//    @Override
//    public boolean koitaSiirtya(int[] koordinaatit, Lauta lauta) {
//        //Tornimaisesti liikkuminen
//        if (koordinaatit[0] == getKoordinaatit()[0]) {
//            if (koordinaatit[1] < getKoordinaatit()[1]) {
//                return moveDown(koordinaatit, lauta);
//            } else if (koordinaatit[1] > getKoordinaatit()[1]) {
//                return moveUp(koordinaatit, lauta);
//            }
//            return false;
//        }
//        if (koordinaatit[1] == getKoordinaatit()[1]) {
//            if (koordinaatit[0] < getKoordinaatit()[0]) {
//                return moveLeft(koordinaatit, lauta);
//            } else if (koordinaatit[0] > getKoordinaatit()[0]) {
//                return moveRight(koordinaatit, lauta);
//            }
//            return false;
//        }
//        //Lähetin lailla
//        if (koordinaatit[0] - getKoordinaatit()[0] != koordinaatit[1] - getKoordinaatit()[1]
//                && koordinaatit[0] - getKoordinaatit()[0] != getKoordinaatit()[1] - koordinaatit[1]) {
//            return false;
//        } else if (koordinaatit[0] == getKoordinaatit()[0]
//                && koordinaatit[0] == getKoordinaatit()[0]) {
//            return false;
//        } else if (koordinaatit[0] < getKoordinaatit()[0]
//                && koordinaatit[1] < getKoordinaatit()[1]) {
//            return moveLeftDown(koordinaatit, lauta);
//        } else if (koordinaatit[0] > getKoordinaatit()[0]
//                && koordinaatit[1] < getKoordinaatit()[1]) {
//            return moveRightDown(koordinaatit, lauta);
//        } else if (koordinaatit[0] < getKoordinaatit()[0]
//                && koordinaatit[1] > getKoordinaatit()[1]) {
//            return moveLeftUp(koordinaatit, lauta);
//        } else if (koordinaatit[0] > getKoordinaatit()[0]
//                && koordinaatit[1] > getKoordinaatit()[1]) {
//            return moveRightUp(koordinaatit, lauta);
//        }
//        return siirry(koordinaatit, lauta);
//    }
//
//    private boolean moveLeftDown(int[] koordinaatit, Lauta lauta) {
//        int delta = getKoordinaatit()[0] - koordinaatit[0];
//        for (int i = 1; i < delta; i++) {
//            int[] testiKoordinaatit
//                    = {getKoordinaatit()[0] - i, getKoordinaatit()[1] - i};
//            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
//                return false;
//            }
//        }
//        return siirry(koordinaatit, lauta);
//    }
//
//    private boolean moveLeftUp(int[] koordinaatit, Lauta lauta) {
//        int delta = getKoordinaatit()[0] - koordinaatit[0];
//        for (int i = 1; i < delta; i++) {
//            int[] testiKoordinaatit
//                    = {getKoordinaatit()[0] - i, getKoordinaatit()[1] + i};
//            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
//                return false;
//            }
//        }
//        return siirry(koordinaatit, lauta);
//    }
//
//    private boolean moveRightDown(int[] koordinaatit, Lauta lauta) {
//        int delta = koordinaatit[0] - getKoordinaatit()[0];
//        for (int i = 1; i < delta; i++) {
//            int[] testiKoordinaatit
//                    = {getKoordinaatit()[0] + i, getKoordinaatit()[1] - i};
//            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
//                return false;
//            }
//        }
//        return siirry(koordinaatit, lauta);
//    }
//
//    private boolean moveRightUp(int[] koordinaatit, Lauta lauta) {
//        int delta = koordinaatit[0] - getKoordinaatit()[0];
//        for (int i = 1; i < delta; i++) {
//            int[] testiKoordinaatit
//                    = {getKoordinaatit()[0] + i, getKoordinaatit()[1] + i};
//            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
//                return false;
//            }
//        }
//        return siirry(koordinaatit, lauta);
//    }
//
//    private boolean moveLeft(int[] koordinaatit, Lauta lauta) {
////    private boolean moveLeft(int[] koordinaatit, String suunta) {
//        int delta = 0;
////        if (suunta.equals("vasen")) {
//        delta = getKoordinaatit()[0] - koordinaatit[0];
////        } else if (suunta.equals("oikea")) {
////            delta = koordinaatit[0] - getKoordinaatit()[0];
////        } else {
////            return false;
////        }
//
//        int[] testiKoordinaatit = {0, 0};
//        for (int i = 1; i < delta; i++) {
////            if (suunta.equals("vasen")) {
//            testiKoordinaatit[0] = getKoordinaatit()[0] - i;
////            } else {
//            testiKoordinaatit[0] = getKoordinaatit()[0] + i;
////            }
//            testiKoordinaatit[1] = getKoordinaatit()[1];
//            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
//                return false;
//            }
//        }
//        return siirry(koordinaatit, lauta);
//    }
//
//    private boolean moveRight(int[] koordinaatit, Lauta lauta) {
//        int delta = koordinaatit[0] - getKoordinaatit()[0];
//        int[] testiKoordinaatit = {0, 0};
//        for (int i = 1; i < delta; i++) {
//            testiKoordinaatit[0] = getKoordinaatit()[0] + i;
//            testiKoordinaatit[1] = getKoordinaatit()[1];
//            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
//                return false;
//            }
//        }
//        return siirry(koordinaatit, lauta);
//    }
//
//    private boolean moveUp(int[] koordinaatit, Lauta lauta) {
//        int delta = getKoordinaatit()[1] - koordinaatit[1];
//        int[] testiKoordinaatit = {0, 0};
//        for (int i = 1; i < delta; i++) {
//            testiKoordinaatit[1] = getKoordinaatit()[1] - i;
//            testiKoordinaatit[0] = getKoordinaatit()[0];
//            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
//                return false;
//            }
//        }
//        return siirry(koordinaatit, lauta);
//    }
//
//    private boolean moveDown(int[] koordinaatit, Lauta lauta) {
//        int delta = koordinaatit[1] - getKoordinaatit()[1];
//        int[] testiKoordinaatit = {0, 0};
//        for (int i = 1; i < delta; i++) {
//            testiKoordinaatit[1] = getKoordinaatit()[1] + i;
//            testiKoordinaatit[0] = getKoordinaatit()[0];
//            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
//                return false;
//            }
//        }
//        return siirry(koordinaatit, lauta);
//    }
//
//    public boolean captureMove(int[] koordinaatit, Lauta lauta) {
//        return koitaSiirtya(koordinaatit, lauta);
//    }

    @Override
    public char getMerkki() {
        if (getPuoli().equals(Puoli.VALKOINEN)) {
            return valkoinenMerkki;
        }
        if (getPuoli().equals(Puoli.MUSTA)) {
            return mustaMerkki;
        }
        return super.getMerkki();
    }
}
