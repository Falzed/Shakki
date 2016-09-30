package variants;

import components.*;

public class Standard extends Variant {

    public static void setUp(Lauta lauta) {
        lauta.alustaLauta();
        System.out.println("alustettu");
        int[] koordinaatit = new int[2];
        koordinaatit[0] = 0;
        koordinaatit[1] = 0;
        System.out.println("Tornit");
        lauta.aseta(new Torni("valkoinen"), koordinaatit);
        koordinaatit[0] = 7;
        lauta.aseta(new Torni("valkoinen"), koordinaatit);

        koordinaatit[1] = 7;
        lauta.aseta(new Torni("musta"), koordinaatit);
        koordinaatit[0] = 0;
        lauta.aseta(new Torni("musta"), koordinaatit);
        System.out.println("ratsut");
        koordinaatit[0] = 1;
        koordinaatit[1] = 0;
        lauta.aseta(new Ratsu("valkoinen"), koordinaatit);
        koordinaatit[0] = 6;
        lauta.aseta(new Ratsu("valkoinen"), koordinaatit);

        koordinaatit[1] = 7;
        lauta.aseta(new Ratsu("musta"), koordinaatit);
        koordinaatit[0] = 1;
        lauta.aseta(new Ratsu("musta"), koordinaatit);
        System.out.println("lahetit");
        koordinaatit[0] = 2;
        koordinaatit[1] = 0;
        lauta.aseta(new Lahetti("valkoinen"), koordinaatit);
        koordinaatit[0] = 5;
        lauta.aseta(new Lahetti("valkoinen"), koordinaatit);

        koordinaatit[1] = 7;
        lauta.aseta(new Lahetti("musta"), koordinaatit);
        koordinaatit[0] = 2;
        lauta.aseta(new Lahetti("musta"), koordinaatit);
        System.out.println("kuningattaret");
        koordinaatit[0] = 3;
        koordinaatit[1] = 0;
        lauta.aseta(new Kuningatar("valkoinen"), koordinaatit);
        koordinaatit[1] = 7;
        lauta.aseta(new Kuningatar("musta"), koordinaatit);
        System.out.println("kuninkaat");
        koordinaatit[0] = 4;
        koordinaatit[1] = 0;
        lauta.aseta(new Kuningas("valkoinen"), koordinaatit);
        koordinaatit[1] = 7;
        lauta.aseta(new Kuningas("musta"), koordinaatit);

        System.out.println("sotilaat");
        koordinaatit[1] = 1;
        for (int i = 0; i < 8; i++) {
            koordinaatit[0] = i;
            lauta.aseta(new Sotilas("valkoinen"), koordinaatit);
        }
        koordinaatit[1] = 6;
        for (int i = 0; i < 8; i++) {
            koordinaatit[0] = i;
            lauta.aseta(new Sotilas("musta"), koordinaatit);
        }
    }
}
