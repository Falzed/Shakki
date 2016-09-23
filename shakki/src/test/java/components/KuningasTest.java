package components;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class KuningasTest {

    @Test
    public void testLiikkuminenTyhjallaLaudalla() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Kuningas kuningas = new Kuningas("valkoinen", lauta);
        lauta.aseta(kuningas, koordinaatit);

        assertFalse(kuningas.move(koordinaatit));
        koordinaatit[0] = 4;
        koordinaatit[1] = 4;
        assertTrue(kuningas.move(koordinaatit));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(kuningas.move(koordinaatit));
        koordinaatit[0] = 3;
        koordinaatit[1] = 3;
        assertTrue(kuningas.move(koordinaatit));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(kuningas.move(koordinaatit));
        koordinaatit[0] = 2;
        koordinaatit[1] = 3;
        assertTrue(kuningas.move(koordinaatit));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(kuningas.move(koordinaatit));
        koordinaatit[0] = 4;
        koordinaatit[1] = 5;
        assertTrue(kuningas.move(koordinaatit));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(kuningas.move(koordinaatit));
        koordinaatit[0] = 3;
        koordinaatit[1] = 6;
        assertFalse(kuningas.move(koordinaatit));
    }

    @Test
    public void testSyominen() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Kuningas kuningas = new Kuningas("valkoinen", lauta);
        lauta.aseta(kuningas, koordinaatit);
        Lahetti lahetti2 = new Lahetti("musta", lauta);
        koordinaatit[0] = 4;
        koordinaatit[1] = 4;
        lauta.aseta(lahetti2, koordinaatit);
        assertTrue(kuningas.move(koordinaatit));
    }

    @Test
    public void eiVoiSyodaOmaa() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Kuningatar kuningas = new Kuningatar("valkoinen", lauta);
        lauta.aseta(kuningas, koordinaatit);
        Lahetti lahetti2 = new Lahetti("valkoinen", lauta);
        koordinaatit[0] = 5;
        koordinaatit[1] = 6;
        lauta.aseta(lahetti2, koordinaatit);
        assertFalse(kuningas.move(koordinaatit));
    }
}
