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
     * Konstruktori, kutsuu vain Nappula-luokan konstruktoria. Puoli stringinä.
     * @param puoli valkoinen/musta
     */
    public Torni(String puoli) {
        super(puoli);
    }
    /**
     * Konstruktori, kutsuu vain Nappula-luokan konstruktoria. Puoli enumina.
     * @param puoli valkoinen/musta
     */
    public Torni(Nappula.Puoli puoli) {
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
    public Torni kopioi() {
        Torni kopio = new Torni(super.getPuoli());
//        kopio.asetaKoordinaatit(sijainti);
        return kopio;
    }
}
