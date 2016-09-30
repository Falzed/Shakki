package components;

import logic.Liikkuminen;
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
        Kuningas kuningas = new Kuningas("valkoinen");
        lauta.aseta(kuningas, koordinaatit);
        assertFalse(Liikkuminen.koitaSiirtya(kuningas,koordinaatit, lauta));
        koordinaatit[0] = 4;
        koordinaatit[1] = 4;
        assertTrue(Liikkuminen.koitaSiirtya(kuningas, koordinaatit, lauta));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(Liikkuminen.koitaSiirtya(kuningas, koordinaatit, lauta));
        koordinaatit[0] = 3;
        koordinaatit[1] = 3;
        assertTrue(Liikkuminen.koitaSiirtya(kuningas, koordinaatit, lauta));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(Liikkuminen.koitaSiirtya(kuningas, koordinaatit, lauta));
        koordinaatit[0] = 2;
        koordinaatit[1] = 3;
        assertTrue(Liikkuminen.koitaSiirtya(kuningas, koordinaatit, lauta));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(Liikkuminen.koitaSiirtya(kuningas, koordinaatit, lauta));
        koordinaatit[0] = 4;
        koordinaatit[1] = 5;
        assertTrue(Liikkuminen.koitaSiirtya(kuningas, koordinaatit, lauta));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(Liikkuminen.koitaSiirtya(kuningas, koordinaatit, lauta));
        koordinaatit[0] = 3;
        koordinaatit[1] = 6;
        assertFalse(Liikkuminen.koitaSiirtya(kuningas, koordinaatit, lauta));
    }

    @Test
    public void testSyominen() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Kuningas kuningas = new Kuningas("valkoinen");
        lauta.aseta(kuningas, koordinaatit);
        Lahetti lahetti2 = new Lahetti("musta");
        koordinaatit[0] = 4;
        koordinaatit[1] = 4;
        lauta.aseta(lahetti2, koordinaatit);
        assertTrue(Liikkuminen.koitaSiirtya(kuningas, koordinaatit, lauta));
    }

    @Test
    public void eiVoiSyodaOmaa() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Kuningatar kuningas = new Kuningatar("valkoinen");
        lauta.aseta(kuningas, koordinaatit);
        Lahetti lahetti2 = new Lahetti("valkoinen");
        koordinaatit[0] = 5;
        koordinaatit[1] = 6;
        lauta.aseta(lahetti2, koordinaatit);
        assertFalse(Liikkuminen.koitaSiirtya(kuningas, koordinaatit, lauta));
    }
}
