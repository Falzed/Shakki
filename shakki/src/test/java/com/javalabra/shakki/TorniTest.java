package com.javalabra.shakki;

import org.junit.Test;
import static org.junit.Assert.*;

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
        Torni torni1 = new Torni("valkoinen", lauta);
        lauta.aseta(torni1, koordinaatit);
        
        assertFalse(torni1.move(koordinaatit));
        koordinaatit[0] = 4;
        koordinaatit[1] = 2;
        assertFalse(torni1.move(koordinaatit));
        koordinaatit[0] = 4;
        koordinaatit[1] = 4;
        assertTrue(torni1.move(koordinaatit));
        koordinaatit[0] = 2;
        koordinaatit[1] = 4;
        System.out.println("afesgsg");
        assertTrue(torni1.move(koordinaatit));
        koordinaatit[0] = 2;
        koordinaatit[1] = 5;
        assertTrue(torni1.move(koordinaatit));
        koordinaatit[0] = 2;
        koordinaatit[1] = 3;
        assertTrue(torni1.move(koordinaatit));
    }

    @Test
    public void testSyöminen() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Torni torni1 = new Torni("valkoinen",lauta);
        lauta.aseta(torni1, koordinaatit);
        koordinaatit[0] = 4;
        koordinaatit[1] = 4;
        Torni torni2 = new Torni("musta", lauta);
        lauta.aseta(torni2, koordinaatit);
        
        assertTrue(torni1.captureMove(koordinaatit));
    }
}
