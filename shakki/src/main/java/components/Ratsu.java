package components;

public class Ratsu extends Nappula {

    public static char valkoinenMerkki = 'N';
    public static char mustaMerkki = 'n';

    public Ratsu(String puoli, Lauta lauta) {
        super(puoli, lauta);
    }

    @Override
    public void asetaKoordinaatit(int[] koordinaatit) {
        getKoordinaatit()[0] = koordinaatit[0];
        getKoordinaatit()[1] = koordinaatit[1];
    }

    @Override
    public boolean move(int[] koordinaatit) {
        if (!oneTwo(koordinaatit)) {
            return false;
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

    private boolean oneTwo(int[] koordinaatit) {
        if (Math.abs(koordinaatit[0] - getKoordinaatit()[0]) == 1) {
            if (Math.abs(koordinaatit[1] - getKoordinaatit()[1]) == 2) {
                return true;
            } else {
                return false;
            }
        }
        if (Math.abs(koordinaatit[0] - getKoordinaatit()[0]) == 2) {
            if (Math.abs(koordinaatit[1] - getKoordinaatit()[1]) == 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
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
