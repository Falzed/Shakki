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
public class Tyhja implements Nappula {

    public Tyhja() {
    }

    @Override
    public void checkSpecials() {
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean move(int[] koordinaatit) {
        throw new UnsupportedOperationException("Yrität siirtää tyhjää ruutua???");
    }

    @Override
    public boolean captureMove(int[] koordinaatit) {
        throw new UnsupportedOperationException("Yrität siirtää tyhjää ruutua???");
    }

    @Override
    public void asetaKoordinaatit(int[] koordinaatit) {
        throw new UnsupportedOperationException("Tyhjän ruudun ei tarvitse tietää koordinaattejaan"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPuoli() {
        throw new UnsupportedOperationException("Tyhjällä ruudulla ei ole puolta");
    }

    @Override
    public int[] getKoordinaatit() {
        throw new UnsupportedOperationException("Tyhjän ruudun ei tarvitse tietää koordinaattejaan");
    }
}
