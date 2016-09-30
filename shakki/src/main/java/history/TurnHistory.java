package history;

import java.util.LinkedList;
import variants.*;

public class TurnHistory {

    private final LinkedList<Turn> history;
    private final Variant variant;

    public TurnHistory(Variant variant) {
        this.history = new LinkedList<>();
        this.variant = variant;
    }

    public TurnHistory() {
        this.history = new LinkedList<>();
        this.variant = new variants.Standard();
    }

    public void addTurn(Turn turn) {
        this.history.add(turn);
    }

    public LinkedList<Turn> getList() {
        return this.history;
    }

    public void removeAfter(int vuoro) {
        while (history.size() > vuoro) {
            history.remove(vuoro - 1);
        }
    }

    public Turn getViimeinenVuoro() {
        return history.getLast();
    }

    public int getVuoroNumero() {
        if(history.size()==0) {
            return 1;
        }
        if (history.getLast().isComplete()) {
            return history.getLast().getTurnNumber() + 1;
        }
        return history.getLast().getTurnNumber();
    }
    
    public static TurnHistory parseString(String string) {
        TurnHistory retHistory = new TurnHistory();
        String[] strings = string.split(Character.toString('\n'));
        for(int i=0; i<strings.length; i++) {
            Turn turn = new Turn(strings[i]);
            retHistory.addTurn(turn);
        }
        return retHistory;
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
