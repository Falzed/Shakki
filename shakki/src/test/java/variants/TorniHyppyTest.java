package variants;

import logic.*;
import fairy.*;
import org.junit.Test;
import org.junit.Assert;
import components.Nappula;
import java.io.*;
import java.util.Arrays;
import logic.parser.Parser;
import static org.junit.Assert.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

public class TorniHyppyTest {

    @Test
    public void komentoTest() throws FileNotFoundException, IOException, SAXException, ParserConfigurationException{
        File file = new File("src/main/resources/testXml.xml");
        Game peli = new Game(new FairyVariant(file));
        peli.suoritaKomento("a1-a3");
        peli.suoritaKomento("a8-a1");
        assertTrue(peli.getLauta().getNappula("a3").getNimi().equals("HyppaavaTorni"));
        assertTrue(peli.getLauta().getNappula("a3").getPuoli() == Nappula.Puoli.VALKOINEN);
        assertTrue(peli.getLauta().getNappula("a1").getNimi().equals("HyppaavaTorni"));
        assertTrue(peli.getLauta().getNappula("a1").getPuoli() == Nappula.Puoli.MUSTA);
    }

}
