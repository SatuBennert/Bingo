/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satu.bingo;

import java.io.File;

/**
 *
 * @author bensatu
 */
public class Kayttaja {

    private String nimi;
    private String salasana;

    public Kayttaja() {
        nimi = "";
        salasana = "";
    }

    public Kayttaja(String nimi) {
        this.nimi = nimi;
        this.salasana = "";
    }
    public Kayttaja(String nimi, String salasana) {
        this.nimi = nimi;
        this.salasana = salasana;
    }

    public String getNimi() {
        return this.nimi;
    }

    public String getSalasana() {
        return this.salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    public boolean tarkistaSalasana(File tiedosto, String user, String salasana) {
        TiedostoKasittelija tkuser = new TiedostoKasittelija(user);
//        File users = new File("users.txt");
        if (salasana.equals(tkuser.haeSalasana(tiedosto, user))) {
            return true;
        } else {
            return false;
        }

    }
}
