package util;

import java.util.Scanner;
import components.*;

public class parseDebugger {

    public static void main(String[] args) {
        String line;
        Scanner lukija = new Scanner(System.in);
        Lauta lauta = new Lauta();
        lauta.alustaLauta();
        variants.Standard.setUp(lauta);
        Nappula.Puoli vuoro = Nappula.Puoli.VALKOINEN;
        while (true) {
            line = lukija.nextLine();
            if (line.isEmpty()) {
                break;
            }
            if (line.equals("musta")) {
                vuoro = Nappula.Puoli.MUSTA;
            }
            if (line.equals("valkoinen")) {
                vuoro = Nappula.Puoli.VALKOINEN;
            }
            int[][] table = lauta.parseCommand(line, vuoro);
            if (table == null) {
                System.out.println("table null");
            } else {
                System.out.println(table[0][0] + "," + table[0][1] + "-" + table[1][0] + "," + table[1][0]);
            }
        }
    }
}
