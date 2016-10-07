package components;

/**
 * Luokka toteuttaa standardishakin sotilaan. Korotus puuttuu vielä.
 * @author oemkulma
 */
public class Sotilas extends Nappula {

    private static char valkoinenMerkki = '\u2659';
    private static char mustaMerkki = '\u265F';
    private static char notaatioMerkki = ' ';

    /**
     * Konstruktori, kutsuu vain Nappula-luokan konstruktoria. Puoli stringinä.
     * @param puoli valkoinen/musta
     */
    public Sotilas(String puoli) {
        super(puoli);
    }
    /**
     * Konstruktori, kutsuu vain Nappula-luokan konstruktoria. Puoli enumina.
     * @param puoli valkoinen/musta
     */
    public Sotilas(Nappula.Puoli puoli) {
        super(puoli);
    }
    
    @Override
    public char getNotaatioMerkki() {
        return notaatioMerkki;
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
    
    @Override
    public Sotilas kopioi() {
        Sotilas kopio = new Sotilas(super.getPuoli());
//        kopio.asetaKoordinaatit(sijainti);
        return kopio;
    }
    
    @Override
    public boolean onSotilas() {
        return true;
    }
}
