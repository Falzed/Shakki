##Pelin käynnistäminen ja UI
Pääluokka on main.Main
Käynnistettyäsi ohjelman pitäisi tulla näkyviin shakkilauta, sen alla tekstikenttä ja isompi tekstikenttä oikealle. Laudan alapuolella kenttä on komennoille, oikealle tulee näkymään tehdyt siirrot.
##Komennot
Voit antaa komennon klikkaamalla (vasen hiirinäppäin) nappulaa jota haluat siirtää ja sitten ruutua minne haluat siirtää sen. Kun olet valinnut nappulan et voi sinänsä poistaa valintaa, mutta voit tietenkin koittaa tehdä laittoman siirron (esim. käskeä nappulan syödä itsensä) jos klikkaat vahingossa väärää nappulaa.

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
ja klikata submit-painiketta, jolloin peli palaa alkuasemaan ja käy läpi annetut siirrot. Tässä on kuitenkin samat rajoitteet kuin komentojen antamisessa, ja valitettavasti ei tule virheilmoitusta jos jokin menee pieleen, joten ole varovainen tämän käyttämisessä. Kuitenkin voit turvallisesti copy pastata pelin generoiman historian talteen jos haluat säilyttää aseman, ja laittaa sen takaisin vuorohistoriaan kun pelaat seuraavan kerran.

##Variantin valinta
Vasemmassa ylälaidassa on File-valikko, josta voi sulkea ohjelman tai vaihtaa varianttia. Varianttia vaihtaessa peli palaa alkuasemaan. 
