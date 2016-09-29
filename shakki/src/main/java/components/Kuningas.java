package components;

public class Kuningas extends Nappula {

    private static char valkoinenMerkki = '\u2654';
    private static char mustaMerkki = '\u265A';
    private static char notaatioMerkki = 'K';

    public Kuningas(String puoli, Lauta lauta) {
        super(puoli, lauta);
    }

    //TODO: Tornitus, ei voi liikkua uhattuun ruutuun
//    @Override
//    public boolean koitaSiirtya(int[] koordinaatit, Lauta lauta) {
//
//        //TODO: tarkista ettei ruutu uhattu
//        //if(getLauta().ruutuShakissa(koordinaatit)) { return false }
//        if (Math.abs(koordinaatit[0] - getKoordinaatit()[0]) > 1) {
//            return false;
//        }
//        if (Math.abs(koordinaatit[1] - getKoordinaatit()[1]) > 1) {
//            return false;
//        }
//        if (koordinaatit[1] - getKoordinaatit()[1] == 0
//                && koordinaatit[0] - getKoordinaatit()[0] == 0) {
//            return false;
//        }
//        return siirry(koordinaatit, lauta);
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
