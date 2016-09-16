/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import com.javalabra.shakki.*;

public class Main {

    public static void main(String[] args) {
        Lauta lauta = new Lauta();
        int[] koordinaatit = {0, 0};
        lauta.aseta(new Torni("valkoinen", lauta), koordinaatit);
        koordinaatit[0] = 7;
        lauta.aseta(new Torni("valkoinen", lauta), koordinaatit);
        koordinaatit[1] = 7;
        lauta.aseta(new Torni("musta", lauta), koordinaatit);
        koordinaatit[0] = 0;
        lauta.aseta(new Torni("musta", lauta), koordinaatit);
        koordinaatit[1] = 1;
        for (int i = 0; i < 8; i++) {
            koordinaatit[0] = i;
            lauta.aseta(new Sotilas("valkoinen", lauta), koordinaatit);
        }
        koordinaatit[1] = 7;
        for (int i = 0; i < 8; i++) {
            koordinaatit[0] = i;
            lauta.aseta(new Sotilas("musta", lauta), koordinaatit);
        }
    }
}
