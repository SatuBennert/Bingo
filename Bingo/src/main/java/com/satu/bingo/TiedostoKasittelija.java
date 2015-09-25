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
    private String[] labelit = new String[9];

    public TiedostoKasittelija() {
        //alustetaan labelit -taulu 
        for (int i = 0; i < 9; i++) {
            labelit[i] = "bullshit";
        }
    }

    public boolean onkoFOlemassa(File tiedosto) {
        if (tiedosto.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean luoF(File tiedosto, String tiedostonimi) {
        return true;
    }

    public String[] haeLabelit(File tiedosto) {
        if (onkoFOlemassa(tiedosto)) {
            lueArrayhin(tiedosto);
            lueTauluun();
        }
        return labelit;
    }

    public void lueArrayhin(File tiedosto) {
        try {
            Scanner tlukija = new Scanner(tiedosto);
            while (tlukija.hasNextLine()) {
                tiedsis.add(tlukija.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("tiedostokäsittelyvirhe. getLabelit" + e);
        } catch (NoSuchElementException e) {
            System.out.println("tiedostokäsittelyvirhe. no element getLabelit" + e);
        }

    }

// täyttää taulun randomisti olemassa olevilla Array:n alkioilla
    public void lueTauluun() {
        for (int j = 0; j< labelit.length; j++) {
            int k = (int) (Math.random() * tiedsis.size());
            labelit[j] = tiedsis.get(k);
            if (tiedsis.size() > 9) {
                tiedsis.remove(k);
            }
            
        }

    }
}
