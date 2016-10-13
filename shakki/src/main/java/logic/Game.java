package logic;

import logic.liikkuminen.Liikkuminen;
import logic.Parser.Parser;
import components.Lauta;
import components.Nappula;
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
    private ui.UINotUnreadable ui;

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
        this.ui = new ui.UINotUnreadable(this);
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
                    historia.jatkaVuoroHistoriaa(komento);
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
            tarkistaKorotus(startEndPoints);
            return true;
        }
        System.out.println("Parser palautti nullin");
        return false;
    }

    private void tarkistaKorotus(int[][] startEndPoints) {
        if (startEndPoints[1][1] == 0
                || startEndPoints[1][0] == lauta.getPituus() - 1) {
            int[] koord = {startEndPoints[1][1], startEndPoints[1][1]};
            if (lauta.getNappula(koord).onSotilas()) {
                String korotetaanNimi = ui.popupKorotus();
                for (Nappula korotuskandidaatti : variant.getNappulaEsimerkit()) {
                    //vuoro jo vaihdettu seuraavaan
                    if (korotuskandidaatti.getNimi().equals(korotetaanNimi) && korotuskandidaatti.getPuoli() != vuoro) {
                        LaudanMuutokset.korvaa(korotuskandidaatti.kopioi(), koord, lauta);
                    }
                }
            }
        }
    }

    /**
     * getteri.
     *
     * @return lauta
     */
    public Lauta getLauta() {
        return lauta;
    }

    /**
     * getteri.
     *
     * @return historia
     */
    public TurnHistory getTurnHistory() {
        return historia;
    }

    /**
     * getteri.
     *
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
                peli.ui.setVisible(true);
                peli.ui.updateUI();
            }
        });
        Nappula.Puoli vuoro = Nappula.Puoli.VALKOINEN;

    }

    /**
     * Poistaa vuorohistorian.
     */
    public void clearHistory() {
        this.historia.removeAfter(0);
    }

    /**
     * (Yrittää) suorittaa annetun vuorohistorian.
     *
     * @param history vuorohistoria TurnHistoryna
     */
    public void applyHistory(TurnHistory history) {
        variant.setUp();
        lauta = variant.getLauta();
        vuoro = variant.getAloittaja();
        System.out.println("history: " + history);
        String komento = "";
        for (Turn turn : history.getList()) {
            komento = turn.getWhiteMove();
            suoritaKomento(komento);
            komento = turn.getBlackMove();
            suoritaKomento(komento);
        }
    }

    /**
     * (Yrittää) suorittaa annetun vuorohistorian.
     *
     * @param string merkkijonona
     */
    public void applyHistory(String string) {
        TurnHistory history = new TurnHistory(string);
        applyHistory(history);
    }
}
