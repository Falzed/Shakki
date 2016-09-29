package components;

public class Sotilas extends Nappula {

    public static char valkoinenMerkki = '\u2659';
    public static char mustaMerkki = '\u265F';

    public Sotilas(String puoli, Lauta lauta) {
        super(puoli, lauta);
    }

    //TODO: En passant, korotus
//    @Override
//    public boolean koitaSiirtya(int[] koordinaatit, Lauta lauta) {
//        if (captureMove(koordinaatit, lauta)) {
//            return true;
//        }
//        if (koordinaatit[0] != getKoordinaatit()[0]) {
//            return false;
//        } else if (koordinaatit[0] == getKoordinaatit()[0]
//                && koordinaatit[1] == getKoordinaatit()[1]) {
//            return false;
//        } else if (getPuoli() == Puoli.VALKOINEN) {
//            if (koordinaatit[1] > getKoordinaatit()[1] + 2) {
//                return false;
//            }
//            if (koordinaatit[1] < getKoordinaatit()[1] + 1) {
//                return false;
//            }
//            if (koordinaatit[1] == getKoordinaatit()[1] + 1
//                    && lauta.getNappula(koordinaatit).isEmpty()) {
//                return true;
//            }
//            int[] valissa = {getKoordinaatit()[0], getKoordinaatit()[1] + 1};
//            if (!lauta.getNappula(valissa).isEmpty()) {
//                return false;
//            }
//        } else if (getPuoli() == Puoli.MUSTA) {
//            if (koordinaatit[1] != getKoordinaatit()[1] - 1) {
//                if (getKoordinaatit()[1] != 6) {
//                    return false;
//                }
//                if (koordinaatit[1] != getKoordinaatit()[1] - 2) {
//                    return false;
//                }
//                int[] valissa = {getKoordinaatit()[0], getKoordinaatit()[1] - 1};
//                if (!lauta.getNappula(valissa).isEmpty()) {
//                    return false;
//                }
//            }
//        } else if (!lauta.getNappula(koordinaatit).isEmpty()) {
//            return false;
//        }
//        return siirry(koordinaatit, lauta);
//    }
//
//    public boolean captureMove(int[] koordinaatit, Lauta lauta) {
//        if(lauta.getNappula(koordinaatit).getPuoli()==getPuoli()) {
//            return false;
//        }
//        if (koordinaatit[0] != getKoordinaatit()[0] + 1
//                && koordinaatit[0] != getKoordinaatit()[0] - 1) {
//            return false;
//        } else if (getPuoli() == Puoli.VALKOINEN) {
//            if (koordinaatit[1] != getKoordinaatit()[1] + 1) {
//                return false;
//            }
//        } else if (getPuoli() == Puoli.MUSTA) {
//            if (koordinaatit[1] != getKoordinaatit()[1] - 1) {
//                return false;
//            }
//        } else if (lauta.getNappula(koordinaatit).isEmpty()) {
//            return false;
//        } else if (lauta.getNappula(koordinaatit).getPuoli().equals(getPuoli())) {
//            return false;
//        }
//        return siirry(koordinaatit, lauta);
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
