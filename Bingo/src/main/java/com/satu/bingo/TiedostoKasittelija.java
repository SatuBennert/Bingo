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

    private ArrayList<String> tiedsis;
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
        if (tiedosto.exists()) {
            return true;
        }
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
        } 
        return null;
    }

    public String haeEdellinen(File tiedosto, String otsikko) {
        if (onFOlemassa(tiedosto)) {
            lueArrayhin(tiedosto);
            for (int i = 0; i < tiedsis.size(); i++) {
                if (tiedsis.get(i).equalsIgnoreCase(otsikko)) {
                    if (i - 1 < 0) { // jos eka, palauta vika
                        return tiedsis.get(tiedsis.size() - 1);
                    } else { // edellinen
                        return tiedsis.get(i - 1);
                    }
                }
            }
           return tiedsis.get(0); // palauta eka, jos ei löydy
        }
        return "Luo uusi.";
    }

    /**
     * luoF -metodi luo tiedoston
     *
     * @param tiedosto
     * @return true, jos tiedoston luonti onnistui false, jos tiedoston luonti
     * ei onnistunut
     */
    public boolean luoF(File tiedosto) {
        try {
            FileWriter fw = new FileWriter(tiedosto);
            System.out.println("onnistui luoF: " + tiedosto.getName());
        } catch (NullPointerException e) {
            System.out.println("ei onnistunut null luoF: " + tiedosto.getName());
            return false;
        } catch (Exception e) {
            System.out.println("ei onnistunut luoF: " + tiedosto.getName());
            return false;
        }

        return true;
    }

    /**
     * haeLabelit -metodi hakee annetusta tiedostosta merkkijonot bingon
     * sarakkeiden otsikoiksi
     *
     * @param tiedosto josta tiedot haetaan
     * @return yksiulottisen taulukon, jossa on toivottu määrä merkkijonoja
     */
    public String[] haeLabelit(File tiedosto) {
        if (onFOlemassa(tiedosto)) {
            lueArrayhin(tiedosto);
            lueTauluun();
        }
        return labelit;
    }

    public void talletaBingoOtsikko(File tiedosto, String otsikko) {
        if (onFOlemassa(tiedosto)) {
            if (!onOtsikkoOlemassa(tiedosto, otsikko)) {
                lisaaTiedostoon(tiedosto, otsikko + "\n");
            }
        }
    }

    public boolean poistaTiedosto(File tiedosto) {
        if (onFOlemassa(tiedosto)) {
            return tiedosto.delete();
        }
        return false;
    }
    /**
     * postaBingoOtsikko -lukee parametrinä annetun tiedoston Arrayhin onOtsikkoOlemassa -metodissa ja
     * luo uuden strigin siten, että uuteen stringiin ei oteta mukaan parametrina annettua otsikkoa
     * (sekin on string). talletaTiedostoon -metodi päivittää uuden stringin sisällön tiedostoon.
     * @param tiedosto mistä luetaan
     * @param otsikko mikä jätetään uuden tiedoston ulkopuolelle
     */

    public void poistaBingoOtsikko(File tiedosto, String otsikko) {
        StringBuilder string = new StringBuilder();
        if (onFOlemassa(tiedosto)) {
            if (onOtsikkoOlemassa(tiedosto, otsikko)) {
                                for (int i = 0; i < tiedsis.size(); i++) {
                    if (!tiedsis.get(i).equalsIgnoreCase(otsikko)) {
                        string.append(tiedsis.get(i));
                        string.append("\n");
                    }
                }
                                talletaTiedosto(tiedosto, string.toString());
            }
        }
    }

    public boolean onOtsikkoOlemassa(File tiedosto, String otsikko) {
        lueArrayhin(tiedosto);
        for (int i = 0; i < tiedsis.size(); i++) {
            if (tiedsis.get(i).equalsIgnoreCase(otsikko)) {
                return true;
            }
        }
        return false;
    }

    public void lisaaTiedostoon(File tiedosto, String tieto) {
        try {
            FileWriter f = new FileWriter(tiedosto, true);
            f.write(tieto);
            f.close();
        } catch (IOException e) {
            System.out.println("lisääTiedostoon: Tiedoston sulkuongelmia. " + e);
        } catch (Exception e) {
            System.out.println("lisääTiedostoon: Tiedosto-ongelmia. " + e);
        }
    }

    public void talletaTiedosto(File tiedosto, String labelit) {
        if (!onFOlemassa(tiedosto)) {
            luoF(tiedosto);
        }
        korvaaTiedosto(tiedosto, labelit);
    }

    public void korvaaTiedosto(File tiedosto, String tieto) {
        try {
            FileWriter f = new FileWriter(tiedosto);
            f.write(tieto);
            f.close();
        } catch (IOException e) {
            System.out.println("korvaaTiedosto: Tiedoston sulkuongelmia. " + e);
        } catch (Exception e) {
            System.out.println("kovaaTiedosto: Tiedosto-ongelmia. " + e);
        }
    }

    /**
     * haeSeuraava -metodi palauttaa otsikko -parametriä seuraavan
     * teksitiedoston rivin
     *
     * Lähtöoletus: tiedosto on olemassa, mutta voi olla tyhjä
     *
     * @param tiedosto, josta haetaan
     *
     * @param otsikko, rivi, jonka arvosta seuraava rivi palautetaan * @return
     * seuraavan otsikon arvo tai eka, jos seuraava olisi yli tiedoston tai eka,
     * jos ei löydy annettua riviä tai vakio, jos ongelmia
     * @return merkkijono, jossa seuraavan rivin arvo
     */
    public String haeSeuraava(File tiedosto, String otsikko) {
        if (onFOlemassa(tiedosto)) {
            lueArrayhin(tiedosto);
                        for (int i = 0; i < tiedsis.size(); i++) {
                if (tiedsis.get(i).equalsIgnoreCase(otsikko)) {
                    if (i + 1 > tiedsis.size() - 1) { // viimeinen?
                        return tiedsis.get(0); // palauta eka
                    } else {
                        return tiedsis.get(i + 1); // palauta seuraava
                    }
                }
            }
            return tiedsis.get(0); // palauta eka, jos ei löydy
        }
        return "Luo uusi.";
    }

    public String haeKaikkiStringiin(File tiedosto) {
        StringBuilder string = new StringBuilder();
        if (onFOlemassa(tiedosto)) {
            lueArrayhin(tiedosto);
            for (String rivi : tiedsis) {
                string.append(rivi);
                string.append("\n");
            }
        }
        return string.toString();
    }

    /**
     * lueArrayhin -metodi hakee teksitiedostosta kaikki rivit
     * vaihtuvamittaiseen Array -muuttujaan
     *
     * @param tiedosto tekstitiedosto
     */
    public void lueArrayhin(File tiedosto) {
        tiedsis = new ArrayList<>();
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
     * lueTauluun -metodi siirtää vaihtuvamittaisesta Array-muuttujasta
     * merkkijonoja sattumanvaraisesti siten, että jos merkkijonoja on yli
     * taulun koon, niin samaa ei käytetä kahdesti ja jos merkkijonoja on alle
     * taulun koon, niin samoja käytetään useamman kerran. Näin pelattava Bingo
     * on joka kerta eri näköinen. ongelma: nimet pitää olla unique, koska nimi
     * yksilöi painetun napin
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
