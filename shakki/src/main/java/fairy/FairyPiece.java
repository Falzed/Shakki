package fairy;

import java.util.ArrayList;
import components.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FairyPiece extends Nappula {

    private ArrayList<HashMap> stuff;
    private ArrayList<String> liikkumisTyypit;
    private char valkoinenMerkki;
    private char mustaMerkki;
    private char notaatioMerkki;
    private int[] koordinaatit;
    private String nimi;
    private Nappula.Puoli puoli;

    @Override
    public char getNotaatioMerkki() {
        return notaatioMerkki;
    }

    @Override
    public char getMerkki() {
        if (this.puoli == Puoli.VALKOINEN) {
            return valkoinenMerkki;
        }
        if (this.puoli == Puoli.MUSTA) {
            return mustaMerkki;
        }
        return super.getMerkki();
    }

    @Override
    public String getNimi() {
        return this.nimi;
    }

    @Override
    public Nappula.Puoli getPuoli() {
        return this.puoli;
    }

    @Override
    public String getPuoliString() {
        if (puoli == Puoli.VALKOINEN) {
            return "valkoinen";
        }
        if (puoli == Puoli.MUSTA) {
            return "musta";
        }
        return "tyhja";
    }

    public char getValkoinenMerkki() {
        return valkoinenMerkki;
    }

    public char getMustaMerkki() {
        return mustaMerkki;
    }

    public ArrayList<String> getLiikkumistyypit() {
        return this.liikkumisTyypit;
    }

    @Override
    public Nappula kopioi() {
        FairyPiece kopio = new FairyPiece(this, this.puoli);
//        kopio.asetaKoordinaatit(sijainti);
        return kopio;
    }

    public FairyPiece(char valkoinenMerkki, char mustaMerkki,
            char notaatioMerkki, String nimi,
            ArrayList<String> liikkumistyypit, Nappula.Puoli puoli) {
        this.valkoinenMerkki = valkoinenMerkki;
        this.mustaMerkki = mustaMerkki;
        this.notaatioMerkki = notaatioMerkki;
        this.liikkumisTyypit = liikkumistyypit;
        this.puoli = puoli;
    }

    public FairyPiece(HashMap<String, Object> hash, Nappula.Puoli puoli) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
        this.valkoinenMerkki = ((String) hash.get("valkoinenMerkki")).charAt(0);
        this.mustaMerkki = ((String) hash.get("mustaMerkki")).charAt(0);
        this.notaatioMerkki = ((String) hash.get("notaatioMerkki")).charAt(0);
        this.nimi = (String) hash.get("nimi");
        this.liikkumisTyypit = (ArrayList<String>) hash.get("liikkumiset");
        this.puoli = puoli;
    }

    public FairyPiece(String filepath, Nappula.Puoli puoli) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
        File file = new File(filepath);
        stuff = readXml(file);
        this.valkoinenMerkki = ((String) stuff.get(0).get("valkoinenMerkki")).charAt(0);
        this.mustaMerkki = ((String) stuff.get(0).get("mustaMerkki")).charAt(0);
        this.notaatioMerkki = ((String) stuff.get(0).get("notaatioMerkki")).charAt(0);
        this.nimi = (String) stuff.get(0).get("nimi");
        this.liikkumisTyypit = (ArrayList<String>) stuff.get(0).get("liikkumiset");
        this.puoli = puoli;
    }

    public FairyPiece(FairyPiece fairyPiece, Nappula.Puoli puoli) {
        this.valkoinenMerkki = fairyPiece.getValkoinenMerkki();
        this.mustaMerkki = fairyPiece.getMustaMerkki();
        this.notaatioMerkki = fairyPiece.getNotaatioMerkki();
        this.nimi = fairyPiece.getNimi();
        this.liikkumisTyypit = fairyPiece.getLiikkumistyypit();
        this.puoli = puoli;
    }

    public FairyPiece(FairyPiece fairyPiece, String puoli) {
        this.valkoinenMerkki = fairyPiece.getValkoinenMerkki();
        this.mustaMerkki = fairyPiece.getMustaMerkki();
        this.notaatioMerkki = fairyPiece.getNotaatioMerkki();
        this.nimi = fairyPiece.getNimi();
        this.liikkumisTyypit = fairyPiece.getLiikkumistyypit();
        if (puoli.equalsIgnoreCase("valkoinen")) {
            this.puoli = Nappula.Puoli.VALKOINEN;
        } else if (puoli.equalsIgnoreCase("musta")) {
            this.puoli = Nappula.Puoli.MUSTA;
        } else {
            this.puoli = Nappula.Puoli.TYHJA;
        }

    }

    public static void main(String[] args) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
        FairyPiece test = new FairyPiece("src/main/resources/testPiece.xml", Nappula.Puoli.VALKOINEN);
    }

    public ArrayList readXml(File file) throws ParserConfigurationException {
        ArrayList<HashMap> array = new ArrayList<>();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = dBuilder.parse(file);
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("nappula");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                HashMap<String, Object> hash = new HashMap<>();
                hash.put("nimi", element.getElementsByTagName("nimi").item(0).getTextContent());
                hash.put("notaatioMerkki", element.getElementsByTagName("notaatioMerkki").item(0).getTextContent());
                hash.put("valkoinenMerkki", element.getElementsByTagName("valkoinenMerkki").item(0).getTextContent());
                hash.put("mustaMerkki", element.getElementsByTagName("mustaMerkki").item(0).getTextContent());

                ArrayList<String> liikkumiset = new ArrayList<>();
                liikkumiset.add(element.getElementsByTagName("liikkumistyyppi").item(0).getTextContent());
                hash.put("liikkumiset", liikkumiset);
                array.add(hash);
            }
        }
        return array;
    }

    @Override
    public String toString() {
        String string = this.nimi;
        string += ", " + Character.toString(valkoinenMerkki);
        string += ", " + Character.toString(mustaMerkki);
        string += ", " + Character.toString(notaatioMerkki);
        for (String liikkumistyyppi : this.liikkumisTyypit) {
            string += ", " + liikkumistyyppi;
        }
        return string;
    }
}
