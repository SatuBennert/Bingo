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

    public String getNimi() {
        return this.nimi;
    }

    public String getSalasana() {
        return this.salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    public boolean tarkistaSalasana(String salasana) {
        if (this.salasana.equals(salasana)) {
            return true;
        } else {
            return false;
        }

    }
}
