package components;

/**
 *
 * @author oemkulma
 */
public class Sotilas extends Nappula {

    private static char valkoinenMerkki = '\u2659';
    private static char mustaMerkki = '\u265F';
    private static char notaatioMerkki = ' ';

    /**
     *
     * @param puoli valkoinen vai musta
     * 
     */
    public Sotilas(String puoli) {
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
}
