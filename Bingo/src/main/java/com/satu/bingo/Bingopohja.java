/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satu.bingo;

/**
 *
 * @author bensatu
 */
public class Bingopohja {

    // private char[][] taulukko = new char[3][3];
    private char[][] taulukko = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}; // alustus
    private int kaikkimerkit, xrivi, xsarake;

    // konstruktori Kuvatus luo uuden jätkänshakin ja nollaa laskurin
    public Bingopohja() {
        this.kaikkimerkit = 0;
        System.out.println("konstruktori Bingopohja");
        System.out.println("0,0 arvo: " + taulukko[0][0]);
        
    }

    public boolean muutaMerkki(int rivi, int sarake, char merkki) { // onko indexien arvot ok ja onko tilaa?
        if (rivi >= 0 && rivi <= 2 && sarake >= 0 && sarake <= 2 && (taulukko[rivi][sarake] == ' ')) {
            taulukko[rivi][sarake] = merkki;
            kaikkimerkit++;
            return true;
        } else {
            return false;
        }
    }

    public boolean taulukkoEiTaysi() { // taulukkoon mahtuu 9 arvoa
        if (kaikkimerkit < 9) {
            return true;
        } else {
            return false;
        }
    }

    public void arvoMerkkiX() { // arvotaan niin monta kertaa, että tyhjä paikka löytyy 
        do {
            xrivi = (int) (Math.random() * 3);
            xsarake = (int) (Math.random() * 3);
        } while (!(muutaMerkki(xrivi, xsarake, 'X')));
        piirra();
    }

    public char taulukkoVoittaja() { // palautetaan merkki, jos se voitti, muuten blanco
        for (int i = 0; i < 3; i++) { // vaakaan
            if (taulukko[i][0] != ' ' && taulukko[i][0] == taulukko[i][1] && taulukko[i][1] == taulukko[i][2]) {
                return taulukko[i][0];
            }
        }
        for (int j = 0; j < 3; j++) { // pystyyn
            if (taulukko[0][j] != ' ' && taulukko[0][j] == taulukko[1][j] && taulukko[1][j] == taulukko[2][j]) {
                return taulukko[0][j];
            }
        }
        // vinoon
        if (taulukko[0][0] != ' ' && taulukko[0][0] == taulukko[1][1] && taulukko[1][1] == taulukko[2][2]) {
            return taulukko[0][0];
        }
        // vinoon
        if (taulukko[0][2] != ' ' && taulukko[0][2] == taulukko[1][1] && taulukko[1][1] == taulukko[0][2]) {
            return taulukko[0][2];
        }
        return ' '; // ei löytynyt voittomerkkijonoa
    }

    public void piirra() { // tulostetaan taulukko ja koordinaatit
        for (int i = 0; i < taulukko.length; i++) {
            if (i == 0) {
                System.out.println(" 0 1 2");
            }
            System.out.print(i);
            for (int j = 0; j < taulukko[i].length; j++) {
                System.out.print(taulukko[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
