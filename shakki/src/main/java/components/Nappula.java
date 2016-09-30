package components;

/**
 *  Luokka toteuttaa shakkinappulan. Nappulalla on puoli, sijainti laudalla ja 
 * merkki notaatiota varten. Tyhjän ruudun notaatiomerkiksi on valittu välilyönti.
 * Sama on käytössä sotilaalla (vaikka null olisi sille oikeampi), mutta
 * kummankaan merkkiä ei pitäisi koskaan käyttää mihinkään.
 * @author oemkulma
 */
public class Nappula {

    /**
     * Vaihtoehdot nappulan puolelle, valkoinen/musta/tyhjä ruutu.
     * Refaktoroidaan luultavasti myöhemmin variantti-luokkaan ja sen aliluokkiin.
     */
    public enum Puoli {

        /**
         *
         */
        VALKOINEN,

        /**
         *
         */
        MUSTA,

        /**
         *
         */
        TYHJA
    }
    private Puoli puoli;
    private int[] sijainti = {-1, -1};
    private static char notaatioMerkki;

    /**
     *
     * @param puoli     * 
     */
    public Nappula(String puoli) {
        if (puoli.equals("valkoinen")) {
            this.puoli = Puoli.VALKOINEN;
        } else if (puoli.equals("musta")) {
            this.puoli = Puoli.MUSTA;
        } else {
            System.out.println("Puoli ei kelpaa tai puuttuu");
        }
    }

    /**
     *
     */
    public Nappula() {
        puoli = Puoli.TYHJA;
    }

    public Puoli getPuoli() {
        return puoli;
    }

    public void asetaKoordinaatit(int[] koordinaatit) {
        this.sijainti[0] = koordinaatit[0];
        this.sijainti[1] = koordinaatit[1];
    }

    public int[] getKoordinaatit() {
        return this.sijainti;
    }
    public boolean isEmpty() {
        return false;
    }
    public char getMerkki() {
        return ' ';
    }

    public char getNotaatioMerkki() {
        return notaatioMerkki;
    }
}
