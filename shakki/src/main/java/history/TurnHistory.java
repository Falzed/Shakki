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

    @Override
    public String toString() {
        String string = "";
        for (Turn turn : history) {
            string.concat(turn.toString());
        }
        return string;
    }
}
