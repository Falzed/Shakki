##Mitä ei testattu
UI:ta ei testattu automaattisesti, eikä util-pakkauksen debuggereita (joitten oli tarkoitus olla gitignoressa mutta näköjään unohtui lisätä ne sinne...).
UI:n testaus olisi vaatinut kirjastojen joita en tunne käyttöä, eikä se ollut vaadittu (nämä ovat varmaan oikeastaan sama syy). UI:ta on testattu käsin koittamalla pelata peliä, ja antamalla invalideja inputteja.

##Mahdollisia bugeja
Testasin variantin vaihtoa vain nopeasti laitoksen koneella tai linuxilla ylipäänsä. Variantin lukemisessa xml-tiedostosta saattaisi olla bugeja muulla kuin windowsilla (tai sitten se ei vain toimi).

Komentojen ja vuorohistorian jäsentämisessä saattaa olla vielä bugeja jotka eivät ole jääneet kiinni testeissä, mutta sain toivottavasti ne korjattua aiemmin tänään.
