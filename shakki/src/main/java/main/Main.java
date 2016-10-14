package main;

import components.Nappula;
import logic.Game;
import ui.UI;

public class Main {

    /**
     * Pääohjelma.
     *
     * @param args eivät tee mitään
     */
    public static void main(String[] args) {
        Game peli = new Game();
        UI ui = new UI(peli);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ui.setVisible(true);
                ui.updateUI();
            }
        });
        Nappula.Puoli vuoro = Nappula.Puoli.VALKOINEN;

    }
}
