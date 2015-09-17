/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
