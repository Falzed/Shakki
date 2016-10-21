##Pelin käynnistäminen ja UI
Pääluokka on main.Main
Käynnistettyäsi ohjelman pitäisi tulla näkyviin shakkilauta, sen alla tekstikenttä ja isompi tekstikenttä oikealle. Laudan alapuolella kenttä on komennoille, oikealle tulee näkymään tehdyt siirrot.
##Komennot
Voit antaa komennon klikkaamalla (vasen hiirinäppäin) nappulaa jota haluat siirtää ja sitten ruutua minne haluat siirtää sen. Kun olet valinnut nappulan et voi sinänsä poistaa valintaa, mutta voit tietenkin koittaa tehdä laittoman siirron (esim. käskeä nappulan syödä itsensä) jos klikkaat vahingossa väärää nappulaa. Käyttöliittymä ei jostain syystä vaikuta aina reagoivan klikkaukseen ensimmäisellä yrityksellä.

Voit myös antaa komennon laudan alla olevalla komentorivillä (joudut luultavasti kasvattamaan ikkunaa jotta se tulee näkyviin). Komento voi alla muotoa e2-e4, jolloin siirretään (jos mahdollista) nappula e2:sta e4:ään. Koordinaattien pitäisi olla ruutujen vasemmassa yläkulmassa. a-kolumni on vasemmalla, h oikealla. Alin rivi on 1 (missä valkoisen upseerit aloittavat), korkein 8.
Toinen vaihtoehto on laittaa komennon alkuun siirrettävän nappulan merkki englanninkielisessä algebrallisessa shakkinotaatiossa:
* Kuningas/King: K
* Kuningatar/Queen: Q
* Torni/Rook: R
* Lähetti/Bishop: B
* Ratsu/Knight: N
* Sotilas: jätä tyhjäksi jos siirryt vain eteenpäin, x syödessä. Ohestalyöntiä ei merkitä erikseen.
* Tornitus: oikealle (lyhyt) O-O tai 0-0, vasemmalle (pitkä) O-O-O tai 0-0-0
Tämän perään laitetaan kohderuudun koordinaatit, esim e4 siirtää sotilaan e2:sta e4:ään, Nf3 ratsun f3:een. Tämä kuitenkin toimii vain jos komento on yksikäsitteinen, eli et voi kirjoittaa eNf3 jos haluat siirtää e-linjan ratsun f3:een jos monta ratsua voi siirtyä sinne. Lisäksi muuta shakkinotaatiota (!, ? jne) ei tueta.

Korottaessa peli avaa valikon, josta voit valita miksi korotat.

##Vuorohistoria
Voit kirjoittaa vuorohistoriaan siirtoja, esim
1. d4 d5
2. c4 xc4
ja klikata submit-painiketta, jolloin peli palaa alkuasemaan ja käy läpi annetut siirrot. Tässä on kuitenkin samat rajoitteet kuin komentojen antamisessa. Jos ohjelma ei saa selvää syötteestä, se antaa virheilmoituksen ja palauttaa vanhan historian.

##Variantin valinta
 Varianttia vaihtaessa peli palaa alkuasemaan. Variantit määritellään xml-tiedostossa. UIn tuntemia variantteja on tosin vain Dunsany's Chess ja Charge of the Light Brigade, muut saat käyttöön klikkaamalla File->Open ja valitsemalla haluamasi xml-tiedoston.

File-valikosta voi myös vaihtaa variantin Dunsany's Chess tai Charge of the Light Brigade -variantteihin. Tämä vaatii, että xml-tiedostot ovat ohjelman odottamassa paikassa. jos ajat ohjelmaa Netbeansissa, ongelmaa ei pitäisi olla.

Jos ajat ohjelmaa .jar: sta, täytyy sen löytää olla src/main/resources -kansio. Jos olet kloonannut repon, repon juuressa olevan .jar-tiedoston pitäisi löytää tarvittavat xml-tiedostot. Jos olet ladannut pelkän .jar-tiedoston, tee samanlainen hakemistostruktuuri, eli tee sen sijaintiin kansio src, sen sisälle kansio main, ja sen sisälle kansio resources ja kopioi resourcesiin [src/main/resources](../shakki/src/main/resources)-kansion sisältö.

##Virheilmoitukset
Ohjelman virheilmoitukset eivät valitettavasti ole kovin tarkkoja siitä, mikä täsmälleen meni pieleen.
