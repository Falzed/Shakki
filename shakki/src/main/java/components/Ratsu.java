package components;

/**
 * Luokka toteuttaa standardishakin ratsun.
 * @author oemkulma
 */
public class Ratsu extends Nappula {

    private static char valkoinenMerkki = '\u2658';
    private static char mustaMerkki = '\u265E';
    private static char notaatioMerkki = 'N';

    /**
     * Konstruktori, kutsuu vain Nappula-luokan konstruktoria. Puoli stringinä.
     * @param puoli valkoinen/musta
     */
    public Ratsu(String puoli) {
        super(puoli);
    }
    /**
     * Konstruktori, kutsuu vain Nappula-luokan konstruktoria. Puoli enumina.
     * @param puoli valkoinen/musta
     */
    public Ratsu(Nappula.Puoli puoli) {
        super(puoli);
    }

    @Override
    public void asetaKoordinaatit(int[] koordinaatit) {
        getKoordinaatit()[0] = koordinaatit[0];
        getKoordinaatit()[1] = koordinaatit[1];
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
    public Ratsu kopioi() {
        Ratsu kopio = new Ratsu(super.getPuoli());
//        kopio.asetaKoordinaatit(sijainti);
        return kopio;
    }
}
