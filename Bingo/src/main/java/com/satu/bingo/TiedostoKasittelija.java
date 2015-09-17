/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satu.bingo;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author bensatu
 */
public class TiedostoKasittelija {
    // muista, että tiedostonkäsittelyn virheet voi palauttaa Exceptionissa ?!? 

    public boolean onkoFOlemassa(File tiedosto) {
        if (tiedosto.exists()) {
            return false;
        } else {
            return true;
        }

    }

    public boolean luoF(File tiedosto, String tiedostonimi) {
        return true;
    }

    public static String[] getLabelit(File tiedosto) {
        // pitäisikö palauttaa ArrayList ?? mitä hyötyä vaihtuvanmittaisesta?
        String[] taulu = new String[12];
        return taulu;
    }

}
