package components;

import components.Torni;
import components.Lauta;
import org.junit.Test;
import static org.junit.Assert.*;
import logic.Liikkuminen;

public class TorniTest {

    public TorniTest() {
    }

    @Test
    public void testLiikkuminenTyhjälläLaudalla() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Torni torni1 = new Torni("valkoinen");
        lauta.aseta(torni1, koordinaatit);

        assertFalse(Liikkuminen.koitaSiirtya(torni1, koordinaatit, lauta));
        koordinaatit[0] = 4;
        koordinaatit[1] = 2;
        assertFalse(Liikkuminen.koitaSiirtya(torni1, koordinaatit, lauta));
        koordinaatit[0] = 4;
        koordinaatit[1] = 4;
        assertTrue(Liikkuminen.koitaSiirtya(torni1, koordinaatit, lauta));
        koordinaatit[0] = 2;
        koordinaatit[1] = 4;
        assertTrue(Liikkuminen.koitaSiirtya(torni1, koordinaatit, lauta));
        koordinaatit[0] = 2;
        koordinaatit[1] = 6;
        assertTrue(Liikkuminen.koitaSiirtya(torni1, koordinaatit, lauta));
        koordinaatit[0] = 2;
        koordinaatit[1] = 3;
        assertTrue(Liikkuminen.koitaSiirtya(torni1, koordinaatit, lauta));
    }

    @Test
    public void eiVoiLiikkuaToisenNappulanLäpi() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Torni torni1 = new Torni("valkoinen");
        lauta.aseta(torni1, koordinaatit);
        koordinaatit[0] = 4;
        koordinaatit[1] = 4;
        Torni torni2 = new Torni("valkoinen");
        lauta.aseta(torni2, koordinaatit);

        koordinaatit[0] = 5;
        koordinaatit[1] = 4;
        assertFalse(Liikkuminen.koitaSiirtya(torni1, koordinaatit, lauta));
    }

    @Test
    public void testSyöminen() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Torni torni1 = new Torni("valkoinen");
        lauta.aseta(torni1, koordinaatit);
        koordinaatit[0] = 4;
        koordinaatit[1] = 4;
        Torni torni2 = new Torni("musta");
        lauta.aseta(torni2, koordinaatit);

        assertTrue(Liikkuminen.koitaSiirtya(torni1, koordinaatit, lauta));
    }
}
