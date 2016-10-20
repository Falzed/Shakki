package fairy;

import components.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.util.HashMap;
import variants.Variant;

public class FairyVariant implements Variant {

    private ArrayList<Nappula> pieces;
    private Lauta lauta;
    private ArrayList<Lauta> laudat;
    private Nappula.Puoli aloittaja;
    private String[] nappuloittenNimet;
    private Nappula[] nappulaEsimerkit;
    private int lautojenMaara;
    private int lautojenLeveys;
    private int lautojenPituus;
    private ArrayList<Nappula> nappulat;
    private HashMap<Nappula, int[]> nappuloittenKoordinaatit;
    private ArrayList<HashMap> stuff;
    BufferedReader lukija;

    public FairyVariant(File file) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
        stuff = readXml(file);
        System.out.println(stuff);
        this.lautojenLeveys = Integer.parseInt((String) stuff.get(0).get("Leveys"));
        this.lautojenPituus = Integer.parseInt((String) stuff.get(0).get("Pituus"));

        ArrayList<Nappula> esimerkit = parseEsimerkit(stuff);
        ArrayList<String> nimet = parseNimet(stuff);

        this.nappuloittenNimet = new String[nimet.size()];
        for (int i = 0; i < nimet.size(); i++) {
            this.nappuloittenNimet[i] = nimet.get(i);
        }
        this.nappulaEsimerkit = new Nappula[nimet.size()];
        for (int i = 0; i < nimet.size(); i++) {
            this.nappulaEsimerkit[i] = esimerkit.get(i);
        }
        asetaNappulat(esimerkit);
    }
    
    public void asetaNappulat(ArrayList<Nappula> esimerkit) {
        this.nappuloittenKoordinaatit = new HashMap<>();
        for (HashMap hash : stuff) {
            if (((String) hash.get("nappulanNimi")) != null) {
                int[] koordinaatit = new int[2];
                koordinaatit[0] = Integer.parseInt((String) hash.get("xkoord"));
                koordinaatit[1] = Integer.parseInt((String) hash.get("ykoord"));
                int index = -1;

                for (Nappula nappula : esimerkit) {
                    if (nappula.getNimi().equals(((String) hash.get("nappulanNimi")))) {
                        index = esimerkit.indexOf(nappula);
                        break;
                    }
                }
                if (index > -1) {
                    if (esimerkit.get(index) instanceof FairyPiece) {
                        FairyPiece nappula = new FairyPiece((FairyPiece) esimerkit.get(index), (String) hash.get("nappulanPuoli"));
                        System.out.println(nappula.getNimi());
                        System.out.println(nappula.getPuoli());
                        this.nappuloittenKoordinaatit.put(nappula, koordinaatit);
                    } else {
                        System.out.println(esimerkit.get(index).getNimi());
                        System.out.println(esimerkit.get(index).getPuoli());
                        this.nappuloittenKoordinaatit.put(esimerkit.get(index), koordinaatit);
                    }
                }
            }
        }
        System.out.println(nappuloittenKoordinaatit);
    }

    public ArrayList<Nappula> parseEsimerkit(ArrayList<HashMap> stuff) {
        ArrayList<Nappula> esimerkit = new ArrayList<>();
        for (HashMap hash : stuff) {
            if (((Nappula) hash.get("nappula")) != null) {
//                nimet.add((String) hash.get("Nimi"));
                if (hash.get("nappula") instanceof FairyPiece) {
                    FairyPiece nappula = (FairyPiece) hash.get("nappula");
                    esimerkit.add(nappula);
                    esimerkit.add(new FairyPiece(nappula, Nappula.Puoli.MUSTA));
                } else {
                    Nappula nappula = (Nappula) hash.get("nappula");
                    esimerkit.add(nappula);
                    esimerkit.add(new Nappula(nappula, "musta"));
                }
            }
        }
        return esimerkit;
    }

    public ArrayList<String> parseNimet(ArrayList<HashMap> stuff) {
        ArrayList<String> nimet = new ArrayList<>();
        for (HashMap hash : stuff) {
            if (((Nappula) hash.get("nappula")) != null) {
//                nimet.add((String) hash.get("Nimi"));
                if (hash.get("nappula") instanceof FairyPiece) {
                    FairyPiece nappula = (FairyPiece) hash.get("nappula");
                    nimet.add(nappula.getNimi());
                } else {
                    Nappula nappula = (Nappula) hash.get("nappula");
                    nimet.add(nappula.getNimi());
                }
            }
        }
        return nimet;
    }

    @Override
    public Nappula[] getNappulaEsimerkit() {
        return this.nappulaEsimerkit;
    }

    @Override
    public Lauta getLauta() {
        return this.lauta;
    }

    @Override
    public String[] getNappuloittenNimet() {
        return this.nappuloittenNimet;
    }

    @Override
    public void setUp() {
        lauta = new Lauta(this.lautojenLeveys, this.lautojenPituus);
        lauta.alustaLauta();
//        System.out.println(this.nappuloittenKoordinaatit.keySet());
        for (Nappula nappula : this.nappuloittenKoordinaatit.keySet()) {
//            System.out.println(nappula.getNimi());
//            System.out.println(nappula.getPuoli());
//            System.out.println(Arrays.toString(nappuloittenKoordinaatit.get(nappula)));
            System.out.println("Nappula: " + nappula.getPuoli() + " " + nappula.getNimi());
            System.out.println(Arrays.toString(nappuloittenKoordinaatit.get(nappula)));
            logic.LaudanMuutokset.aseta(nappula, nappuloittenKoordinaatit.get(nappula), lauta);
//            System.out.println(lauta.getNappula(nappuloittenKoordinaatit.get(nappula)).getNimi());
//            System.out.println(lauta.getNappula(nappuloittenKoordinaatit.get(nappula)).getPuoli());
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
        FairyVariant variant = new FairyVariant(new File("src/main/resources/testXml.xml"));
    }

    public ArrayList readXml(File file) throws ParserConfigurationException, FileNotFoundException, IOException, SAXException {
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
        NodeList nList = doc.getElementsByTagName("lauta");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                HashMap<String, String> hash = new HashMap<>();
                hash.put("Leveys", element.getElementsByTagName("leveys").item(0).getTextContent());
                hash.put("Pituus", element.getElementsByTagName("pituus").item(0).getTextContent());
                array.add(hash);
            }
        }
        nList = doc.getElementsByTagName("nappula");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                HashMap<String, Object> hash = new HashMap<>();
                switch (element.getElementsByTagName("nimi").item(0).getTextContent()) {
                    case "Sotilas":
                        hash.put("nappula", new Sotilas("valkoinen"));
                        array.add(hash);
                        break;
                    case "Kuningas":
                        hash.put("nappula", new Kuningas("valkoinen"));
                        array.add(hash);
                        break;
                    case "Kuningatar":
                        hash.put("nappula", new Kuningatar("valkoinen"));
                        array.add(hash);
                        break;
                    case "Ratsu":
                        hash.put("nappula", new Ratsu("valkoinen"));
                        array.add(hash);
                        break;
                    case "Torni":
                        hash.put("nappula", new Torni("valkoinen"));
                        array.add(hash);
                        break;
                    case "Lahetti":
                        hash.put("nappula", new Lahetti("valkoinen"));
                        array.add(hash);
                        break;
                    default:
                        hash.put("nimi", element.getElementsByTagName("nimi").item(0).getTextContent());
                        hash.put("notaatioMerkki", element.getElementsByTagName("notaatioMerkki").item(0).getTextContent());
                        hash.put("valkoinenMerkki", element.getElementsByTagName("valkoinenMerkki").item(0).getTextContent());
                        hash.put("mustaMerkki", element.getElementsByTagName("mustaMerkki").item(0).getTextContent());
//                        System.out.println("valkoinenMerkki: " + element.getElementsByTagName("valkoinenMerkki").item(0).getTextContent());
                        ArrayList<String> liikkumiset = new ArrayList<>();
                        liikkumiset.add(element.getElementsByTagName("liikkumistyyppi").item(0).getTextContent());
                        hash.put("liikkumiset", liikkumiset);
                        FairyPiece piece = new FairyPiece(hash, Nappula.Puoli.VALKOINEN);
//                        System.out.println(piece.getPuoli());
//                        System.out.println(piece.getMerkki());
                        hash = new HashMap<>();
                        hash.put("nappula", piece);
                        array.add(hash);
                        break;
                }

            }
        }
        nList = doc.getElementsByTagName("nappulanPaikka");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                HashMap<String, Object> hash = new HashMap<>();
                hash.put("nappulanNimi", element.getElementsByTagName("nappulanNimi").item(0).getTextContent());
                hash.put("nappulanPuoli", element.getElementsByTagName("nappulanPuoli").item(0).getTextContent());
                hash.put("xkoord", element.getElementsByTagName("xkoord").item(0).getTextContent());
                hash.put("ykoord", element.getElementsByTagName("ykoord").item(0).getTextContent());
                array.add(hash);
            }
        }
        return array;
    }
}