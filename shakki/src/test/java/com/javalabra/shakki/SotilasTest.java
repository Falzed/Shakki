package com.javalabra.shakki;

import org.junit.Test;
import static org.junit.Assert.*;

public class SotilasTest {
    @Test
    public void valkoinenLiikkuuEteenpäin() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Sotilas sotilas1 = new Sotilas("valkoinen", lauta);
        lauta.aseta(sotilas1, koordinaatit);

        koordinaatit[0] = 3;
        koordinaatit[1] = 5;
        assertTrue(sotilas1.move(koordinaatit));
        
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertFalse(sotilas1.move(koordinaatit));
    }
    @Test
    public void mustaLiikkuuTaaksepäin() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Sotilas sotilas1 = new Sotilas("musta", lauta);
        lauta.aseta(sotilas1, koordinaatit);
        
        koordinaatit[0] = 3;
        koordinaatit[1] = 3;
        assertTrue(sotilas1.move(koordinaatit));
        
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertFalse(sotilas1.move(koordinaatit));
    }
    @Test
    public void syoVinoonValkoinen() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Sotilas sotilas1 = new Sotilas("valkoinen", lauta);
        lauta.aseta(sotilas1, koordinaatit);
        koordinaatit[0] = 4;
        koordinaatit[1] = 5;
        Sotilas sotilas2 = new Sotilas("musta", lauta);
        lauta.aseta(sotilas2, koordinaatit);
        koordinaatit[0] = 3;
        koordinaatit[1] = 5;
        Sotilas sotilas3 = new Sotilas("musta", lauta);
        lauta.aseta(sotilas3, koordinaatit);
        
        koordinaatit[0] = 3;
        koordinaatit[1] = 5;
        assertFalse(sotilas1.captureMove(koordinaatit));     
        koordinaatit[0] = 4;
        koordinaatit[1] = 5;
        assertTrue(sotilas1.captureMove(koordinaatit));       
    }
    @Test
    public void syoVinoonMusta() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Sotilas sotilas1 = new Sotilas("musta", lauta);
        lauta.aseta(sotilas1, koordinaatit);
        koordinaatit[0] = 2;
        koordinaatit[1] = 3;
        Sotilas sotilas2 = new Sotilas("valkoinen", lauta);
        lauta.aseta(sotilas2, koordinaatit);
        koordinaatit[0] = 3;
        koordinaatit[1] = 3;
        Sotilas sotilas3 = new Sotilas("valkoinen", lauta);
        lauta.aseta(sotilas3, koordinaatit);
        
        koordinaatit[0] = 3;
        koordinaatit[1] = 3;
        assertFalse(sotilas1.captureMove(koordinaatit));     
        koordinaatit[0] = 2;
        koordinaatit[1] = 3;
        System.out.println("MARK");
        assertTrue(sotilas1.captureMove(koordinaatit));       
    }
    @Test
    public void eiVoiLiikkuaSivulle() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Sotilas sotilas1 = new Sotilas("valkoinen", lauta);
        lauta.aseta(sotilas1, koordinaatit);
        
        koordinaatit[0] = 4;
        koordinaatit[1] = 4;
        assertFalse(sotilas1.move(koordinaatit));
        
        koordinaatit[0] = 2;
        koordinaatit[1] = 4;
        assertFalse(sotilas1.move(koordinaatit));
    }
}
