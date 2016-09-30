package history;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class historyTest {

    @Test
    public void toStringTest() {
        TurnHistory historia = new TurnHistory();
        Turn turn = new Turn(1, "d4", "d5");
        historia.addTurn(turn);
        turn = new Turn(2, "c4", "e5");
        historia.addTurn(turn);
        turn = new Turn(3, "xe5");
        historia.addTurn(turn);
        String vertaus = "1. d4 d5\n"
                + "2. c4 e5\n"
                + "3. xe5";
        for (int i = 0; i < vertaus.length(); i++) {
            assertEquals(vertaus.charAt(i), historia.toString().charAt(i));
        }
        assertEquals(vertaus.length(), historia.toString().length());
        assertEquals(historia.toString(), vertaus);
    }
    @Test
    public void parseStringTest() {
        String vertaus = "1. d4 d5\n"
                + "2. c4 e5\n"
                + "3. xe5";
        TurnHistory historia = TurnHistory.parseString(vertaus);
        
        for (int i = 0; i < vertaus.length(); i++) {
            assertEquals(vertaus.charAt(i), historia.toString().charAt(i));
        }
        assertEquals(vertaus.length(), historia.toString().length());
        assertEquals(historia.toString(), vertaus);
    }
}
