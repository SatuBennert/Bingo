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

import com.satu.bingo.Kayttoliittymat.*;

/**
 *
 * @author bensatu
 */
public class PaaOhjelma {

    public static void main(String[] args) {

//seuraava koodi rinnakkaisuuden takia:
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Valikko v = new Valikko();
                v.gui();
                System.out.println("gui ohi?");
            }

        }
        );
    }

}
