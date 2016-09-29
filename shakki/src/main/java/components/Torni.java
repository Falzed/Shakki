package components;

public class Torni extends Nappula {

    public static char valkoinenMerkki = '\u2656';
    public static char mustaMerkki = '\u265C';

    public Torni(String puoli, Lauta lauta) {
        super(puoli, lauta);
    }

//    @Override
//    public boolean koitaSiirtya(int[] koordinaatit, Lauta lauta) {
//        if (koordinaatit[0] != getKoordinaatit()[0]
//                && koordinaatit[1] != getKoordinaatit()[1]) {
//            return false;
//        } else if (koordinaatit[0] == getKoordinaatit()[0]
//                && koordinaatit[1] == getKoordinaatit()[1]) {
//            return false;
//        } else if (koordinaatit[0] < getKoordinaatit()[0]) {
//            return moveLeft(koordinaatit, lauta);
//        } else if (koordinaatit[0] > getKoordinaatit()[0]) {
//            return moveRight(koordinaatit, lauta);
//        } else if (koordinaatit[1] < getKoordinaatit()[1]) {
//            return moveDown(koordinaatit, lauta);
//        } else if (koordinaatit[1] > getKoordinaatit()[1]) {
//            return moveUp(koordinaatit, lauta);
//        }
//        return siirry(koordinaatit, lauta);
//    }
//
//    public boolean moveLeft(int[] koordinaatit, Lauta lauta) {
//        int delta = super.getKoordinaatit()[0] - koordinaatit[0];
//        int[] testiKoordinaatit = {0, 0};
//        for (int i = 1; i < delta; i++) {
//            testiKoordinaatit[0] = getKoordinaatit()[0] - i;
//            testiKoordinaatit[1] = getKoordinaatit()[1];
//            if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
//                return false;
//            }
//        }
//        return siirry(koordinaatit, lauta);
//    }
//
//    public boolean moveRight(int[] koordinaatit, Lauta lauta) {
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
//    public boolean moveUp(int[] koordinaatit, Lauta lauta) {
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
//    public boolean moveDown(int[] koordinaatit, Lauta lauta) {
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
