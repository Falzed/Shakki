package components;

/**
 * Luokka toteuttaa standardishakin kuningattaren.
 *
 * @author oemkulma
 */
public class Kuningatar extends Nappula {

    private static char valkoinenMerkki = '\u2655';
    private static char mustaMerkki = '\u265B';
    private static char notaatioMerkki = 'Q';

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
     * @param puoli valkoinen/musta
     */
    public Kuningatar(Nappula.Puoli puoli) {
        super(puoli);
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

    /**
     *
     * @return Kuningattaren merkki (englanninkielisessä) algebrallisessa
     * notaatiossa
     */
    @Override
    public char getNotaatioMerkki() {
        return notaatioMerkki;
    }

    @Override
    public Kuningatar kopioi() {
        Kuningatar kopio = new Kuningatar(super.getPuoli());
//        kopio.asetaKoordinaatit(sijainti);
        return kopio;
    }
}
