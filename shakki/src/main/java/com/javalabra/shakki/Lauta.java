/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javalabra.shakki;

/**
 *
 * @author Oskari
 */
public class Lauta {

    private int leveys = 8;
    private int pituus = 8;
    private Nappula[][] nappulat = new Nappula[leveys][pituus];

    public Nappula getNappula(int[] koordinaatit) {
        return nappulat[koordinaatit[0]][koordinaatit[1]];
    }

    public void alustaLauta() {
        int[] koordinaatit = {0, 0};
        Tyhja tyhja = new Tyhja();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                nappulat[i][j] = tyhja;
            }
        }
    }

    public boolean aseta(Nappula nappula, int[] koordinaatit) {
        if (nappulat[koordinaatit[0]][koordinaatit[1]].isEmpty()) {
            nappulat[koordinaatit[0]][koordinaatit[1]] = nappula;
            if (!nappula.isEmpty()) {
                int[] vanhaSijainti = nappula.getKoordinaatit();
                if (vanhaSijainti[0] != -1) {
                    nappulat[vanhaSijainti[0]][vanhaSijainti[1]] = new Tyhja();
                }
                nappula.asetaKoordinaatit(koordinaatit);
            }
        } else {
            System.out.println("Ruudussa on jo nappula");
            return false;
        }
        return true;
    }

    public boolean syo(Nappula nappula, int[] koordinaatit) {
        if (nappulat[koordinaatit[0]][koordinaatit[1]].isEmpty()) {
            System.out.println("Ruudussa ei ole syötävää nappulaa");
            return false;
        } else {
            nappulat[koordinaatit[0]][koordinaatit[1]] = nappula;
            int[] vanhaSijainti = nappula.getKoordinaatit();
            nappulat[vanhaSijainti[0]][vanhaSijainti[1]] = new Tyhja();
            nappula.asetaKoordinaatit(koordinaatit);
        }
        return true;
    }
}
