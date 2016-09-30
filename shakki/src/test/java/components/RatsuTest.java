/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import components.Lauta;
import components.Sotilas;
import components.Ratsu;
import logic.Liikkuminen;
import org.junit.Test;
import static org.junit.Assert.*;

public class RatsuTest {

    @Test
    public void voiHypätäToisenNappulanYli() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Ratsu ratsu = new Ratsu("valkoinen");
        lauta.aseta(ratsu, koordinaatit);

        koordinaatit[0] = 3;
        koordinaatit[1] = 5;
        Sotilas sotilas1 = new Sotilas("valkoinen");
        lauta.aseta(sotilas1, koordinaatit);

        koordinaatit[0] = 3;
        koordinaatit[1] = 3;
        Sotilas sotilas2 = new Sotilas("valkoinen");
        lauta.aseta(sotilas2, koordinaatit);

        koordinaatit[0] = 2;
        koordinaatit[1] = 4;
        Sotilas sotilas3 = new Sotilas("valkoinen");
        lauta.aseta(sotilas3, koordinaatit);

        koordinaatit[0] = 4;
        koordinaatit[1] = 4;
        Sotilas sotilas4 = new Sotilas("valkoinen");
        lauta.aseta(sotilas4, koordinaatit);

        koordinaatit[0] = 4;
        koordinaatit[1] = 5;
        Sotilas sotilas5 = new Sotilas("valkoinen");
        lauta.aseta(sotilas5, koordinaatit);

        koordinaatit[0] = 2;
        koordinaatit[1] = 5;
        Sotilas sotilas6 = new Sotilas("valkoinen");
        lauta.aseta(sotilas6, koordinaatit);

        koordinaatit[0] = 2;
        koordinaatit[1] = 3;
        Sotilas sotilas7 = new Sotilas("valkoinen");
        lauta.aseta(sotilas7, koordinaatit);

        koordinaatit[0] = 4;
        koordinaatit[1] = 3;
        Sotilas sotilas8 = new Sotilas("valkoinen");
        lauta.aseta(sotilas8, koordinaatit);

        koordinaatit[0] = 5;
        koordinaatit[1] = 5;
        assertTrue(Liikkuminen.koitaSiirtya(ratsu, koordinaatit, lauta));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(Liikkuminen.koitaSiirtya(ratsu, koordinaatit, lauta));
        koordinaatit[0] = 1;
        koordinaatit[1] = 5;
        assertTrue(Liikkuminen.koitaSiirtya(ratsu, koordinaatit, lauta));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(Liikkuminen.koitaSiirtya(ratsu, koordinaatit, lauta));
        koordinaatit[0] = 2;
        koordinaatit[1] = 6;
        assertTrue(Liikkuminen.koitaSiirtya(ratsu, koordinaatit, lauta));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(Liikkuminen.koitaSiirtya(ratsu, koordinaatit, lauta));
        koordinaatit[0] = 2;
        koordinaatit[1] = 2;
        assertTrue(Liikkuminen.koitaSiirtya(ratsu, koordinaatit, lauta));
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        assertTrue(Liikkuminen.koitaSiirtya(ratsu, koordinaatit, lauta));

    }

    @Test
    public void eiVoiSyodaOmaa() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        int[] koordinaatit = {0, 0};
        koordinaatit[0] = 3;
        koordinaatit[1] = 4;
        Ratsu ratsu = new Ratsu("valkoinen");
        lauta.aseta(ratsu, koordinaatit);

        koordinaatit[0] = 5;
        koordinaatit[1] = 5;
        Sotilas sotilas1 = new Sotilas("valkoinen");
        lauta.aseta(sotilas1, koordinaatit);

        assertFalse(Liikkuminen.koitaSiirtya(ratsu, koordinaatit, lauta));
    }
}
