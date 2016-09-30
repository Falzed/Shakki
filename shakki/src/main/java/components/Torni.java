package components;

/**
 *Luokka toteuttaa standardishakin tornin. Tornitusta ei ole vielä toteutettu.
 * @author oemkulma
 */
public class Torni extends Nappula {

    private static char valkoinenMerkki = '\u2656';
    private static char mustaMerkki = '\u265C';
    private static char notaatioMerkki = 'R';

    /**
     *
     * @param puoli puoli valkoinen vai musta
     */
    public Torni(String puoli) {
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
