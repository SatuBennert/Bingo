/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satu.bingo;

import com.satu.bingo.TiedostoKasittelija;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author bensatu
 */
public class TiedostoKasittelijaTest {

//    private String user = "Mango"; // käyttäjä
//    private String otsikko = "golfbingo";
    public TiedostoKasittelijaTest() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        // ennen testiä tehtävät asiat
        // testiä varten luodaan tiedostot, jotka poistetaan testin jälkeen
        //          - otsikkotiedosto yksiots.txt, jossa 3 labelia 
        //          - viisitoistaots.txt, jossa 15 labelia. 
        //          - label.txt sisältää em. bingot eli yksi ja viisitoista
        //          - userit.txt sisältää käyttäjän Mango salasanalla koira
        File yksiots = new File("yksiots.txt");
        File viisitoistaots = new File("viisitoistaots.txt");
        File userit = new File("userit.txt");
        File bingootsikko = new File("label.txt");
        TiedostoKasittelija tika = new TiedostoKasittelija(9);
        tika.luoF(yksiots);
        tika.luoF(viisitoistaots);
        tika.luoF(userit);
        tika.luoF(bingootsikko);
        tika.talletaBingoOtsikko(bingootsikko, "yksiots");
        tika.talletaBingoOtsikko(bingootsikko, "kaksi");
        tika.talletaBingoOtsikko(bingootsikko, "viisitoistaots");
        tika.lisaaTiedostoon(yksiots, "eka");
        tika.lisaaTiedostoon(viisitoistaots, "1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15");
        tika.lisaaTiedostoon(userit, "Mango koira");

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        TiedostoKasittelija tika = new TiedostoKasittelija(9);
        File yksi = new File("yksiots.txt");
        File viisitoista = new File("viisitoistaots.txt");
        File userit = new File("userit.txt");
        File label = new File("label.txt");
        boolean o = tika.poistaTiedosto(yksi);
        boolean p = tika.poistaTiedosto(viisitoista);
        boolean g = tika.poistaTiedosto(userit);
        boolean r = tika.poistaTiedosto(label);
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
//         testin jälkeen tehtävät asiat

    }

    /**
     * Test of onkoFOlemassa method, of class TiedostoKasittelija.
     */
    @Test
    public void testOnFOlemassaOk() {
        // luo tiedosto ensin, testaa ja poista. tämä on ok.
        System.out.println("onFOlemassa. ok.");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        File huuhaa = new File("huuhaa.txt");
        instance.luoF(huuhaa);
        boolean expResult = true;
        boolean result = instance.onFOlemassa(huuhaa);
        assertEquals(expResult, result);
        boolean poistettu = instance.poistaTiedosto(huuhaa);
    }

    @Test
    public void testOnFOlemassaEiOk() {
        // tiedostoa ei ole olemassa
        System.out.println("onkoFOlemassa. tiedostoa ei ole.");
        File f2 = new File("f2");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        boolean expResult = false;
        boolean result = instance.onFOlemassa(f2);
        assertEquals(expResult, result);

    }

    @Test
    public void testTiedostoKasittelijakonstruktoriUser() {
        System.out.println("TiedostoKasittelija(user). user = Mango");
        TiedostoKasittelija instance = new TiedostoKasittelija("Mango");

    }

    @Test
    public void testTiedostoKasittelijakonstruktoriLkm() {
        System.out.println("TiedostoKasittelija(lkm). lkm = 9");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);

    }

    /**
     * Test of haeLabelit method, of class TiedostoKasittelija.
     */
    @Test
    public void testHaeLabelitTiedostolyhytOk() {
        System.out.println("haeLabelit: tiedostossa 1, taulukossa 9.");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        File tiedosto = new File("yksilabel.txt");
        String[] result = instance.haeLabelit(tiedosto);
        System.out.println("labelien lkm: " + result.length);
        for (String result1 : result) {
            System.out.println(result1);
            if (result1.equalsIgnoreCase("")) {
                fail("testHaeLabelit epäonnistui. Labelit tyhjä.");
            }
        }

    }

    @Test
    public void testHaeLabelitTiedostoPitkaOk() {
        System.out.println("haeLabelit: tiedostossa 15, taulukossa 9.");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        File tiedosto = new File("viisitoistaots.txt");
        String[] result = instance.haeLabelit(tiedosto);
        System.out.println("labelien lkm: " + result.length);
        for (String result1 : result) {
            System.out.println(result1);
            if (result1.equalsIgnoreCase("")) {
                fail("testHaeLabelitTiedostoPitkaOk epäonnistui. Labelit tyhjä.");
            }
        }

    }

    @Test
    public void testHaeLabelitTiedostoVirhe() {
        System.out.println("haeLabelit: tiedostoa ei ole.");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        File tiedosto = new File("eiole.txt");
        String[] result = instance.haeLabelit(tiedosto);
        System.out.println("labelien lkm: " + result.length);
        for (String result1 : result) {
            System.out.println(result1);
            if (result1.equalsIgnoreCase("")) {
                fail("testHaeLabelitTiedostoVirhe epäonnistui. Labelit blanco.");
            }
        }
    }

    /**
     * Test of haeSalasana method, of class TiedostoKasittelija.
     */
    @Test
    public void testHaeSalasanaOk() {
        System.out.println("haeSalasana: Mango koira. on ok.");
        File tiedosto = new File("userit.txt");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        String expResult = "koira";
        String result = instance.haeSalasana(tiedosto, "Mango");
        assertEquals(expResult, result);
    }

    @Test
    public void testHaeSalasanaEiLoydyUser() {
        System.out.println("haeSalasanaEiLoydyUser: Rontti koira. Ronttia ei ole.");
        File tiedosto = new File("userit.txt");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        String expResult = null;
        String result = instance.haeSalasana(tiedosto, "Rontti");
        assertEquals(expResult, result);
    }

    @Test
    public void testHaeSalasanaEiLoydyTiedosto() {
        System.out.println("haeSalasanaEiLoydyTiedosto: Mango koira.tiedostoa ei ole. ");
        File tiedosto = new File("eiole.txt");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        String expResult = null;
        String result = instance.haeSalasana(tiedosto, "Mango");
        assertEquals(expResult, result);
    }

    /**
     * Test of haeEdellinen method, of class TiedostoKasittelija. Tiedosto on
     * "label.txt" ja siellä rivit yksilabel, kaksi, viistoistalabel.
     *
     */
    @Test
    public void testHaeEdellinenEiTiedostoa() {
        System.out.println("haeEdellinen: tiedostoa ei ole.");
        File tiedosto = new File("eiole.txt");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        String expResult = "Luo uusi.";
        String result = instance.haeEdellinen(tiedosto, "guggenhaim");
        assertEquals(expResult, result);

    }

    @Test
    public void testHaeEdellinenEiHaluttua() {
        System.out.println("haeEdellinen: label.txt ei löydä guggenhaim, pal.ekan.");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        File tiedosto = new File("label.txt");
        String expResult = "yksiots";
        String result = instance.haeEdellinen(tiedosto, "guggenhaim");
        assertEquals(expResult, result);

    }

    @Test
    public void testHaeEdellinenOnHaluttua() {
        System.out.println("haeEdellinen: label.txt, löytyy toinen kaksi ja edellinen yksi.");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        File tiedosto = new File("label.txt");
        String expResult = "yksiots";
        String result = instance.haeEdellinen(tiedosto, "kaksi");
        assertEquals(expResult, result);

    }

    @Test
    public void testHaeEdellinenOnHaluttuOnVika() {
        System.out.println("haeEdellinen: label.txt, löytää vikan, tuo edelllisen.");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        File tiedosto = new File("label.txt");
        String expResult = "kaksi";
        String result = instance.haeEdellinen(tiedosto, "viisitoistaots");
        assertEquals(expResult, result);

    }

    @Test
    public void testHaeEdellinenOnHaluttuOnEkaTuoVikan() {
        System.out.println("haeEdellinen: label.txt, löytyy ekan, tuo vikan.");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        File tiedosto = new File("label.txt");
        String expResult = "viisitoistaots";
        String result = instance.haeEdellinen(tiedosto, "yksiots");
        assertEquals(expResult, result);

    }

    /**
     * Test of luoF method, of class TiedostoKasittelija.
     */
    @Test
    public void testLuoFOk() {
        System.out.println("luoFOk: luo uusi tdsto uusitst.txt");
        File tiedosto = new File("uusitst.txt");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        boolean expResult = true;
        boolean result = instance.luoF(tiedosto);
        assertEquals(expResult, result);
        instance.poistaTiedosto(tiedosto);

    }

