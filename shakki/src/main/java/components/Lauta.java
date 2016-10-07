package components;

import java.util.Arrays;
import java.util.regex.Pattern;
import logic.Parser;

/**
 * Luokka toteuttaa shakkilaudan. Lauta tietää mikä nappula on missäkin
 * ruudussa.
 *
 * @author Oskari
 */
public class Lauta {

    private int leveys;
    private int pituus;
    private Nappula[][] nappulat;

    /**
     * Konstruktori ilman parametreja, olettaa laudan kooksi 8x8.
     */
    public Lauta() {
        this.leveys = 8;
        this.pituus = 8;
        nappulat = new Nappula[leveys][pituus];
    }

    /**
     *  Kostruktori jolle annettu laudan leveys ja pituus.
     * @param leveys laudan leveys
     * @param pituus laudan pituus
     */
    public Lauta(int leveys, int pituus) {
        this.leveys = leveys;
        this.pituus = pituus;
        nappulat = new Nappula[leveys][pituus];
    }

    public Nappula getNappula(int[] koordinaatit) {
        return nappulat[koordinaatit[0]][koordinaatit[1]];
    }

    public Nappula getNappula(String string) {
        int[] koordinaatit = logic.Parser.parseAlgebraic(string);
        return getNappula(koordinaatit);
    }

    /**
     * Kopioi laudan.
     * @return palauttaa laudan kopion
     */
    public Lauta kopioi() {
        Lauta kopio = new Lauta(leveys, pituus);
        kopio.alustaLauta();
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < pituus; j++) {
                int[] koordinaatit = {i, j};
                Nappula kopioituNappula = getNappula(koordinaatit).kopioi();
                kopio.aseta(kopioituNappula, koordinaatit);
            }
        }
        return kopio;
    }

    /**
     * Alustaa laudan jokaiseen ruutuun Tyhja-olion.
     */
    public void alustaLauta() {
        int[] koordinaatit = {0, 0};
        Tyhja tyhja = new Tyhja();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                nappulat[i][j] = tyhja;
            }
        }
    }

    /**
     * Metodi asettaa annetun nappulan tyhjään ruutuun.
     *
     * @param nappula laudalle asetettava nappula
     * @param koordinaatit minne nappula asetetaan
     * @return onnistuiko asetus
     */
    public boolean aseta(Nappula nappula, int[] koordinaatit) {
        if (koordinaatit[0] < 0 || koordinaatit[0] >= leveys
                || koordinaatit[1] < 0 || koordinaatit[1] >= pituus) {
            return false;
        }
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
//            System.out.println("Ruudussa on jo nappula");
            return false;
        }
        return true;
    }

    /**
     * Metodi asettaa annetun nappulan tyhjään ruutuun.
     * @param nappula asetettava nappula
     * @param algebraic algebralliset koordinaatit ruudulle minne nappula asetetaan
     * @return onnistuiko asetus
     */
    public boolean aseta(Nappula nappula, String algebraic) {
        int[] koordinaatit = Parser.parseAlgebraic(algebraic);
        if (koordinaatit == null) {
            return false;
        }
        if (koordinaatit[0] < 0 || koordinaatit[0] >= leveys
                || koordinaatit[1] < 0 || koordinaatit[1] >= pituus) {
            return false;
        }
        return aseta(nappula, koordinaatit);
    }

    /**
     * Metodi siirtää nappulan toiseen ruutuun ja syö siinä olevan nappulan.
     *
     * @param nappula siirrettävä nappula
     * @param koordinaatit ruutu missä nappula syö toisen nappulan
     * @return onnistuiko siirto (ei voi syödä omaa)
     */
    public boolean syo(Nappula nappula, int[] koordinaatit) {
        if (koordinaatit[0] < 0 || koordinaatit[0] >= leveys
                || koordinaatit[1] < 0 || koordinaatit[1] >= pituus) {
            return false;
        }
        if (nappulat[koordinaatit[0]][koordinaatit[1]].isEmpty()) {
//            System.out.println("Ruudussa ei ole syötävää nappulaa");
            return false;
        } else if (nappula.getPuoli()
                == nappulat[koordinaatit[0]][koordinaatit[1]].getPuoli()) {
//            System.out.println("Et voi syöda omaa nappulaasi");
            return false;
        } else {
            nappulat[koordinaatit[0]][koordinaatit[1]] = nappula;
            int[] vanhaSijainti = nappula.getKoordinaatit();
            nappulat[vanhaSijainti[0]][vanhaSijainti[1]] = new Tyhja();
            nappula.asetaKoordinaatit(koordinaatit);
        }
        return true;
    }

    /**
     * Metodi siirtää nappulan toiseen ruutuun ja syö siinä olevan nappulan.
     *
     * @param nappula siirrettävä nappula
     * @param algebraic algebralliset koordinaatit ruudulle mistä syödään nappula
     * @return onnistuiko siirto (ei voi syödä omaa)
     */
    public boolean syo(Nappula nappula, String algebraic) {
        int[] koordinaatit = Parser.parseAlgebraic(algebraic);
        if (koordinaatit == null) {
            return false;
        }
        if (koordinaatit[0] < 0 || koordinaatit[0] >= leveys
                || koordinaatit[1] < 0 || koordinaatit[1] >= pituus) {
            return false;
        }
        return syo(nappula, koordinaatit);
    }

    /**
     * Metodi laittaa annettuun ruutuun Tyhja-olion. Tarkoitettu ohestalyönnille
     * mutta voi tarvittaessa käyttää muuhunkin muissa varianteissa.
     * @param syotava koordinaatit ruudulle josta poistetaan nappula
     */
    public void enPassantPoistaSyoty(int[] syotava) {
        nappulat[syotava[0]][syotava[1]].asetaKoordinaatit(new int[2]);
        nappulat[syotava[0]][syotava[1]] = new Tyhja();
    }
    public int getLeveys() {
        return leveys;
    }

    public int getPituus() {
        return pituus;
    }

    /**
     * Printtaa laudan konsolille. Ei tällä hetkellä toimi kunnolla unicoden
     * kanssa, ja on muutenkin turha kun graafinen UI on olemassa.
     *
     */
//    public void printBoardState() {
//        int[] koordinaatit = {0, 0};
//        for (int i = 7; i >= 0; i--) {
//            koordinaatit[1] = i;
//            for (int j = 0; j < 8; j++) {
//                koordinaatit[0] = j;
//                System.out.print(getNappula(koordinaatit).getMerkki());
//            }
//            System.out.println("");
//        }
//    }
}
