package variants;
import components.*;

/**
 * Rajapinta shakkivarianteille.
 * @author Oskari
 */
public interface Variant {
    Nappula.Puoli ALOITTAJA = Nappula.Puoli.VALKOINEN;
    int LAUDAN_LEVEYS = 8;
    int LAUDAN_PITUUS = 8;
    Lauta LAUTA = new Lauta(LAUDAN_LEVEYS, LAUDAN_PITUUS);
    public void setUp();
    
    default public Lauta getLauta() {
        return LAUTA;
    }
    default public Nappula.Puoli getAloittaja() {
        return ALOITTAJA;
    }
}
