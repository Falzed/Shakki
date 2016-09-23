package components;

public class Lahetti extends Nappula {

    public static char valkoinenMerkki = 'B';
    public static char mustaMerkki = 'b';

    public Lahetti(String puoli, Lauta lauta) {
        super(puoli, lauta);
    }

    @Override
    public boolean move(int[] koordinaatit) {
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

    public boolean moveLeftDown(int[] koordinaatit) {
        int delta = getKoordinaatit()[0] - koordinaatit[0];
        for (int i = 1; i < delta; i++) {
            int[] testiKoordinaatit
                    = {getKoordinaatit()[0] - i, getKoordinaatit()[1] - i};
            if (!getLauta().getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
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

    public boolean moveLeftUp(int[] koordinaatit) {
        int delta = getKoordinaatit()[0] - koordinaatit[0];
        for (int i = 1; i < delta; i++) {
            int[] testiKoordinaatit
                    = {getKoordinaatit()[0] - i, getKoordinaatit()[1] + i};
            if (!getLauta().getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
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

    public boolean moveRightDown(int[] koordinaatit) {
        int delta = koordinaatit[0] - getKoordinaatit()[0];
        for (int i = 1; i < delta; i++) {
            int[] testiKoordinaatit
                    = {getKoordinaatit()[0] + i, getKoordinaatit()[1] - i};
            if (!getLauta().getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
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

    public boolean moveRightUp(int[] koordinaatit) {
        int delta = koordinaatit[0] - getKoordinaatit()[0];
        for (int i = 1; i < delta; i++) {
            int[] testiKoordinaatit
                    = {getKoordinaatit()[0] + i, getKoordinaatit()[1] + i};
            if (!getLauta().getNappula(testiKoordinaatit).isEmpty()) {
                return false;
            }
        }
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
