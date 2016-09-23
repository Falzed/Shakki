package components;

import components.Sotilas;
import components.Lauta;
import org.junit.Test;
import static org.junit.Assert.*;

public class LautaTest {

    @Test
    public void alustusTest() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                koordinaatit[0] = 1;
                koordinaatit[1] = j;
                assertTrue(lauta.getNappula(koordinaatit).isEmpty());
            }
        }
    }

    @Test
    public void voiAsettaaTyhjään() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        assertTrue(lauta.aseta(new Sotilas("valkoinen", lauta), koordinaatit));
    }

    @Test
    public void eiVoiAsettaaToisennappulanPäälle() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        lauta.aseta(new Sotilas("valkoinen", lauta), koordinaatit);
        assertFalse(lauta.aseta(new Sotilas("valkoinen", lauta), koordinaatit));
    }
}
