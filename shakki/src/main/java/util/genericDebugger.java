package util;

import history.Turn;
import history.TurnHistory;


public class genericDebugger {
    public static void main(String[] args) {
        String vertaus = "1. d4 d5\n"
                + "2. c4 e5\n"
                + "3. xe5";
        TurnHistory historia = TurnHistory.parseString(vertaus);
        System.out.println(historia.getVuoroNumero());
        System.out.println(historia);
    }
}
