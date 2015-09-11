/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satu.bingo;

import java.util.Scanner;

/**
 *
 * @author bensatu
 */
public class Ohjelma {

    public static void main(String[] args) {
        int rivi, sarake; // käyttäjän antamat tiedot
        char voittaja = ' '; // metodin palauttama arvo: tyhjä= ei voittajaa, arvo = voittaja
        boolean syottoTiedotOk = true;
        Scanner lukija = new Scanner(System.in);
        System.out.println("Pelataanpa jätkänshakkia. Kone on X, sinä olet O.");
        Bingopohja shakki = new Bingopohja();
        // pelataan kunnes taulu täysi (9) tai voittaja löytynyt
        while (shakki.taulukkoEiTaysi() && voittaja == ' ') {
            shakki.arvoMerkkiX(); // kone arpoo oman merkkinsä paikan
            voittaja = shakki.taulukkoVoittaja(); // löytyikö voittaja?
            if (voittaja != ' ') {
                System.out.println(voittaja + " voitti!");
                syottoTiedotOk = false; // voittaja löytyi -> ei mennä while -silmukkaan
            }
            while (syottoTiedotOk) { // käyttäjän antamat koordinaatit ok ja taulussa on tilaa
                System.out.println("Anna koordinaatit. Esim. 1 2 (+ enter).");
                rivi = Integer.parseInt(lukija.next());
                sarake = Integer.parseInt(lukija.next());
                if (shakki.muutaMerkki(rivi, sarake, 'O')) { // indexit ok ja tilaa taulussa?
                    voittaja = shakki.taulukkoVoittaja(); // löytyikö voittaja?
                    if (voittaja != ' ') {
                        shakki.piirra(); // piirretään voittotaulu
                        System.out.println(voittaja + " voitti!");
                    }
                    syottoTiedotOk = false; // merkki ja päivitys ok -> ulos whilesta
                } else {
                    System.out.println("Virheelliset koordinaatit.");
                }
            }
            syottoTiedotOk = true; // kysytään uudet koordinaatit käyttäjältä
        } // end while
        System.out.println("Kiitos pelistä.");
    }
}
