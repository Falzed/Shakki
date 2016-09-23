package components;

public class Nappula {
    public enum Puoli {

        VALKOINEN, MUSTA, TYHJA
    }
    private Puoli puoli;
    private int[] sijainti = {-1, -1};
    private Lauta lauta;

    public Nappula(String puoli, Lauta lauta) {
        if (puoli.equals("valkoinen")) {
            this.puoli = Puoli.VALKOINEN;
        } else if (puoli.equals("musta")) {
            this.puoli = Puoli.MUSTA;
        } else {
            System.out.println("Puoli ei kelpaa tai puuttuu");
        }
        this.lauta = lauta;
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
    public Lauta getLauta() {
        return this.lauta;
    }
    public boolean isEmpty() {
        return false;
    }
    public char getMerkki() {
        return 'a';
    }
    public boolean move(int[] koordinaatit) {
        return false;
    }
}
