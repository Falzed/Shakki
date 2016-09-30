package components;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import logic.Liikkuminen;

public class LahettiTest {

    @Test
    public void testLiikkuminenTyhjallaLaudalla() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Lahetti lahetti1 = new Lahetti("valkoinen", lauta);
        lauta.aseta(lahetti1, koordinaatit);

        koordinaatit[0] = 5;
        koordinaatit[1] = 4;
        assertFalse(Liikkuminen.koitaSiirtya(lahetti1, koordinaatit, lauta));
        koordinaatit[0] = 2;
        koordinaatit[1] = 4;
        assertFalse(Liikkuminen.koitaSiirtya(lahetti1, koordinaatit, lauta));
        koordinaatit[0] = 3;
        koordinaatit[1] = 5;
        assertFalse(Liikkuminen.koitaSiirtya(lahetti1, koordinaatit, lauta));
        koordinaatit[0] = 3;
        koordinaatit[1] = 3;
        assertFalse(Liikkuminen.koitaSiirtya(lahetti1, koordinaatit, lauta));
        koordinaatit[0] = 4;
        koordinaatit[1] = 5;
        assertTrue(Liikkuminen.koitaSiirtya(lahetti1, koordinaatit, lauta));
        koordinaatit[0] = 6;
        koordinaatit[1] = 7;
        assertTrue(Liikkuminen.koitaSiirtya(lahetti1, koordinaatit, lauta));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(Liikkuminen.koitaSiirtya(lahetti1, koordinaatit, lauta));
        koordinaatit[0] = 4;
        koordinaatit[1] = 3;
        assertTrue(Liikkuminen.koitaSiirtya(lahetti1, koordinaatit, lauta));
        koordinaatit[0] = 6;
        koordinaatit[1] = 1;
        assertTrue(Liikkuminen.koitaSiirtya(lahetti1, koordinaatit, lauta));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(Liikkuminen.koitaSiirtya(lahetti1, koordinaatit, lauta));
    }

    @Test
    public void eiVoiLiikkuaToisenNappulanLäpi() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Lahetti lahetti1 = new Lahetti("valkoinen", lauta);
        lauta.aseta(lahetti1, koordinaatit);
        Lahetti lahetti2 = new Lahetti("musta", lauta);
        koordinaatit[0] = 4;
        koordinaatit[1] = 5;
        lauta.aseta(lahetti2, koordinaatit);
        koordinaatit[0] = 5;
        koordinaatit[1] = 6;
        assertFalse(Liikkuminen.koitaSiirtya(lahetti1, koordinaatit, lauta));
    }

    @Test
    public void testSyöminen() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Lahetti lahetti1 = new Lahetti("valkoinen", lauta);
        lauta.aseta(lahetti1, koordinaatit);
        Lahetti lahetti2 = new Lahetti("musta", lauta);
        koordinaatit[0] = 5;
        koordinaatit[1] = 6;
        lauta.aseta(lahetti2, koordinaatit);
        assertTrue(Liikkuminen.koitaSiirtya(lahetti1, koordinaatit, lauta));
    }
}
