package logic;

import java.util.regex.Pattern;

public class Parser {
    public static int[] parseAlgebraicCoordinates(String string) {
        int[] koordinaatit = new int[2];
        koordinaatit[0]= string.charAt(0)-97;
        koordinaatit[1]=string.charAt(1)-49;
        return koordinaatit;
    }
    public static int[] parseCommand(String string) {
        Pattern pattern = Pattern.compile("[a-z][1-8]-[a-z][1-8]");
        if(pattern.matcher(string).matches()) {
            return parseAlgebraicCoordinates(string);
        }
        Pattern sotilas = Pattern.compile("[a-z][1-8]");
        if(sotilas.matcher(string).matches()) {
            
        }
        return null;
    }
}
