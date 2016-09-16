package com.javalabra.shakki;

public interface Nappula {
    boolean move(int[] koordinaatit);
    boolean captureMove(int[] koordinaatit);
    void asetaKoordinaatit(int[] koordinaatit);
    default void checkSpecials() {
    }
    default boolean isEmpty() {
        return false;
    }
    int[] getKoordinaatit();
    String getPuoli();
}
