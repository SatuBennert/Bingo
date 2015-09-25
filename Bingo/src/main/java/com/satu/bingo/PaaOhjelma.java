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
import javax.swing.JButton;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author bensatu
 */
public class PaaOhjelma {

    public static void main(String[] args) {
        final String[] etiketit = new String[9];

        System.out.println("ohjelma alkaa");
//seuraava koodi rinnakkaisuuden takia:
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                File tiedosto = new File("golfbingo.txt");
                TiedostoKasittelija tk = new TiedostoKasittelija();
                // anna ruudukolle parametrinä uudet bingolabelit
                Ruudukko pingoBongo = new Ruudukko(tk.haeLabelit(tiedosto));
                System.out.println("pääohjelma loi Ruudukon");
                pingoBongo.gui();
                System.out.println("gui ohi?");
            }
        }
        );
        System.out.println("main loppuu.");
    }
}
