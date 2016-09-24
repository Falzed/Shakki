package components;

public class Kuningas extends Nappula {

    public static char valkoinenMerkki = 'K';
    public static char mustaMerkki = 'k';

    public Kuningas(String puoli, Lauta lauta) {
        super(puoli, lauta);
    }

    //TODO: Tornitus, ei voi liikkua uhattuun ruutuun
    @Override
    public boolean move(int[] koordinaatit) {

        //TODO: tarkista ettei ruutu uhattu
        //if(getLauta().ruutuShakissa(koordinaatit)) { return false }
        if (Math.abs(koordinaatit[0] - getKoordinaatit()[0]) > 1) {
            return false;
        }
        if (Math.abs(koordinaatit[1] - getKoordinaatit()[1]) > 1) {
            return false;
        }
        if (koordinaatit[1] - getKoordinaatit()[1] == 0
                && koordinaatit[0] - getKoordinaatit()[0] == 0) {
            return false;
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
