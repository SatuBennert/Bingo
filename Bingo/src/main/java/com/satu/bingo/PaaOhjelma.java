/*
 * Tähän pääohjelmaan pitäisi saada koko logiikka: 
 * - Ruudukon rakentamisen -kutsu (graafinen, jossa nappia painetaan, kun bingoruutu valitaan)
 * - reagointi action listenereihin
 * - tiedostotoiminnot eli TiedostoKasittelija -kutsut
 * - Bingo toimii ensin 3X3 ruudukolla, joka on tarkoitus muuttaa 5X5 ruudukoksi siten,
 *   että muutos tulisi voimaan vain PaaOhjelmaa muutamalla
 * - paketit pitäisi olla omansa ruudukon rakentamiseen, tiedostonkäsittelyyn ja ohjelmaan
 * 
 */
package com.satu.bingo;

import java.io.*;

/**
 *
 * @author bensatu
 */
public class PaaOhjelma {

    public static void main(String[] args) {
        final String[] etiketit = new String[25];

//seuraava koodi rinnakkaisuuden takia:
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Kayttaja kayttaja = new Kayttaja("Satu");
                TiedostoKasittelija tkuser = new TiedostoKasittelija();
                File users = new File("users.txt");
                kayttaja.setSalasana(tkuser.haeSalasana(users, kayttaja.getNimi()));
                System.out.println("onko salasana oikein?: " + kayttaja.tarkistaSalasana("salasana"));
                // 
                File tiedosto = new File("golfbingo.txt");
                TiedostoKasittelija tk = new TiedostoKasittelija();
                // anna ruudukolle parametrinä uudet bingolabelit
                Bingopohja b = new Bingopohja();
                Ruudukko pingoBongo = new Ruudukko(tk.haeLabelit(tiedosto));
                pingoBongo.lisaaKuuntelijat();
                pingoBongo.rakennaYlaosa();

                pingoBongo.gui();
                System.out.println("gui ohi?");
            }
        }
        );
    }
}
