package components;

public class Sotilas extends Nappula {

    public static char valkoinenMerkki = 'P';
    public static char mustaMerkki = 'p';

    public Sotilas(String puoli, Lauta lauta) {
        super(puoli, lauta);
    }

    
    //TODO: En passant, korotus
    @Override
    public boolean move(int[] koordinaatit) {
        if (captureMove(koordinaatit)) {
            return true;
        }
        if (koordinaatit[0] != getKoordinaatit()[0]) {
            return false;
        } else if (koordinaatit[0] == getKoordinaatit()[0]
                && koordinaatit[1] == getKoordinaatit()[1]) {
            return false;
        } else if (getPuoli() == Puoli.VALKOINEN) {
            if (koordinaatit[1] > getKoordinaatit()[1] + 2) {
                return false;
            }
            if (koordinaatit[1] < getKoordinaatit()[1] + 1) {
                return false;
            }
            if (koordinaatit[1] == getKoordinaatit()[1] + 1
                    && getLauta().getNappula(koordinaatit).isEmpty()) {
                return true;
            }
            int[] valissa = {getKoordinaatit()[0], getKoordinaatit()[1] + 1};
            if (!getLauta().getNappula(valissa).isEmpty()) {
                return false;
            }
        } else if (getPuoli() == Puoli.MUSTA) {
            if (koordinaatit[1] != getKoordinaatit()[1] - 1) {
                if (getKoordinaatit()[1] != 6) {
                    return false;
                }
                if (koordinaatit[1] != getKoordinaatit()[1] - 2) {
                    return false;
                }
                int[] valissa = {getKoordinaatit()[0], getKoordinaatit()[1] - 1};
                if (!getLauta().getNappula(valissa).isEmpty()) {
                    return false;
                }
            }
        } else if (!getLauta().getNappula(koordinaatit).isEmpty()) {
            return false;
        }
        getLauta().aseta(this, koordinaatit);
        return true;
    }

    public boolean captureMove(int[] koordinaatit) {
        if (koordinaatit[0] != getKoordinaatit()[0] + 1
                && koordinaatit[0] != getKoordinaatit()[0] - 1) {
            return false;
        } else if (getPuoli() == Puoli.VALKOINEN) {
            if (koordinaatit[1] != getKoordinaatit()[1] + 1) {
                return false;
            }
        } else if (getPuoli() == Puoli.MUSTA) {
            if (koordinaatit[1] != getKoordinaatit()[1] - 1) {
                return false;
            }
        } else if (getLauta().getNappula(koordinaatit).isEmpty()) {
            return false;
        } else if (getLauta().getNappula(koordinaatit).getPuoli().equals(getPuoli())) {
            return false;
        }
        getLauta().syo(this, koordinaatit);
        return true;
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
