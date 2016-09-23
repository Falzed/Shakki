package components;


public class Tyhja extends Nappula {

    public Tyhja() {
        super();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }


    @Override
    public void asetaKoordinaatit(int[] koordinaatit) {
        throw new UnsupportedOperationException("Tyhjän ruudun ei tarvitse tietää koordinaattejaan"); 
    }

    @Override
    public int[] getKoordinaatit() {
        throw new UnsupportedOperationException("Tyhjän ruudun ei tarvitse tietää koordinaattejaan");
    }
}
