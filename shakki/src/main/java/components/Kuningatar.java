package components;

/**
 *
 * @author oemkulma
 */
public class Kuningatar extends Nappula {

    private static char valkoinenMerkki = '\u2655';
    private static char mustaMerkki = '\u265B';
    private static char notaatioMerkki = 'Q';

    /**
     *
     * @param puoli
     * @param lauta
     */
    public Kuningatar(String puoli) {
        super(puoli);
    }

    /**
     *
     * @return palauttaa valkoisen/mustan kuningattaren unicode-merkin.
     */
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
}
