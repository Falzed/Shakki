package history;


public class Turn {
    private int turnNumber;
    private String whiteMove;
    private String blackMove;
    public Turn(int turnNumber) {
        this.turnNumber = turnNumber;
    }
    public Turn(int turnNumber, String whiteMove, String blackMove) {
        this.turnNumber = turnNumber;
        this.whiteMove = whiteMove;
        this.blackMove = blackMove;
    }
    public Turn(String notation) {
        this.turnNumber = Integer.parseInt(Character.toString(notation.charAt(0)));
        String temp="";
        for(int i= 2; i<notation.length(); i++) {
            if(notation.charAt(i)!=' ') {
                temp.concat(Character.toString(notation.charAt(i)));
            } else if(!temp.isEmpty() && this.whiteMove.isEmpty()) {
                this.whiteMove = temp;
                temp = "";
            } else if(!temp.isEmpty() && !this.whiteMove.isEmpty()) {
                this.blackMove = temp;
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
    @Override
    public String toString() {
        return Integer.toString(turnNumber)+". "+whiteMove+" "+blackMove;
    }
}
