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

        VALKOINEN,

        MUSTA,

        /**
         * Tyhjä ruutu.
         */
        TYHJA
    }
    private Puoli puoli;
    private int[] sijainti = {-1, -1};
    private static char notaatioMerkki = ' ';
    private boolean liikkunut;

    /**
     * Konstruktori, asettaa puolen ja ettei ole liikkunut.
     * @param puoli valkoinen vai musta
     */
    public Nappula(String puoli) {
        if (puoli.equals("valkoinen")) {
            this.puoli = Puoli.VALKOINEN;
        } else if (puoli.equals("musta")) {
            this.puoli = Puoli.MUSTA;
        } else {
            System.out.println("Puoli ei kelpaa tai puuttuu");
        }
        this.liikkunut = false;
    }
    
    /**
     * Luo uuden nappulan ja asettaa sen puolen.
     * @param puoli Valkoinen vai musta
     */
    public Nappula(Nappula.Puoli puoli) {
        this.puoli = puoli;
    }

    /**
     * Luo uuden nappulan ja asettaa sen puolen tyhjäksi ruuduksi.
     */
    public Nappula() {
        puoli = Puoli.TYHJA;
    }
    
    /**
     * Metodi palauttaa saman tyyppisen nappulan.
     * @return kopio
     */
    public Nappula kopioi() {
        Nappula kopio = new Nappula(puoli);
//        kopio.asetaKoordinaatit(sijainti);
        return kopio;
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

    public boolean onkoLiikkunut() {
        return liikkunut;
    }
    public void setLiikkunut() {
        this.liikkunut = true;
    }
    public char getNotaatioMerkki() {
        return notaatioMerkki;
    }
    
    public boolean onSotilas() {
        return false;
    }
}
