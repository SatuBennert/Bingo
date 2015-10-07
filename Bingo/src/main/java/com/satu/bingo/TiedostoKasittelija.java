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
    private String[] labelit;
    int lkm;
    String user;

    /**
     * TiedostoKasittelija - konstruktori muodostaa oletustaulun Bingo-peliä
     * varten. Taulu koko annetaan parametrinä. Taulu on yksiulotteinen ja
     * siihen haetaan bingon labelit.
     *
     * @param lkm bingolabelien lukumäärä
     */
    public TiedostoKasittelija(int lkm) {
        this.lkm = lkm;
        labelit = new String[lkm];
        //alustetaan labelit -taulu
        for (int i = 0; i < lkm; i++) {
            labelit[i] = i + ": bullshit";
        }
    }

    /**
     * TiedostoKasittelija -konstruktorilla user tekee käyttäjäkohtaisia
     * toimintoja
     *
     * @param user käyttäjätunnus
     */
    public TiedostoKasittelija(String user) {
        this.user = user;
    }

    /**
     * onFOlemassa -metodi tutkii onko anettu tiedosto olemassa
     *
     * @param tiedosto
     * @return true, tiedosto on olemassa false, tiedostoa ei ole olemassa
     */
    public boolean onFOlemassa(File tiedosto) {
        System.out.println("onFOlemassa -metodissa: " + tiedosto.toString());
        if (tiedosto.exists()) {
            System.out.println("onFOlemassa -metodi.tiedosto löyty.");
            return true;
        }
        System.out.println("onFOlemassa metodissa. ei löydy tiedostoa");
        return false;

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
     * lueSeuraava -metodi palauttaa seuraavan teksitiedoston rivin
     *
     * Lähtöoletus: tiedosto on olemassa, mutta voi olla tyhjä
     *
     * @param tiedosto, josta haetaan
     *
     * @param otsikko, rivi, jonka arvosta seuraava rivi palautetaan jos otsikko
     * = tyhjä, palautetaan ekan rivin arvo jos otsikko on viimeinen rivi,
     * palautetaan ekan rivin arvo jos ongelmia, palautetaan tyhjä arvo
     *
     * @return
     */
    public String lueSeuraava(File tiedosto, String otsikko) {
        boolean loytyi = false;
        boolean ekaluettu = false;
        String tiedots = "";
        String luettu = "";
        try {
            Scanner tlukija = new Scanner(tiedosto);
            while (tlukija.hasNextLine()) {
                System.out.println("on seurraava rivi");
                luettu = tlukija.nextLine();
                System.out.println("luettu: " + luettu);
                if (loytyi) {
                    tiedots = luettu;
                    System.out.println("löytyi eli palaut.seur: " + tiedots);
                    return tiedots;
                }
                if (!ekaluettu) {
                    tiedots = luettu; // eka talteen
                    System.out.println("eka talteen: " + tiedots);
                    ekaluettu = true;
                }
                if (luettu.equalsIgnoreCase(otsikko)) {
                    System.out.println("löytyi sama eli : " + otsikko);
                    loytyi = true; // on etsitty otsikko, palauta seuraava
                }
            }
            tlukija.close();
            System.out.println("palautetaan tiedost: " + tiedots);
            return tiedots;
        } catch (FileNotFoundException e) {
            System.out.println("lueSeuraava: tiedostokäsittelyvirhe. " + e);
        } catch (NoSuchElementException e) {
            System.out.println("lueSeuraava: tiedostokäsittelyvirhe. no element " + e);
        }
        return tiedots;
    }

    public String lueEdellinen(File tiedosto, String otsikko) {
        boolean loytyi = false;
        boolean ekaluettu = false;
        String tiedots = otsikko;
        String luettu = "";
        try {
            Scanner tlukija = new Scanner(tiedosto);
            while (tlukija.hasNextLine()) {
                luettu = tlukija.nextLine();
                System.out.println("luettu: " + luettu);
                if (luettu.equalsIgnoreCase(otsikko)) {
                    System.out.println("löytyi sama eli : " + otsikko);
                    return tiedots; // on etsitty otsikko, palauta edellinen tai tyhjä
                }
                tiedots = luettu; // luettu talteen
            }
            tlukija.close();
            System.out.println("palautetaan tiedost: " + tiedots);
            return tiedots;
        } catch (FileNotFoundException e) {
            System.out.println("lueSeuraava: tiedostokäsittelyvirhe. " + e);
        } catch (NoSuchElementException e) {
            System.out.println("lueSeuraava: tiedostokäsittelyvirhe. no element " + e);
        }
        return tiedots;
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

    public boolean talletaLabelit(File tiedosto, ArrayList labelit) {
        return true;
    }

    public String haeSeuraavaOtsikko(File tiedosto, String otsikko) {
        System.out.println("hae seuraava otsikko. otsikolla: " + otsikko);
        if (onFOlemassa(tiedosto)) {
            return lueSeuraava(tiedosto, otsikko);
        }
        return "Ei ole seuraavaa.";
    }

    public String haeEdellinenOtsikko(File tiedosto, String otsikko) {
        System.out.println("hae edellinen otsikko. otsikolla: " + otsikko);
        if (onFOlemassa(tiedosto)) {
            return lueSeuraava(tiedosto, otsikko);
        }
        return "Ei ole seuraavaa.";
    }

    public String haeKaikkiStringiin(File tiedosto) {
        return lueStringiin(tiedosto);
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

    public String lueStringiin(File tiedosto) {
        Scanner tlukija = null;
        StringBuilder string = new StringBuilder();
        try {
            tlukija = new Scanner(tiedosto);
            while (tlukija.hasNextLine()) {
                string.append(tlukija.nextLine());
                string.append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("tiedostokäsittelyvirhe. getLabelit" + e);
        } catch (NoSuchElementException e) {
            System.out.println("tiedostokäsittelyvirhe. no element getLabelit" + e);
        }
        tlukija.close();
        return string.toString();
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
            if (tiedsis.size() > this.lkm) {
                tiedsis.remove(k);
            }
        }
    }
}
