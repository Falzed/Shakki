package components;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class KuningatarTest {

    @Test
    public void testLiikkuminenTyhjallaLaudallaLahettimainen() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Kuningatar kuningatar1 = new Kuningatar("valkoinen", lauta);
        lauta.aseta(kuningatar1, koordinaatit);

        assertFalse(kuningatar1.move(koordinaatit));
        koordinaatit[0] = 6;
        koordinaatit[1] = 7;
        assertTrue(kuningatar1.move(koordinaatit));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(kuningatar1.move(koordinaatit));
        koordinaatit[0] = 4;
        koordinaatit[1] = 3;
        assertTrue(kuningatar1.move(koordinaatit));
        koordinaatit[0] = 6;
        koordinaatit[1] = 1;
        assertTrue(kuningatar1.move(koordinaatit));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(kuningatar1.move(koordinaatit));
    }

    @Test
    public void testLiikkuminenTyhjallaLaudallaTornimainen() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Kuningatar kuningatar = new Kuningatar("valkoinen", lauta);
        lauta.aseta(kuningatar, koordinaatit);

        assertFalse(kuningatar.move(koordinaatit));
        koordinaatit[0] = 2;
        koordinaatit[1] = 4;
        assertTrue(kuningatar.move(koordinaatit));
        koordinaatit[0] = 2;
        koordinaatit[1] = 6;
        assertTrue(kuningatar.move(koordinaatit));
        koordinaatit[0] = 2;
        koordinaatit[1] = 3;
        assertTrue(kuningatar.move(koordinaatit));
    }

    @Test
    public void eiVoiLiikkuaToisenNappulanLäpi() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Kuningatar kuningatar = new Kuningatar("valkoinen", lauta);
        lauta.aseta(kuningatar, koordinaatit);
        Lahetti lahetti2 = new Lahetti("musta", lauta);
        koordinaatit[0] = 4;
        koordinaatit[1] = 5;
        lauta.aseta(lahetti2, koordinaatit);
        koordinaatit[0] = 5;
        koordinaatit[1] = 6;
        assertFalse(kuningatar.move(koordinaatit));
    }

    @Test
    public void testSyominen() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Kuningatar kuningatar = new Kuningatar("valkoinen", lauta);
        lauta.aseta(kuningatar, koordinaatit);
        Lahetti lahetti2 = new Lahetti("musta", lauta);
        koordinaatit[0] = 5;
        koordinaatit[1] = 6;
        lauta.aseta(lahetti2, koordinaatit);
        assertTrue(kuningatar.move(koordinaatit));
    }

    @Test
    public void eiVoiSyodaOmaa() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Kuningatar kuningatar = new Kuningatar("valkoinen", lauta);
        lauta.aseta(kuningatar, koordinaatit);
        Lahetti lahetti2 = new Lahetti("valkoinen", lauta);
        koordinaatit[0] = 5;
        koordinaatit[1] = 6;
        lauta.aseta(lahetti2, koordinaatit);
        assertFalse(kuningatar.move(koordinaatit));
    }
}
