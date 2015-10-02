/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satu.bingo;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author bensatu
 */
public class TiedostoKasittelija {

    // muista, että tiedostonkäsittelyn virheet voi palauttaa Exceptionissa ?!? 
    private ArrayList<String> tiedsis = new ArrayList<>();
    private String[] labelit = new String[25];
    int lkmmax = 25;

    /**
     * TiedostoKasittelija -parametritön konstruktori muodostaa oletus taulun
     * Bingo-peliä varten.
     */
    public TiedostoKasittelija() {
        //alustetaan labelit -taulu 
        for (int i = 0; i < lkmmax; i++) {
            labelit[i] = i + ": bullshit";
        }
    }

    /**
     * onFOlemassa -metodi tutkii onko anettu tiedosto olemassa
     *
     * @param tiedosto
     * @return true, tiedosto on olemassa false, tiedostoa ei ole olemassa
     */
    public boolean onFOlemassa(File tiedosto) {
        if (tiedosto.exists()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * haeSalasana -metodi hakee annetusta tiedostosta annetulle käyttäjälle
     * salasanan
     *
     * @param tiedosto tiedosto, jossa on käyttäjät ja salasanat
     * @param user käyttäjä, jonka salasanaa haetaan
     * @return merkkjono, jonka arvo on salasana, jos salasana löytyi null, jos
     * salasanaa ei löytynyt
     */
    public String haeSalasana(File tiedosto, String user) {
        boolean loytyi = false;
        try {
            Scanner tlukija = new Scanner(tiedosto);
            while (tlukija.hasNextLine()) {
                // tunnus ja salasana erotettu tyhjä -merkillä
                for (String retval : tlukija.nextLine().split(" ")) {
                    if (loytyi) {
                        tlukija.close();
                        return retval;
                    }
                    if (retval.matches(user)) {
                        loytyi = true;
                    }
                }
            }
            tlukija.close();
            return null;
        } catch (FileNotFoundException e) {
            System.out.println("haeSalasana: tiedostokäsittelyvirhe. " + e);
        } catch (NoSuchElementException e) {
            System.out.println("haeSalasana: tiedostokäsittelyvirhe. no element " + e);
        }
        return null;
    }

    /**
     * luoF -metodi luo tiedoston
     *
     * @param tiedosto
     * @param tiedostonimi
     * @return true, jos tiedoston luonti onnistui false, jos tiedoston luonti
     * ei onnistunut
     */
    public boolean luoF(File tiedosto, String tiedostonimi) {
        return true;
    }

    /**
     * haeLabelit -metodi hakee annetusta tiedostosta 25 merkkijonoa bingon
     * sarakkeiden otsikoiksi
     *
     * @param tiedosto josta tiedot haetaan
     * @return yksiulottisen taulukon, jossa on 25 merkkijonoa
     */
    public String[] haeLabelit(File tiedosto) {
        if (onFOlemassa(tiedosto)) {
            lueArrayhin(tiedosto);
            lueTauluun();
        }
        return labelit;
    }

    /**
     * lueArrayhin -metodi hakee teksitiedostosta kaikki rivit
     * vaihtuvamittaiseen Array -muuttujaan
     *
     * @param tiedosto tekstitiedosto, jossa rivi vastaa bingon sarakkeen
     * otsikkoa
     */
    public void lueArrayhin(File tiedosto) {
        Scanner tlukija = null;
        try {
            tlukija = new Scanner(tiedosto);
            while (tlukija.hasNextLine()) {
                tiedsis.add(tlukija.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("tiedostokäsittelyvirhe. getLabelit" + e);
        } catch (NoSuchElementException e) {
            System.out.println("tiedostokäsittelyvirhe. no element getLabelit" + e);
        }
        tlukija.close();
    }

    /**
     * lueTauluun -metodi siirtää vaihtuvamittaisesta Array-muuttujasta 25
     * merkkijonoa sattumanvaraisesti siten, että jos merkkijonoja on yli 25,
     * niin samaa ei käytetä kahdesti ja jos merkkijonoja on alle 25, niin
     * samoja käytetään useamman kerran. Näin pelattava Bingo on joka kerta eri
     * näköinen. ongelma: nimet pitää olla unique, koska nimi yksilöi painetun
     * napin
     */
    public void lueTauluun() {
        for (int j = 0; j < labelit.length; j++) {
            int k = (int) (Math.random() * tiedsis.size());
            labelit[j] = j + ": " + tiedsis.get(k);
            if (tiedsis.size() > lkmmax) {
                tiedsis.remove(k);
            }

        }

    }
}
