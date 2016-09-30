package history;

/**
 * Luokka toteuttaa yhden shakkivuoron (molempien pelaajien siirrot).
 * @author Oskari
 */
public class Turn {

    private int turnNumber;
    private String whiteMove = "";
    private String blackMove = "";

    public Turn(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public Turn(int turnNumber, String whiteMove, String blackMove) {
        this.turnNumber = turnNumber;
        this.whiteMove = whiteMove;
        this.blackMove = blackMove;
    }

    public Turn(int turnNumber, String string) {
        this(Integer.toString(turnNumber).concat(" ").concat(string));
        
//        this.turnNumber = turnNumber;
//        String temp = "";
//        for(int i=0; i<string.length(); i++) {
//            if(string.charAt(i)==' ') {
//                if(whiteMove.isEmpty()) {
//                    whiteMove = temp;
//                    temp = "";
//                } else if(blackMove.isEmpty()) {
//                    blackMove = temp;
//                    temp = "";
//                } else {
//                    break;
//                }
//            }
//            temp = temp.concat(Character.toString(string.charAt(i)));
//        }
//        if(!temp.isEmpty()) {
//            if(whiteMove.isEmpty()) {
//                    whiteMove = temp;
//                } else if(blackMove.isEmpty()) {
//                    blackMove = temp;
//                }
//        }
    }

    public Turn(String notation) {
        this.turnNumber = Integer.parseInt(Character.toString(notation.charAt(0)));
        String temp = "";
        for (int i = 2; i < notation.length(); i++) {
            if (notation.charAt(i) != ' ') {
                temp = temp.concat(Character.toString(notation.charAt(i)));
            } else if (!temp.isEmpty() && this.whiteMove.isEmpty()) {
                this.whiteMove = temp;
                temp = "";
            } else if (!temp.isEmpty() && !this.whiteMove.isEmpty()) {
                this.blackMove = temp;
            }
        }
        if (!temp.isEmpty()) {
            if (whiteMove.isEmpty()) {
                whiteMove = temp;
            } else if (blackMove.isEmpty()) {
                blackMove = temp;
            }
        }
    }

    public int getTurnNumber() {
        return this.turnNumber;
    }

    public String getWhiteMove() {
        return this.whiteMove;
    }

    public String getBlackMove() {
        return this.blackMove;
    }

    public void setWhiteMove(String string) {
        whiteMove = string;
    }

    public void setBlackMove(String string) {
        blackMove = string;
    }

    public boolean isComplete() {
        if (whiteMove.equals("")) {
            return false;
        }
        if (blackMove.equals("")) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String string = "";
        string = string.concat(Integer.toString(turnNumber));
        if (!whiteMove.isEmpty()) {
            string = string.concat(". " + whiteMove);
            if (!blackMove.isEmpty()) {
                string = string.concat(" " + blackMove);
            }
        }
        return string;
    }
    
    public static Turn parseString(String string) {
//        String temp = "";
//        for(int i=1; i<string.length(); i++) {
//            if(string.charAt(i)=='.' || string.charAt(i)==' ') {
//                continue;
//            }
//            if(string.charAt(i)=='\n') {
//                break;
//            }
//            temp = temp.concat(Character.toString(string.charAt(i)));
//        }
//        Turn ret = new Turn(Integer.parseInt(Character.toString(string.charAt(0))), temp);
//        return ret;
        return new Turn(string);
    }
}