//    @Test satu: en saa menemään falseksi 
//    public void testLuoFEiOkOnJoOlemassa() {
//        System.out.println("luoF: luodaan samaa tiedostoa kaksi kertaa");
//        File tiedosto = null; 
//                TiedostoKasittelija instance = new TiedostoKasittelija(9);
//        boolean totuus = instance.luoF(tiedosto); 
//        
//        boolean expResult = false;
//        assertEquals(expResult, result);
//        instance.poistaTiedosto(tiedosto);
//
//    }

    /**
     * Test of talletaBingoOtsikko method, of class TiedostoKasittelija.
     * Tiedosto on "label.txt" ja siellä rivit yksiots, kaksi, viistoistaots.
     */
    @Test
    public void testTalletaBingoOtsikkoOk() {
        System.out.println("talletaBingoOtsikko: lisätään uusibingo");
        File tiedosto = new File("label.txt");
        String otsikko = "uusibingo";
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        instance.talletaBingoOtsikko(tiedosto, otsikko); // lisää
        
        String expResult = "viisitoistaots"; // tuo ekan. jos tallettaisi uudestaan kaksi, toisi viistoistaots
        String result = instance.haeEdellinen(tiedosto, otsikko);
        assertEquals(expResult, result);
        instance.poistaBingoOtsikko(tiedosto, otsikko); // poista
        System.out.println("testin jälkeen: " + instance.haeKaikkiStringiin(tiedosto));
    }

    /**
     *
     */
    @Test
    public void testTalletaBingoOtsikkoOnSama() {
        System.out.println("talletaBingoOtsikkoOnSama: lisätään kaksi uudestaan");
        File tiedosto = new File("Label.txt");
        String otsikko = "kaksi";
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        instance.talletaBingoOtsikko(tiedosto, otsikko);
        String expResult = "Luo uusi."; // tuo ekan. jos tallettaisi uudestaan kaksi, toisi viistoistaots
        String result = instance.haeEdellinen(tiedosto, "kaksi");
        assertEquals(expResult, result);

    }

    /**
     * Test of poistaTiedosto method, of class TiedostoKasittelija.
     */
    @Test
    public void testPoistaTiedostoOk() {
        System.out.println("poistaTiedosto. tdsto on olemassa.");
        File tiedosto = new File("poistettava.txt");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        instance.luoF(tiedosto);
        boolean expResult = true;
        boolean result = instance.poistaTiedosto(tiedosto);
        assertEquals(expResult, result);
    }

    @Test
    public void testPoistaTiedostoEiOleOlemassa() {
        System.out.println("poistaTiedosto. tdsto ei ole olemassa.");
        File tiedosto = new File("poistettava.txt");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        boolean expResult = false;
        boolean result = instance.poistaTiedosto(tiedosto);
        assertEquals(expResult, result);
    }

    /**
     * Test of poistaBingoOtsikko method, of class TiedostoKasittelija. Tiedosto
     * on "label.txt" ja siellä rivit yksiots, kaksi, viistoistaots.
     */
    @Test
    public void testPoistaBingoOtsikkoOk() {
        System.out.println("poistaBingoOtsikko. poista otsikko uusiotsikko");
        File tiedosto = new File("label.txt");
        String otsikko = "uusiotsikko";
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        instance.lisaaTiedostoon(tiedosto, otsikko); // lisää
        instance.poistaBingoOtsikko(tiedosto, otsikko); // poista
        boolean expResult = false;
        boolean result = instance.onOtsikkoOlemassa(tiedosto, otsikko);
        assertEquals(expResult, result);

    }

    /**
     * Test of onOtsikkoOlemassa method, of class TiedostoKasittelija.
     */
    @Test
    public void testOnOtsikkoOlemassaOk() {
        System.out.println("onOtsikkoOlemassa: yksiots");
        File tiedosto = new File("label.txt");
        String otsikko = "yksiots";
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        boolean expResult = true;
        boolean result = instance.onOtsikkoOlemassa(tiedosto, otsikko);
        assertEquals(expResult, result);

    }

    @Test
    public void testOnOtsikkoOlemassaEiOle() {
        System.out.println("onOtsikkoOlemassa: guggenhaim");
        File tiedosto = new File("label.txt");
        String otsikko = "guggenhaim";
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        boolean expResult = false;
        boolean result = instance.onOtsikkoOlemassa(tiedosto, otsikko);
        assertEquals(expResult, result);

    }

    /**
     * Test of lisaaTiedostoon method, of class TiedostoKasittelija. oisko
     * testattu jo talletaBingoOtsikko -kohdassa?? satu
     */
