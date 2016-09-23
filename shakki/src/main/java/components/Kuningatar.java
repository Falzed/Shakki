package components;

public class Kuningatar extends Nappula {

    public static char valkoinenMerkki = 'Q';
    public static char mustaMerkki = 'q';

    public Kuningatar(String puoli, Lauta lauta) {
        super(puoli, lauta);
    }

    @Override
    public boolean move(int[] koordinaatit) {
        //Tornimaisesti liikkuminen
        if (koordinaatit[0] == getKoordinaatit()[0]) {
            if (koordinaatit[1] < getKoordinaatit()[1]) {
                return moveDown(koordinaatit);
            } else if (koordinaatit[1] > getKoordinaatit()[1]) {
                return moveUp(koordinaatit);
            }
            return false;
        }
        if (koordinaatit[1] == getKoordinaatit()[1]) {
            if (koordinaatit[0] < getKoordinaatit()[0]) {
                return moveLeft(koordinaatit);
            } else if (koordinaatit[0] > getKoordinaatit()[0]) {
                return moveRight(koordinaatit);
            }
            return false;
        }
        //Lähetin lailla
        if (koordinaatit[0] - getKoordinaatit()[0] != koordinaatit[1] - getKoordinaatit()[1]
                && koordinaatit[0] - getKoordinaatit()[0] != getKoordinaatit()[1] - koordinaatit[1]) {
            return false;
        } else if (koordinaatit[0] == getKoordinaatit()[0]
                && koordinaatit[0] == getKoordinaatit()[0]) {
            return false;
        } else if (koordinaatit[0] < getKoordinaatit()[0]
                && koordinaatit[1] < getKoordinaatit()[1]) {
            return moveLeftDown(koordinaatit);
        } else if (koordinaatit[0] > getKoordinaatit()[0]
                && koordinaatit[1] < getKoordinaatit()[1]) {
            return moveRightDown(koordinaatit);
        } else if (koordinaatit[0] < getKoordinaatit()[0]
                && koordinaatit[1] > getKoordinaatit()[1]) {
            return moveLeftUp(koordinaatit);
        } else if (koordinaatit[0] > getKoordinaatit()[0]
                && koordinaatit[1] > getKoordinaatit()[1]) {
            return moveRightUp(koordinaatit);
        }
        return true;
    }

    private boolean moveLeftDown(int[] koordinaatit) {
        int delta = getKoordinaatit()[0] - koordinaatit[0];
        for (int i = 1; i < delta; i++) {
            int[] testiKoordinaatit
                    = {getKoordinaatit()[0] - i, getKoordinaatit()[1] - i};
            if (!getLauta().getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return onkoTyhja(koordinaatit);
    }

    private boolean moveLeftUp(int[] koordinaatit) {
        int delta = getKoordinaatit()[0] - koordinaatit[0];
        for (int i = 1; i < delta; i++) {
            int[] testiKoordinaatit
                    = {getKoordinaatit()[0] - i, getKoordinaatit()[1] + i};
            if (!getLauta().getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return onkoTyhja(koordinaatit);
    }

    private boolean moveRightDown(int[] koordinaatit) {
        int delta = koordinaatit[0] - getKoordinaatit()[0];
        for (int i = 1; i < delta; i++) {
            int[] testiKoordinaatit
                    = {getKoordinaatit()[0] + i, getKoordinaatit()[1] - i};
            if (!getLauta().getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return onkoTyhja(koordinaatit);
    }

    private boolean moveRightUp(int[] koordinaatit) {
        int delta = koordinaatit[0] - getKoordinaatit()[0];
        for (int i = 1; i < delta; i++) {
            int[] testiKoordinaatit
                    = {getKoordinaatit()[0] + i, getKoordinaatit()[1] + i};
            if (!getLauta().getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return onkoTyhja(koordinaatit);
    }

    private boolean onkoTyhja(int[] koordinaatit) {
        if (!getLauta().getNappula(koordinaatit).isEmpty()) {
            if (getLauta().getNappula(koordinaatit).getPuoli().equals(getPuoli())) {
                return false;
            } else {
                getLauta().syo(this, koordinaatit);
            }
        } else {
            getLauta().aseta(this, koordinaatit);
        }
        return true;
    }

    private boolean moveLeft(int[] koordinaatit) {
//    private boolean moveLeft(int[] koordinaatit, String suunta) {
        int delta = 0;
//        if (suunta.equals("vasen")) {
        delta = super.getKoordinaatit()[0] - koordinaatit[0];
//        } else if (suunta.equals("oikea")) {
//            delta = koordinaatit[0] - getKoordinaatit()[0];
//        } else {
//            return false;
//        }

        int[] testiKoordinaatit = {0, 0};
        for (int i = 1; i < delta; i++) {
//            if (suunta.equals("vasen")) {
            testiKoordinaatit[0] = getKoordinaatit()[0] - i;
//            } else {
            testiKoordinaatit[0] = getKoordinaatit()[0] + i;
//            }
            testiKoordinaatit[1] = getKoordinaatit()[1];
            if (!getLauta().getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return onkoTyhja(koordinaatit);
    }

    private boolean moveRight(int[] koordinaatit) {
        int delta = koordinaatit[0] - getKoordinaatit()[0];
        int[] testiKoordinaatit = {0, 0};
        for (int i = 1; i < delta; i++) {
            testiKoordinaatit[0] = getKoordinaatit()[0] + i;
            testiKoordinaatit[1] = getKoordinaatit()[1];
            if (!getLauta().getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return onkoTyhja(koordinaatit);
    }

    private boolean moveUp(int[] koordinaatit) {
        int delta = getKoordinaatit()[1] - koordinaatit[1];
        int[] testiKoordinaatit = {0, 0};
        for (int i = 1; i < delta; i++) {
            testiKoordinaatit[1] = getKoordinaatit()[1] - i;
            testiKoordinaatit[0] = getKoordinaatit()[0];
            if (!getLauta().getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return onkoTyhja(koordinaatit);
    }

    private boolean moveDown(int[] koordinaatit) {
        int delta = koordinaatit[1] - getKoordinaatit()[1];
        int[] testiKoordinaatit = {0, 0};
        for (int i = 1; i < delta; i++) {
            testiKoordinaatit[1] = getKoordinaatit()[1] + i;
            testiKoordinaatit[0] = getKoordinaatit()[0];
            if (!getLauta().getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
        return onkoTyhja(koordinaatit);
    }

    public boolean captureMove(int[] koordinaatit) {
        return move(koordinaatit);
    }

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
