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
        logic.LaudanMuutokset.aseta(new Kuningas("valkoinen"), "e1", lauta);
        assertFalse(Shakitus.uhattu(lauta, "e1", Nappula.Puoli.VALKOINEN));
        logic.LaudanMuutokset.aseta(new Torni("musta"), "a1", lauta);
        assertTrue(Shakitus.uhattu(lauta, "e1", Nappula.Puoli.VALKOINEN));
    }
    
    @Test
    public void tunnistaaEtteiShakissa() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        logic.LaudanMuutokset.aseta(new Kuningas("valkoinen"), "e2", lauta);
        assertFalse(Shakitus.uhattu(lauta, "e1", Nappula.Puoli.VALKOINEN));
        logic.LaudanMuutokset.aseta(new Torni("musta"), "a1", lauta);
        assertFalse(Shakitus.uhattu(lauta, "e2", Nappula.Puoli.VALKOINEN));
    }

    @Test
    public void tunnistaaMatin() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        logic.LaudanMuutokset.aseta(new Kuningas("valkoinen"), "e1", lauta);
        logic.LaudanMuutokset.aseta(new Torni("musta"), "a1", lauta);
        assertFalse(Shakitus.matissa(lauta, "valkoinen", null));
        logic.LaudanMuutokset.aseta(new Torni("musta"), "a2", lauta);
        assertTrue(Shakitus.matissa(lauta, "valkoinen", null));
    }
    
    @Test
    public void tunnistaaMatinMusta() {
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        logic.LaudanMuutokset.aseta(new Kuningas("musta"), "e1", lauta);
        logic.LaudanMuutokset.aseta(new Torni("valkoinen"), "a1", lauta);
        assertFalse(Shakitus.matissa(lauta, "musta", null));
        logic.LaudanMuutokset.aseta(new Torni("valkoinen"), "a2", lauta);
        assertTrue(Shakitus.matissa(lauta, "musta", null));
    }

}
