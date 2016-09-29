package components;

public class Nappula {

    public enum Puoli {

        VALKOINEN, MUSTA, TYHJA
    }
    private Puoli puoli;
    private int[] sijainti = {-1, -1};

    public Nappula(String puoli, Lauta lauta) {
        if (puoli.equals("valkoinen")) {
            this.puoli = Puoli.VALKOINEN;
        } else if (puoli.equals("musta")) {
            this.puoli = Puoli.MUSTA;
        } else {
            System.out.println("Puoli ei kelpaa tai puuttuu");
        }
    }

    public Nappula() {
        puoli = Puoli.TYHJA;
    }

    public Puoli getPuoli() {
        return puoli;
    }

    public void asetaKoordinaatit(int[] koordinaatit) {
        this.sijainti[0] = koordinaatit[0];
        this.sijainti[1] = koordinaatit[1];
    }

    public int[] getKoordinaatit() {
        return this.sijainti;
    }

    public boolean isEmpty() {
        return false;
    }

    public char getMerkki() {
        return 'a';
    }

//    public boolean koitaSiirtya(int[] koordinaatit, Lauta lauta) {
//        return false;
//    }

//    public boolean siirry(int[] koordinaatit, Lauta lauta) {
//        if (lauta.getNappula(koordinaatit).isEmpty()) {
//            lauta.aseta(this, koordinaatit);
//        } else {
//            if (lauta.getNappula(koordinaatit).getPuoli() == getPuoli()) {
//                System.out.println("Et voi syödä omaa nappulaasi");
//                return false;
//            } else {
//                lauta.syo(this, koordinaatit);
//            }
//        }
//        return true;
//    }
}
