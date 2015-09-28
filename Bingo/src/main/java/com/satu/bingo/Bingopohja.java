package com.satu.bingo;

/**
 *
 * @author bensatu
 */
public class Bingopohja {

    // private char[][] taulukko = new char[5][5];
    private char[][] taulukko = {{' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}}; // alustus
    private int rmax = 5, smax = 5; // rmax = rivi = y, smax = sarake = x
    final int lkmmax = 5;

    // konstruktori ei tee mitään? satu?
    public Bingopohja() {

    }

    public boolean muutaMerkki(int rivi, int sarake, char merkki) { // onko indexien arvot ok ja onko tilaa?
        if (rivi >= 0 && rivi <= rmax && sarake >= 0 && sarake <= smax && (taulukko[rivi][sarake] == ' ')) {
            taulukko[rivi][sarake] = merkki;
            return true;
        } else {
            return false;
        }
    }

    public boolean onBingo() {
        if (onPystyBingo()) {
            return true;
        }
        if (onVaakaBingo()) {
            return true;
        }
        if (onVino1Bingo()) {
            return true;
        }
        if (onVino2Bingo()) {
            return true;
        }
        return false;
    }

    public boolean onPystyBingo() {
        for (int kx = 0; kx < smax; kx++) {
            int lkm = 0;
            for (int ky = 0; ky < rmax; ky++) {
                if (taulukko[ky][kx] != ' ') {
                    lkm++;
                    if (lkm == lkmmax) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean onVaakaBingo() {
        for (int ky = 0; ky < rmax; ky++) {
            int lkm = 0;
            for (int kx = 0; kx < smax; kx++) {
                if (taulukko[ky][kx] != ' ') {
                    lkm++;
                    if (lkm == lkmmax) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean onVino1Bingo() {
        int lkm = 0;
        for (int k = 0; k < smax; k++) {
            if (taulukko[k][k] != ' ') {
                lkm++;
                if (lkm == lkmmax) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onVino2Bingo() {
        int lkm = 0;
        int kx = smax - 1;
        for (int ky = 0; ky < rmax; ky++) {
            if (taulukko[ky][kx] != ' ') {
                lkm++;
                kx--;
                if (lkm == lkmmax) {
                    return true;
                }
            }
        }
        return false;
    }

    public void piirra() { // tulostetaan taulukko ja koordinaatit
        for (int i = 0; i < taulukko.length; i++) {
            if (i == 0) {
                System.out.println(" 0 1 2 3 4");
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
