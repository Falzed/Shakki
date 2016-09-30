package history;
import java.util.LinkedList;
import variants.*;

public class TurnHistory {
    private LinkedList<Turn> history;
    private Variant variant;
    public TurnHistory(Variant variant) {
        this.history = new LinkedList<Turn>();
        this.variant = variant;
    }
    public TurnHistory() {
        this.history = new LinkedList<Turn>();
        this.variant = new variants.Standard();
    }
    public void addTurn(Turn turn) {
        this.history.add(turn);
    }
    public LinkedList<Turn> getList() {
        return this.history;
    }
}
