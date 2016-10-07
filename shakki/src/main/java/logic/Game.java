package logic;

import components.Lauta;
import components.Nappula;
import ui.*;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import history.*;
import variants.*;

/**
 * Luokka toteuttaa shakkipelin.
 *
 * @author oemkulma
 */
public class Game {

    private Variant variant;
    private Lauta lauta;
    private TurnHistory historia;
    private Nappula.Puoli vuoro;
    private int[] enPassant;

    /**
     * Konstruktori pelille.
     */
    public Game() {
        this.variant = new Standard();
        variant.setUp();
        this.lauta = variant.getLauta();
        this.historia = new TurnHistory();
        this.vuoro = variant.getAloittaja();
        this.enPassant = null;
    }

    /**
     * Metodi koittaa suorittaa käyttäjän antaman komennon.
     *
     * @param komento käyttäjän syöttämä komento.
     * @return onnistuiko komennon suoritus.
     *
     */
    public boolean suoritaKomento(String komento) {
        int[][] startEndPoints = Parser.parseCommand(komento, vuoro, lauta);
        int[] enPassantTemp = new int[2];
        if (startEndPoints != null) {
            //kirjoita järkevämmäksi myöhemmin
            if (lauta.getNappula(startEndPoints[0]).onSotilas()
                    && Math.abs(startEndPoints[0][1] - startEndPoints[1][1])
                    == 2) {
                enPassantTemp[0] = startEndPoints[0][0];
                if (vuoro == Nappula.Puoli.VALKOINEN) {
                    enPassantTemp[1] = startEndPoints[0][1] + 1;
                } else {
                    enPassantTemp[1] = startEndPoints[0][1] - 1;
                }
            }
            if (!(startEndPoints[0][0] < lauta.getLeveys() && startEndPoints[0][0] > -1 && startEndPoints[0][1] < lauta.getPituus() && startEndPoints[0][1] > -1)) {
                System.out.println("ruutu "
                        + "(koordinaatit {" + startEndPoints[0][0] + ","
                        + startEndPoints[0][1] + "})" + " ei laudalla");
                return false;
            }
            Nappula nappula = lauta.getNappula(startEndPoints[0]);
            if (nappula.getPuoli() != vuoro) {
                System.out.println("Ruudussa ei nappulaasi");
                return false;
            }
            if (Liikkuminen.koitaSiirtyaTarkistaShakki(nappula, startEndPoints[1], lauta, vuoro, enPassant)) {
                if (vuoro == Nappula.Puoli.VALKOINEN) {
                    vuoro = Nappula.Puoli.MUSTA;
                } else {
                    vuoro = Nappula.Puoli.VALKOINEN;
                }
                if (!historia.getList().isEmpty()) {
                    jatkaVuoroHistoriaa(komento);
                } else {
                    historia.addTurn(new Turn(historia.getVuoroNumero(), komento, ""));
                }
            } else {
                System.out.print("(" + startEndPoints[0][0] + "," + startEndPoints[0][1] + ")");
                System.out.println("-(" + startEndPoints[1][0] + "," + startEndPoints[1][1] + ")");
                System.out.println("Laiton siirto");
                return false;
            }
            if (enPassantTemp != null) {
                this.enPassant = enPassantTemp;
            } else {
                this.enPassant = null;
            }
            return true;
        }
        System.out.println("Parser palautti nullin");
        return false;
    }

    private void jatkaVuoroHistoriaa(String komento) {
        if (historia.getViimeinenVuoro().isComplete()) {
            historia.addTurn(new Turn(historia.getVuoroNumero(), komento, ""));
        } else {
            if (historia.getViimeinenVuoro().getWhiteMove().isEmpty()) {
                historia.getViimeinenVuoro().setWhiteMove(komento);
            } else if (historia.getViimeinenVuoro().getBlackMove().isEmpty()) {
                historia.getViimeinenVuoro().setBlackMove(komento);
            }
        }
    }

    /**
     * getteri.
     * @return lauta
     */
    public Lauta getLauta() {
        return lauta;
    }

    /**
     * getteri.
     * @return historia
     */
    public TurnHistory getTurnHistory() {
        return historia;
    }

    /**
     * getteri.
     * @return vuoro
     */
    public Nappula.Puoli getVuoro() {
        return vuoro;
    }

    /**
     * Pääohjelma.
     *
     * @param args eivät tee mitään
     */
    public static void main(String[] args) {
        Game peli = new Game();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UI ui = new UI(peli);
                ui.setVisible(true);
                ui.updateUI();
            }
        });
        Nappula.Puoli vuoro = Nappula.Puoli.VALKOINEN;

    }

    /**
     * Metodi muuttaa pelin vuorohistorian käyttäjän syöttämäksi. Ei tällä
     * hetkellä käytössä.
     *
     * @param string muotoa 1. d4 d5\n2. c4 e5 3. xe5 oleva merkkijono joka
     * kuvaa pelaajien siirtoja.
     */
    public static void setHistory(String string) {
        TurnHistory historia = new TurnHistory(string);

    }
}
