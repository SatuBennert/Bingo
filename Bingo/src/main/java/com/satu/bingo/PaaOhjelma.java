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

import javax.swing.JFrame;

/**
 *
 * @author bensatu
 */
public class PaaOhjelma {

    public static void main(String[] args) {
        final String[] etiketit = new String[3];

        System.out.println("ohjelma alkaa");
//seuraava koodi rinnakkaisuuden takia:
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("gui alkaa ja bingo luodaan");

                // hae txt-tiedostosta uudet bingolabelit
                // tässä vasta taulu-parametrin testikäyttö
                etiketit[0] = "hii";
                etiketit[1] = "haa";
                etiketit[2] = "hoo";

                // anna ruudukolle parametrinä uudet bingolabelit
                Ruudukko pingoBongo = new Ruudukko(etiketit);
                System.out.println("pääohjelma loi Ruudukon");
                pingoBongo.gui();
                System.out.println("gui ohi?");
            }
        });
        System.out.println("main loppuu.");

    }
}
