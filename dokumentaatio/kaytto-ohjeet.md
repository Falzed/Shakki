##Pelin käynnistäminen ja UI
Pääluokka on logic.Game.
Käynnistettyäsi ohjelman pitäisi tulla näkyviin shakkilauta, sen alla tekstikenttä ja isompi tekstikenttä oikealle. Laudan alapuolella kenttä on komennoille, oikealle tulee näkymään tehdyt siirrot. Siihen kirjoittaminen ei vielä tee mitään.
##Komennot
Komento voi alla muotoa e2-e4, jolloin siirretään (jos mahdollista) nappula e2:sta e4:ään. a-kolumni on vasemmalla, h oikealla. Alin rivi on 1 (missä valkoisen upseerit aloittavat), korkein 8.
Toinen vaihtoehto on laittaa komennon alkuun siirrettävän nappulan merkki englanninkielisessä algebrallisessa shakkinotaatiossa:
* Kuningas/King: K
* Kuningatar/Queen: Q
* Torni/Rook: R
* Lähetti/Bishop: B
* Ratsu/Knight: N
* Sotilas: jätä tyhjäksi jos siirryt vain eteenpäin, x syödessä. Ohestalyöntiä ei merkitä erikseen.
* Tornitus: oikealle (lyhyt) O-O tai 0-0, vasemmalle (pitkä) O-O-O tai 0-0-0
Tämän perään laitetaan kohderuudun koordinaatit, esim e4 siirtää sotilaan e2:sta e4:ään, Nf3 ratsun f3:een. 
Valitettavasti tällä hetkellä tämä tapa toimii vain jos vain yksi nappula kyseistä tyyppiä voi siirtyä kohderuutuun, esim. dxe5 ei toimi.

Virheilmoituksia tulee konsolille, esim jos annoit laittoman siirron. Valitettavasti nämä ilmoitukset ovat vielä varsin hyötyrajoittuneita.

Korottamista ei ole vielä toteutettu, ja peli ei tunnista mattia tai pattia (tai muita tasapelejä, esim saman tilanteen toistumisesta kolme kertaa).
