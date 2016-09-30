package variants;
import components.*;

/**
 * Rajapinta shakkivarianteille.
 * @author Oskari
 */
public interface Variant {
    Nappula.Puoli aloittaja = Nappula.Puoli.VALKOINEN;
    int laudanLeveys = 8;
    int laudanPituus = 8;
    Lauta lauta = new Lauta(laudanLeveys, laudanPituus);
    public void setUp();
    
    default public Lauta getLauta() {
        return lauta;
    }
    default public Nappula.Puoli getAloittaja() {
        return aloittaja;
    }
}