//    @Test
//    public void testLisaaTiedostoonOk() {
//        System.out.println("lisaaTiedostoon");
//        File tiedosto = null;
//        String tieto = "bingotest";
//        TiedostoKasittelija instance = new TiedostoKasittelija(9);
//        instance.lisaaTiedostoon(yksi, tieto);
//
//    }
//
//    @Test
//    public void testLisaaTiedostoonTiedostoaEiOle() {
//        System.out.println("lisaaTiedostoon, kun tiedostoa ei ole");
//        File tiedosto = null;
//        String tieto = "bingotest2";
//        TiedostoKasittelija instance = new TiedostoKasittelija(9);
//        instance.lisaaTiedostoon(tiedostoeiole, tieto);
//
//    }
    /**
     * Test of talletaTiedosto method, of class TiedostoKasittelija. satu: oisko
     * testattu jo poistaBingoOtsikko -kohdassa
     */
//    @Test
//    public void testTalletaTiedosto() {
//        System.out.println("talletaTiedosto");
//        File tiedosto = null;
//        String labelit = "";
//        TiedostoKasittelija instance = null;
//        instance.talletaTiedosto(tiedosto, labelit);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of korvaaTiedosto method, of class TiedostoKasittelija. satu: oisko
     * testattu jo talletaBingoOtsikko -kohdassa
     */
