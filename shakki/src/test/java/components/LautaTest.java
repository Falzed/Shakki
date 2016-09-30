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
        Lauta lauta = new Lauta(8, 8);
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        assertTrue(lauta.aseta(new Sotilas("valkoinen"), koordinaatit));
    }

    @Test
    public void eiVoiAsettaaToisennappulanPäälle() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        lauta.aseta(new Sotilas("valkoinen"), "a1");
        assertFalse(lauta.aseta(new Sotilas("valkoinen"), "a1"));
    }

    @Test
    public void getNappulaAlgebraic() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        variants.Standard.setUp(lauta);
        assertEquals(lauta.getNappula("d1").getMerkki(), '\u2655');
    }

    @Test
    public void eiVoiSyodaTyhjaa() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        variants.Standard.setUp(lauta);
        int[] koord = {3, 5};
        assertFalse(lauta.syo(lauta.getNappula("d1"), koord));
    }

    @Test
    public void eiVoiSyodaOmaa() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        variants.Standard.setUp(lauta);
        lauta.aseta(new Kuningatar("valkoinen"), "d5");
        assertFalse(lauta.syo(lauta.getNappula("d1"), "d5"));
    }

    @Test
    public void voiSyodaVastustajan() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        variants.Standard.setUp(lauta);
        lauta.aseta(new Kuningatar("musta"), "d5");
        assertTrue(lauta.syo(lauta.getNappula("d1"), "d5"));
    }

    @Test
    public void eiVoiAsettaaOlemattomaanRuutuun() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        assertFalse(lauta.aseta(new Sotilas("valkoinen"), "z0"));
        assertFalse(lauta.aseta(new Sotilas("valkoinen"), "d9"));
        int[] koord = {-3, 100};
        assertFalse(lauta.aseta(new Sotilas("valkoinen"), koord));
        koord[0]=8;
        koord[1]=0;
        assertFalse(lauta.aseta(new Sotilas("valkoinen"), koord));
    }

    @Test
    public void eiVoisyodaOlematontaRuutua() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        variants.Standard.setUp(lauta);
        int[] koord= {-3, 100};
        assertFalse(lauta.syo(lauta.getNappula("d1"), "z0"));
        assertFalse(lauta.syo(lauta.getNappula("d1"), "d9"));
        assertFalse(lauta.syo(lauta.getNappula("d1"), koord));
    }
}
