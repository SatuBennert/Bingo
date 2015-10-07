package com.satu.bingo;

/**
 *
 * @author bensatu
 *
 * Bingopohjaan talletetaan käyttäjän valitsemat bingoruudut 5X5 taulukosta
 *
 */
public class Bingopohja {

    private char[][] taulukko;
    final int rmax, smax;  // rmax = rivi = y, smax = sarake = x
    final int lkmmax;
    private char[] bingonapit; // pidetään tallessa napit, joissa bingo
    private int[][] koordinaatit;

    /**
     * Bingopohja -konstruktori luo labeleille oletusarvoiksi arvot 'bullshit'
     * ja luo toivotun kokoisen bingpohjan.
     *
     * @param bingokoko nelöin sivun pituus ts. nappien lkm per sivu
     * @param koordinaatit kunkin napin (=index) koordinaatti (x,y) ko.
     * bingotaulussa
     */
    public Bingopohja(int bingokoko, int[][] koordinaatit) {
        taulukko = new char[bingokoko][bingokoko];
        for (int i = 0; i < bingokoko; i++) {
            for (int j = 0; j < bingokoko; j++) {
                taulukko[i][j] = ' ';
            }
        }
        rmax = bingokoko;
        smax = bingokoko;
        lkmmax = bingokoko;
        bingonapit = new char[koordinaatit.length];
        this.koordinaatit = new int[koordinaatit.length][2];
        for (int h = 0; h < koordinaatit.length; h++) {
            bingonapit[h] = ' ';
            this.koordinaatit[h][0] = koordinaatit[h][0];
            this.koordinaatit[h][1] = koordinaatit[h][1];
        }
    }

    public char[] getBingonapit() {
        return bingonapit;
    }

    /**
     * muutaMerkki lisää valitun bingon ruudun
     *
     * @param rivi on y-koordinaatti
     * @param sarake on x-koordinaatti
     * @param merkki voi olla mikä tahansa ei-tyhjä -merkki
     * @return palauttaa true, jos merkin lisäys tauluun onnistui false, jos
     * merkin lisäyt tauluun ei onnistunut
     */
    public boolean muutaMerkki(int rivi, int sarake, char merkki) { // onko indexien arvot ok ja onko tilaa?
        if (rivi >= 0 && rivi <= rmax && sarake >= 0 && sarake <= smax && (taulukko[rivi][sarake] == ' ')) {
            taulukko[rivi][sarake] = merkki;
            return true;
        } else {
            return false;
        }
    }

    /**
     * onBingo testaa, onko viisi peräkkäistä ruutua valittu
     *
     * @return true, jos viisi peräkkäistä ruutua on valittu false, jos viittä
     * peräkkäistä ruutua ei löydy
     */
    public boolean onBingo() {
        boolean ok = false;
        if (onPystyBingo()) {
            ok = true;
        }
        if (onVaakaBingo()) {
            ok = true;
        }
        if (onVino1Bingo()) {
            ok = true;
        }
        if (onVino2Bingo()) {
            ok = true;
        }
        return ok;
    }

    /**
     * onPystyBingo -metodi tutkii onko viisi peräkkäistä ruutua pystyriveissä.
     * Jos löytyy rivi, merkataan jokainen nappi, joka kuuluu tähän bingoon.
     *
     * @return true, löytyy yksikin pystyrivi false, ei löydy yhtään pystyriviä
     */
    private boolean onPystyBingo() {
        boolean ok = false;
        for (int kx = 0; kx < smax; kx++) {
            int lkm = 0;
            for (int ky = 0; ky < rmax; ky++) {
                if (taulukko[ky][kx] != ' ') {
                    lkm++;
                    if (lkm == lkmmax) {
                        talletaXBingo(kx);
                        ok = true;
                        lkm = 0;
                    }
                }
            }
        }
        return ok;
    }

    private void talletaXBingo(int x) {
        for (int a = 0; a < koordinaatit.length; a++) {
            if (koordinaatit[a][1] == x) {
                bingonapit[a] = 'X';
            }
        }
    }

    /**
     * on VaakaBingo -metodi tutkii onko viisi peräkkäistä ruutua vaakariveissä
     * Jos löytyy rivi, merkataan jokainen nappi, joka kuuluu tähän bingoon.
     *
     * @return true, löytyy yksikin vaakarivi false, ei löydy yhtään vaakariviä
     */
    private boolean onVaakaBingo() {
        boolean ok = false;
        for (int ky = 0; ky < rmax; ky++) {
            int lkm = 0;
            for (int kx = 0; kx < smax; kx++) {
                if (taulukko[ky][kx] != ' ') {
                    lkm++;
                    if (lkm == lkmmax) {
                        talletaYBingo(ky);
                        ok = true;
                        lkm = 0;
                    }
                }
            }
        }
        return ok;
    }

    private void talletaYBingo(int y) {
        for (int a = 0; a < koordinaatit.length; a++) {
            if (koordinaatit[a][0] == y) {
                bingonapit[a] = 'X';
            }
        }
    }

    /**
     * onVino1Bingo tutkii, löytyykö viisi peräkkäistä ruutua / -muodossa Jos
     * löytyy rivi, merkataan jokainen nappi, joka kuuluu tähän bingoon.
     *
     ** @return true, löytyy false, ei löydy
     *
     */
    private boolean onVino1Bingo() {
        int lkm = 0;
        for (int k = 0; k < smax; k++) {
            if (taulukko[k][k] != ' ') {
                lkm++;
                if (lkm == lkmmax) {
                    talletaVino1Bingo();
                    return true;
                }
            }
        }
        return false;
    }

    private void talletaVino1Bingo() {
        for (int a = 0; a < koordinaatit.length; a++) {
            for (int k = 0; k < smax; k++) {
                if (koordinaatit[a][0] == k
                        && koordinaatit[a][1] == k) {
                    bingonapit[a] = 'X';
                }
            }
        }
    }

    /**
     * onVino2Bingo -metodi tutkii löytyykö viisi peräkkäistä ruutua \ -muodossa
     * Jos löytyy rivi, merkataan jokainen nappi, joka kuuluu tähän bingoon.
     *
     * @return true, löytyy false, ei löydy
     */
    private boolean onVino2Bingo() {
        int lkm = 0;
        int kx = smax - 1;
        for (int ky = 0; ky < rmax; ky++) {
            if (taulukko[ky][kx] != ' ') {
                lkm++;
                kx--;
                if (lkm == lkmmax) {
                    talletaVino2Bingo();
                    return true;
                }
            }
        }
        return false;
    }

    private void talletaVino2Bingo() {
        for (int a = 0; a < koordinaatit.length; a++) {
            int kx = smax - 1;
            for (int ky = 0; ky < rmax; ky++) {
                if (koordinaatit[a][0] == ky && koordinaatit[a][1] == kx) {
                    bingonapit[a] = 'X';
                }
                kx--;
            }
        }
    }

    /**
     * piirra -metodi piirtää 2-ulotteisen taulukon ja näyttää valitut ruudut
     * piirra -metodi on ohjelmoinnin apuväline, eikä käytössä lopullisessa
     * ohjelmaversiossa
     */
    public void piirra() { // tulostetaan koordinaatit ja valitut ruudut
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
