package com.javalabra.shakki;

public class Torni implements Nappula {

    private enum Puoli {

        VALKOINEN, MUSTA
    }
    private Puoli puoli;
    private int[] sijainti = {-1,-1};
    private Lauta lauta;

    public Torni(String puoli, Lauta lauta) {
        if (puoli.equals("valkoinen")) {
            this.puoli = Puoli.VALKOINEN;
        } else if (puoli.equals("musta")) {
            this.puoli = Puoli.MUSTA;
        } else {
            System.out.println("Puoli ei kelpaa tai puuttuu");
        }
        this.lauta = lauta;
    }

    @Override
    public String getPuoli() {
        if (this.puoli == Puoli.VALKOINEN) {
            return "valkoinen";
        } else if (this.puoli == Puoli.MUSTA) {
            return "musta";
        } else {
            return "tuntematon";
        }
    }

    @Override
    public void asetaKoordinaatit(int[] koordinaatit) {
        this.sijainti[0] = koordinaatit[0];
        this.sijainti[1] = koordinaatit[1];
    }

    @Override
    public boolean move(int[] koordinaatit) {
        if (koordinaatit[0] != this.sijainti[0]
                && koordinaatit[1] != this.sijainti[1]) {
            return false;
        } else if (koordinaatit[0] == this.sijainti[0]
                && koordinaatit[1] == this.sijainti[1]) {
            return false;
        } else if (koordinaatit[0] < this.sijainti[0]) {
            int delta = this.sijainti[0] - koordinaatit[0];
            int[] testiKoordinaatit = {0,0};
            for (int i = 1; i < delta; i++) {
                testiKoordinaatit[0] = this.sijainti[0] - i;
                testiKoordinaatit[1] = this.sijainti[1];
                if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
                    return false;
                }
            }
            if (!lauta.getNappula(koordinaatit).isEmpty()) {
                if (lauta.getNappula(koordinaatit).getPuoli().equals(getPuoli())) {
                    return false;
                } else {
                    lauta.syo(this, koordinaatit);
                }
            } else {
                lauta.aseta(this, koordinaatit);
            }
        } else if (koordinaatit[0] > this.sijainti[0]) {
            int delta = koordinaatit[0] - this.sijainti[0];
            int[] testiKoordinaatit = {0,0};
            for (int i = 1; i < delta; i++) {
                testiKoordinaatit[0] = this.sijainti[0] + i;
                testiKoordinaatit[1] = this.sijainti[1];
                if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
                    return false;
                }
            }
            if (!lauta.getNappula(koordinaatit).isEmpty()) {
                if (lauta.getNappula(koordinaatit).getPuoli().equals(getPuoli())) {
                    return false;
                } else {
                    lauta.syo(this, koordinaatit);
                }
            } else {
                lauta.aseta(this, koordinaatit);
            }
        } else if (koordinaatit[1] < this.sijainti[1]) {
            int delta = this.sijainti[1] - koordinaatit[1];
            int[] testiKoordinaatit = {0,0};
            for (int i = 1; i < delta; i++) {
                testiKoordinaatit[1] = this.sijainti[1] - i;
                testiKoordinaatit[0] = this.sijainti[0];
                if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
                    return false;
                }
            }
            if (!lauta.getNappula(koordinaatit).isEmpty()) {
                if (lauta.getNappula(koordinaatit).getPuoli().equals(getPuoli())) {
                    return false;
                } else {
                    lauta.syo(this, koordinaatit);
                }
            } else {
                lauta.aseta(this, koordinaatit);
            }
        } else if (koordinaatit[1] > this.sijainti[1]) {
            int delta = koordinaatit[1] - this.sijainti[1];
            int[] testiKoordinaatit = {0,0};
            for (int i = 1; i < delta; i++) {
                testiKoordinaatit[1] = this.sijainti[1] + i;
                testiKoordinaatit[0] = this.sijainti[0];
                if (!lauta.getNappula(testiKoordinaatit).isEmpty()) {
                    return false;
                }
            }
            if (!lauta.getNappula(koordinaatit).isEmpty()) {
                if (lauta.getNappula(koordinaatit).getPuoli().equals(getPuoli())) {
                    return false;
                } else {
                    lauta.syo(this, koordinaatit);
                }
            } else {
                lauta.aseta(this, koordinaatit);
            }
        } 
        return true;
    }

    @Override
    public boolean captureMove(int[] koordinaatit) {
        return move(koordinaatit);
    }

    @Override
    public int[] getKoordinaatit() {
        return this.sijainti;
    }
}
