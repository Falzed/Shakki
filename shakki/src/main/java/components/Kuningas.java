package components;

/**
 * Luokka toteuttaa standardishakin kuninkaan.
 * @author oemkulma
 */
public class Kuningas extends Nappula {

    private static char valkoinenMerkki = '\u2654';
    private static char mustaMerkki = '\u265A';
    private static char notaatioMerkki = 'K';

    /**
     *
     * @param puoli onko kuningas valkoinen vai musta     * 
     */
    public Kuningas(String puoli) {
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
}
