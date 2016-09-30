package components;

/**
 *
 * @author oemkulma
 */
public class Lahetti extends Nappula {

    private static char valkoinenMerkki = '\u2657';
    private static char mustaMerkki = '\u265D';
    private static char notaatioMerkki = 'B';

    /**
     *Luokka toteuttaa standardishakin lähetin.
     * @param puoli   valkoinen vai musta  * 
     */
    public Lahetti(String puoli) {
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
