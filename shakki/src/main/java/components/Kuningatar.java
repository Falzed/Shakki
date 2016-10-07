package components;

/**
 * Luokka toteuttaa standardishakin kuningattaren.
 *
 * @author oemkulma
 */
public class Kuningatar extends Nappula {

    private static final char VALKOINENMERKKI = '\u2655';
    private static final char MUSTAMERKKI = '\u265B';
    private static final char NOTAATIOMERKKI = 'Q';

    /**
     * Konstruktori, kutsuu vain Nappula-luokan konstruktoria. Puoli stringinä.
     *
     * @param puoli onko kuningatar valkoinen vai musta
     *
     */
    public Kuningatar(String puoli) {
        super(puoli);
    }

    /**
     * Konstruktori, kutsuu vain Nappula-luokan konstruktoria. Puoli enumina.
     *
     * @param puoli valkoinen/musta
     */
    public Kuningatar(Nappula.Puoli puoli) {
        super(puoli);
    }

    @Override
    public char getMerkki() {
        if (getPuoli().equals(Puoli.VALKOINEN)) {
            return VALKOINENMERKKI;
        }
        if (getPuoli().equals(Puoli.MUSTA)) {
            return MUSTAMERKKI;
        }
        return super.getMerkki();
    }
    
    @Override
    public char getNotaatioMerkki() {
        return NOTAATIOMERKKI;
    }

    @Override
    public Kuningatar kopioi() {
        Kuningatar kopio = new Kuningatar(super.getPuoli());
//        kopio.asetaKoordinaatit(sijainti);
        return kopio;
    }
}
