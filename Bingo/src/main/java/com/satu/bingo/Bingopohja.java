package com.satu.bingo;

/**
 *
 * @author bensatu
 */
public class Bingopohja {

    // private char[][] taulukko = new char[3][3];
    private char[][] taulukko = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}; // alustus
    private int kaikkimerkit, xrivi, xsarake;

    // konstruktori luo uuden pohjan ja nollaa laskurin
    public Bingopohja() {
        this.kaikkimerkit = 0;

    }

    public boolean muutaMerkki(int rivi, int sarake, char merkki) { // onko indexien arvot ok ja onko tilaa?
        if (rivi >= 0 && rivi <= 2 && sarake >= 0 && sarake <= 2 && (taulukko[rivi][sarake] == ' ')) {
            taulukko[rivi][sarake] = merkki;
            kaikkimerkit++;
            return true;
        } else {
            return false;
        }
    }// tarvitaanko ollenkaan? 

    public boolean taulukkoEiTaysi() { // taulukkoon mahtuu 9 arvoa
        if (kaikkimerkit < 9) {
            return true;
        } else {

            return false;
        }
    }

    // ei tarvita tämmöisenään, mutta kun haetaan tiedostosta
    // labelit bingoon, niin tarvitsee ottaa mukaan randomisti tekstejä 
    // -> tarvitaan myöhemmin sovellettuna
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
        if (taulukko[0][2] != ' ' && taulukko[0][2] == taulukko[1][1] && taulukko[1][1] == taulukko[2][0]) {
            return taulukko[0][2];
        }
        return ' '; // ei löytynyt voittomerkkijonoa
    }

    // testaamista varten, jotta nähdään, että napit toimivat kuten taulukko
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
