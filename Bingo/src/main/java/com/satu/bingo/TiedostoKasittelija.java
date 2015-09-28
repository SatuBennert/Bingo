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

    public TiedostoKasittelija() {
        //alustetaan labelit -taulu 
        for (int i = 0; i < lkmmax; i++) {
            labelit[i] = i + ": bullshit";
        }
    }

    public boolean onFOlemassa(File tiedosto) {
        if (tiedosto.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public String haeSalasana(File tiedosto, String user) {
        boolean loytyi = false;
        try {
            Scanner tlukija = new Scanner(tiedosto);
            while (tlukija.hasNextLine()) {
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
        return "heipsa";
    }

    public boolean luoF(File tiedosto, String tiedostonimi) {
        return true;
    }

    public String[] haeLabelit(File tiedosto) {
        if (onFOlemassa(tiedosto)) {
            lueArrayhin(tiedosto);
            lueTauluun();
        }
        return labelit;
    }

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

// täyttää taulun randomisti olemassa olevilla Array:n alkioilla, nimet pitää olla unique,
// koska nappi yksilöityy nimellä
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
