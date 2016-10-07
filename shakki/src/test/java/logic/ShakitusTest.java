package logic;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import components.*;

public class ShakitusTest {

    @Test
    public void tunnistaaShakin() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        lauta.aseta(new Kuningas("valkoinen"), "e1");
        assertFalse(Shakitus.uhattu(lauta, "e1", Nappula.Puoli.VALKOINEN));
        lauta.aseta(new Torni("musta"), "a1");
        assertTrue(Shakitus.uhattu(lauta, "e1", Nappula.Puoli.VALKOINEN));
    }

    @Test
    public void tunnistaaMatin() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        lauta.aseta(new Kuningas("valkoinen"), "e1");
        lauta.aseta(new Torni("musta"), "a1");
        assertFalse(Shakitus.matissa(lauta, "valkoinen", null));
        lauta.aseta(new Torni("musta"), "a2");
        assertTrue(Shakitus.matissa(lauta, "valkoinen", null));
    }

}
