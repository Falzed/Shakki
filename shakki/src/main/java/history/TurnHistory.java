package history;

import java.util.LinkedList;
import variants.*;

/**
 * Luokka toteuttaa laudan vuorohistorian.
 *
 * @author Oskari
 */
public class TurnHistory {

    private final LinkedList<Turn> history;

    /**
     * Luo vuorohistorian.
     */
    public TurnHistory() {
        this.history = new LinkedList<>();
    }
    /**
     * Luo vuorohistorian annetun merkkijonon perusteella.
     * @param string kuvaa tähänastiset vuorot, esim 1. d4 d5\n 2. c4 ... 
     */
    public TurnHistory(String string) {
        this.history = new LinkedList<Turn>();
        String[] strings = string.split(Character.toString('\n'));
        for (int i = 0; i < strings.length; i++) {
            Turn turn = new Turn(strings[i]);
            history.add(turn);
        }
    }

    /**
     * Lisää historiaan uuden vuoron.
     * @param turn lisättävä vuoro
     */
    public void addTurn(Turn turn) {
        this.history.add(turn);
    }

    public LinkedList<Turn> getList() {
        return this.history;
    }

    /**
     * Poistaa kaikki vuorot tietyn vuoron jälkeen. Ei tällä hetkellä käytetä
     * mihinkään.
     * @param vuoro viimeisen säilytettävän vuoron numero
     */
    public void removeAfter(int vuoro) {
        while (history.size() > vuoro) {
            history.remove(vuoro - 1);
        }
    }

    public Turn getViimeinenVuoro() {
        return history.getLast();
    }

    public int getVuoroNumero() {
        if (history.size() == 0) {
            return 1;
        }
        if (history.getLast().isComplete()) {
            return history.getLast().getTurnNumber() + 1;
        }
        return history.getLast().getTurnNumber();
    }

    

    @Override
    public String toString() {
        String string = "";
        for (Turn turn : history) {
            string = string.concat(turn.toString());
            if (turn.getTurnNumber() != history.getLast().getTurnNumber()) {
                string = string.concat("\n");
            }
        }
        return string;
    }
}