//    @Test
//    public void testKorvaaTiedosto() {
//        System.out.println("korvaaTiedosto");
//        File tiedosto = null;
//        String tieto = "";
//        TiedostoKasittelija instance = null;
//        instance.korvaaTiedosto(tiedosto, tieto);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of haeSeuraava method, of class TiedostoKasittelija. * Tiedosto on
     * "label.txt" ja siellä rivit yksiots, kaksi, viistoistaots.
     */
    @Test
    public void testHaeSeuraavaOk() {
        System.out.println("haeSeuraava: label.txt, on eka, tuo tokan");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        File tiedosto = new File("label.txt");
        String otsikko = "yksiots";
        String expResult = "kaksi";
        String result = instance.haeSeuraava(tiedosto, otsikko);
        assertEquals(expResult, result);

    }

    @Test
    public void testHaeSeuraavaOkOnVikaTuoEkan() {
        System.out.println("haeSeuraava: label.txt, on vika, tuo ekan");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        File tiedosto = new File("label.txt");
        String otsikko = "viisitoistaots";
        String expResult = "yksiots";
        String result = instance.haeSeuraava(tiedosto, otsikko);
        assertEquals(expResult, result);

    }

    @Test
    public void testHaeSeuraavaOkOnTokaTuoEkan() {
        System.out.println("haeSeuraava: label.txt, on toka, tuo vikan");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        File tiedosto = new File("label.txt");
        String otsikko = "kaksi";
        String expResult = "viisitoistaots";
        String result = instance.haeSeuraava(tiedosto, otsikko);
        assertEquals(expResult, result);

    }
    @Test
    public void testHaeSeuraavaEiTiedostoa() {
        System.out.println("haeSeuraava: eiole.txt, tuo Luo uusi.");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        File tiedosto = new File("eiole.txt");
        String otsikko = "kaksi";
        String expResult = "Luo uusi.";
        String result = instance.haeSeuraava(tiedosto, otsikko);
        assertEquals(expResult, result);

    }
    @Test
    public void testHaeSeuraavaEiOleOtsikkoa() {
        System.out.println("haeSeuraava: label.txt, ei ole ots, tuo ekan.");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        File tiedosto = new File("eiole.txt");
        String otsikko = "joopajoo";
        String expResult = "Luo uusi.";
        String result = instance.haeSeuraava(tiedosto, otsikko);
        assertEquals(expResult, result);

    }


    /**
     * Test of haeKaikkiStringiin method, of class TiedostoKasittelija.
     */
    @Test
    public void testHaeKaikkiStringiin() {
        System.out.println("haeKaikkiStringiin");
        File tiedosto = new File("label.txt");
        TiedostoKasittelija instance = new TiedostoKasittelija(9);
        String expResult = "yksiots\nkaksi\nviisitoistaots\n";
        String result = instance.haeKaikkiStringiin(tiedosto);
        assertEquals(expResult, result);
        System.out.println(expResult);
    }

    /**
     * LueArrayhin method testattu kutsuvan metodin kautta, ei omaa testiä
     *
     * @Test public void testLueArrayhin() {
     *
     * System.out.println("lueArrayhin"); TiedostoKasittelija instance = new
     * TiedostoKasittelija(); instance.lueArrayhin(tiedostoeiole);
     *
     * }
     */
    /**
     * lueTauluun method testattu kutsuvan metodin kautta, ei omaa testiä
     *
     * @Test public void testLueTauluun() { System.out.println("lueTauluun");
     * TiedostoKasittelija instance = new TiedostoKasittelija();
     * instance.lueTauluun(); // TODO review the generated test code and remove
     * the default call to fail. fail("The test case is a prototype."); }
     */
}
