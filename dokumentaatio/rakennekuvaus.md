##Game
Pelillä on variantti (tällä hetkellä vain standardishakki on toteutettu), lauta (tai lautoja myöhemmin), UI ja vuorohistoria.
##Lauta
Laudalla on leveys ja pituus, ja taulukko siitä mitä on missäkin ruudussa.
#Nappula
Nappuloilla on sijainti, merkki joka kuvastaa valkoista nappulaa ja toinen merkki mustalle, ja merkki jota käytetään notaatiossa ja nappulan tunnistamisessa.
Nappulalla on tietenkin monta aliluokkaa. Perusshakin nappuloille löytyy kätevästi unicode-merkit. Keijushakkinappulat joutuvat luultavasti tyytymään tylsempiin merkkeihin.
##Variantti
Jokaisella variantilla on määritelty laudan/lautojen koko, kuinka monta lautaa on, ja kumpi puoli aloittaa. Niillä on funktiot nappuloitten asettamisseen aloituspaikoilleen.
##FairyVariant, FairyPiece ja FairyVariantReader
FairyVariant voi toteuttaa monenlaisia shakkivariantteja. FairyVariantReader-luokan avulla FairyVariantin voi tehdä xml-tiedostosta, jossa variantti on määritelty.
##Vuorohistoria
Vuorohistorialla on lista pelin menneistä vuoroista.
#Vuoro
Vuoro koostuu vuoronumerosta, valkoisen siirrosta ja mustan siirrosta.
##UI
UIssa on JPanel jokaiselle ruudulle (tällä hetkellä lukittu 8x8 lautaan), komentokenttä ja vuorohistorialle tekstialue. Ruudussa näkyy ruudussa olevan nappulan merkki.
##Parser
Parser-luokka tarjoaa staattisia metodeja käskyjen ja algebrallisten koordinaittien kääntämiseksi.
##Liikkuminen
Liikkuminen-luokka taas tarjoaa staattisia metodeja nappuloitten siirtämiseen. Selkeyden vuoksi osa sen käyttämistä metodeista on muissa luokissa (enimmäkseen xyzLiikkuminen, mutta myös Tornitus), jolloin luokka ei pääse kasvamaan valtavaksi. 
##Shakitus
Luokka tarjoaa staattisia metodeja, joilla selvittää onko joku shakissa, matissa tai patissa.
##HiiriKuuntelija
Luokka toteuttaa kuuntelijan siirtojen hiirellä tekemistä varten.
