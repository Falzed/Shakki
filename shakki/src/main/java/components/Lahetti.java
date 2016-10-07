package components;

/**
 *Luokka toteuttaa standardishakin lähetin.
 * @author oemkulma
 */
public class Lahetti extends Nappula {

    private static char valkoinenMerkki = '\u2657';
    private static char mustaMerkki = '\u265D';
    private static char notaatioMerkki = 'B';

    /**
     *Konstruktori, kutsuu vain Nappula-luokan konstruktoria. Puoli stringinä.
     * @param puoli   valkoinen vai musta  * 
     */
    public Lahetti(String puoli) {
        super(puoli);
    }
    
    /**
     * Konstruktori, kutsuu vain Nappula-luokan konstruktoria. Puoli enumina.
     * @param puoli valkoinen/musta
     */
    public Lahetti(Nappula.Puoli puoli) {
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
    public Lahetti kopioi() {
        Lahetti kopio = new Lahetti(super.getPuoli());
//        kopio.asetaKoordinaatit(sijainti);
        return kopio;
    }
}
