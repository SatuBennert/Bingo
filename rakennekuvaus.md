#Bingon rakennekuvaus

PaaOhjelma
* PaaOhjelma -luokka kutsuu Valikkoa, josta varsinainen ohjelma alkaa LogIn -ja
BingonYlläpito -napeilla.

Valikko
* Valikosta valitaan joko LogIn -sisäänkirjaus tai Bingo -bingon 
pelaaminen/ylläpito. Näillä ei ole (toistaiseksi) yhteyttä keskenään.
* Valikossa luodaan users.txt -tiedosto, jos sitä ei ole ja sinne lisätään
kolme käyttäjä-salasana -paria: "Mango koira", "Satu salasana" ja "tunnus salasana". 

Kirjautuminen
* Kirjautuminen -ikkunassa tarkistetaan syötetty käyttäjätunnus ja salasana.
* Ikkuna sulkeutuu, kun tiedot ovat oikein. 
* Käyttäjätunnus ja salasana tarkistetaan users.txt -tiedostosta. Tämä ei ole hyvän tietoturvan mukaista. Työn alla on Käyttäjän tallettaminen oliona tiedostoon.

BingoYlläpito
* BingoYllapito - ikkunassa voi selata, luoda, ja poistaa bingoja 
sekä aloittaa bingon pelaamisen. 
* Käyttäjä voi nimetä oman bingon ja antaa napeille labelit. 
* Käyttäjä voi käynnistää ruudussa näkyvillä tiedoilla bingon eri 
kokoisina peleinä. Valittavana on 3X3 pikapelistä tai jopa 10X10 -kokoiseen
megabingoon.
* Omia bingoja voi selata eteen- ja taaksepäin. Jos selaa viimeisestä 
vielä eteenpäin, saa ensimmäisen. Jos selaat ensimmäisestä vielä 
taaksepäin, saa viimeisen.
* Jos omia bingoja ei ole tehty, tulee bingoon labeleiksi "bullshit".  
* Bingon nimen mukaan luodaan teksitiedosto, johon talletetaan bingon labelit.
* Voit käynnistää monta bingoa pelattavaksi yhtä aikaa. Tällöin 
jokaiseen bingoon tulee erilainen pelipohja eli labelit ovat eri järjestyksessä.

BingoIkkuna
* BingoIkkuna on neliöruudukko, jossa pelataan bingoa. 
* Ruudun reunat muuttuvat punaisiksi, kun valinta on tehty eli ruutua klikattu.
* Bingo tulee silloin, kun kokonainen rivi (pysty, vaaka, vino) on valittu. 
Bingo näkyy punaisina ruutuina. 
* Peliä voi pelata koko ruudukon täyteen eli saavuttaa kaikki vaaka- ja pystybingot.
* Pelin voit lopetta milloin tahansa sulkemalla ikkunan. 

BingoPohja
* Bingopohja on pelialusta, jolla pidetään kirjaa pelin kulusta. 
* Jokainen pelaajan valitsema nappi talletaan, jotta voidaan tutkia, onko bingo saavutettu.
* Bingo voi olla mikä tahansa pysty- tai vaakarivi tai vino / -tai \ -suuntaan.
* BingoPohja on samankokoinen kuin pelattava bingo. 

TiedostoKasittelija
* TiedostoKasittelija tekee tiedosto-operaatiot: luonti, lisäys, muutos, 
poisto ja erilaisia hakuja ja tarkistuksia tiedostoon.
* TiedostoKasittelija luodaan BingonYllapidossa kerran.
* TiedostoKasittelija käsittelee .txt -tyyppistä peräkkäistiedostoa.
* TiedostoKasittelija haeLabelit -metodi hakee annetusta tiedostosta 
rivit bingon nappien nimiksi. Jos tiedosto-ongelmia, palautetaan
 taulukko "bullshit" -arvoilla.
 
Tekstiiedostot
* systeemitiedosto users.txt sisältää käyttäjät ja salasanat
* käyttäjän nimen mukainen tiedosto sisältää bingojen otsikot ja
otsikon nimen mukainen tiedosto sisältää bingojen labelit


Jatkokehitys
* Käyttäjä voi rekisteröityä ja vain rekisteröitynyt käyttäjä pääsee pelaamaan
bingoja. 
* Käyttäjä voi siirtää oman bingonsa toiselle käyttäjälle.
* Käyttäjän tiedot talletetaan oliona tiedostoon, jolloin tietoturva on huomioitu.

----- ***** ----- ***** ----- ***** ----- ***** ----- ***** -----
