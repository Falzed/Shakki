package components;

public class Torni extends Nappula {
    
    public static char valkoinenMerkki = 'R';
    public static char mustaMerkki = 'r';

    public Torni(String puoli, Lauta lauta) {
        super(puoli, lauta);
    }

    @Override
    public boolean move(int[] koordinaatit) {
        if (koordinaatit[0] != getKoordinaatit()[0]
                && koordinaatit[1] != getKoordinaatit()[1]) {
            return false;
        } else if (koordinaatit[0] == getKoordinaatit()[0]
                && koordinaatit[1] == getKoordinaatit()[1]) {
            return false;
        } else if (koordinaatit[0] < getKoordinaatit()[0]) {
            return moveLeft(koordinaatit);
        } else if (koordinaatit[0] > getKoordinaatit()[0]) {
            return moveRight(koordinaatit);
        } else if (koordinaatit[1] < getKoordinaatit()[1]) {
            return moveDown(koordinaatit);
        } else if (koordinaatit[1] > getKoordinaatit()[1]) {
            return moveUp(koordinaatit);
        }
        return true;
    }

    private boolean moveLeft(int[] koordinaatit) {
        int delta = super.getKoordinaatit()[0] - koordinaatit[0];
        int[] testiKoordinaatit = {0, 0};
        for (int i = 1; i < delta; i++) {
            testiKoordinaatit[0] = getKoordinaatit()[0] - i;
            testiKoordinaatit[1] = getKoordinaatit()[1];
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
        if (!getLauta().getNappula(koordinaatit).isEmpty()) {
            if (getLauta().getNappula(koordinaatit).getPuoli()==(getPuoli())) {
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
        if(getPuoli().equals(Puoli.VALKOINEN)) {
            return valkoinenMerkki;
        }
        if(getPuoli().equals(Puoli.MUSTA)) {
            return mustaMerkki;
        }
        return super.getMerkki();
    }
}
