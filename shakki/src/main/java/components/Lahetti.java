package components;

public class Lahetti extends Nappula {

    public static char valkoinenMerkki = '\u2657';
    public static char mustaMerkki = '\u265D';

    public Lahetti(String puoli, Lauta lauta) {
        super(puoli, lauta);
    }

//    @Override
//    public boolean koitaSiirtya(int[] koordinaatit, Lauta lauta) {
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
//        return false;
//    }
//
//    public boolean moveLeftDown(int[] koordinaatit, Lauta lauta) {
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
//    public boolean moveLeftUp(int[] koordinaatit, Lauta lauta) {
//        int delta = getKoordinaatit()[0] - koordinaatit[0];
//        for (int i = 1; i < delta; i++) {
//            int[] testiKoordinaatit
//                    = {getKoordinaatit()[0] - i, getKoordinaatit()[1] + i};
//            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
//                return false;
//            }
//        }
//        if (!lauta.getNappula(koordinaatit).isEmpty()) {
//            if (lauta.getNappula(koordinaatit).getPuoli().equals(getPuoli())) {
//                return false;
//            }
//        }
//        return siirry(koordinaatit, lauta);
//    }
//
//    public boolean moveRightDown(int[] koordinaatit, Lauta lauta) {
//        int delta = koordinaatit[0] - getKoordinaatit()[0];
//        for (int i = 1; i < delta; i++) {
//            int[] testiKoordinaatit
//                    = {getKoordinaatit()[0] + i, getKoordinaatit()[1] - i};
//            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
//                return false;
//            }
//        }
//        if (!lauta.getNappula(koordinaatit).isEmpty()) {
//            if (lauta.getNappula(koordinaatit).getPuoli().equals(getPuoli())) {
//                return false;
//            }
//        }
//        return siirry(koordinaatit, lauta);
//    }
//
//    public boolean moveRightUp(int[] koordinaatit, Lauta lauta) {
//        int delta = koordinaatit[0] - getKoordinaatit()[0];
//        for (int i = 1; i < delta; i++) {
//            int[] testiKoordinaatit
//                    = {getKoordinaatit()[0] + i, getKoordinaatit()[1] + i};
//            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
//                return false;
//            }
//        }
//        if (!lauta.getNappula(koordinaatit).isEmpty()) {
//            if (lauta.getNappula(koordinaatit).getPuoli().equals(getPuoli())) {
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
