package components;

public class Ratsu extends Nappula {

    public static char valkoinenMerkki = '\u2658';
    public static char mustaMerkki = '\u265E';

    public Ratsu(String puoli, Lauta lauta) {
        super(puoli, lauta);
    }

    @Override
    public void asetaKoordinaatit(int[] koordinaatit) {
        getKoordinaatit()[0] = koordinaatit[0];
        getKoordinaatit()[1] = koordinaatit[1];
    }
 
//   @Override
//    public boolean koitaSiirtya(int[] koordinaatit, Lauta lauta) {
//        if (!oneTwo(koordinaatit)) {
//            return false;
//        }
//        return siirry(koordinaatit, lauta);
//    }
//    private boolean onkoTyhja(int[] koordinaatit, Lauta lauta) {
//        if (!lauta.getNappula(koordinaatit).isEmpty()) {
//            if (lauta.getNappula(koordinaatit).getPuoli().equals(getPuoli())) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean oneTwo(int[] koordinaatit) {
//        if (Math.abs(koordinaatit[0] - getKoordinaatit()[0]) == 1) {
//            if (Math.abs(koordinaatit[1] - getKoordinaatit()[1]) == 2) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        if (Math.abs(koordinaatit[0] - getKoordinaatit()[0]) == 2) {
//            if (Math.abs(koordinaatit[1] - getKoordinaatit()[1]) == 1) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        return false;
//    }
//
//    public boolean captureMove(int[] koordinaatit, Lauta lauta) {
//        return koitaSiirtya(koordinaatit, lauta);
//    }

    @Override
    public char getMerkki() {
        if (getPuoli().equals(Puoli.VALKOINEN)) {
            return valkoinenMerkki;
        }
        if (getPuoli().equals(Puoli.MUSTA)) {
            return mustaMerkki;
        }
        return super.getMerkki();
    }
}
