/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satu.bingo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bensatu
 */
public class BingopohjaTest {

    public BingopohjaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMuutaMerkki_arvot_OK() {
        System.out.println("muutaMerkki");
        int rivi = 1;
        int sarake = 1;
        char merkki = 'O';
        Bingopohja instance = new Bingopohja();
        boolean expResult = true;
        boolean result = instance.muutaMerkki(rivi, sarake, merkki);
        System.out.println(" tulos: " + result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    @Test
    public void testMuutaMerkki_ind1_alle_nolla() {
        System.out.println("muutaMerkki");
        int rivi = -1;
        int sarake = 1;
        char merkki = 'O';
        Bingopohja instance = new Bingopohja();
        boolean expResult = false;
        boolean result = instance.muutaMerkki(rivi, sarake, merkki);
        System.out.println(" tulos: " + result);
        assertEquals(expResult, result);

    }

    @Test
    public void testMuutaMerkki_ind1_yli() {
        System.out.println("muutaMerkki");
        int rivi = 100;
        int sarake = 1;
        char merkki = 'O';
        Bingopohja instance = new Bingopohja();
        boolean expResult = false;
        boolean result = instance.muutaMerkki(rivi, sarake, merkki);
        System.out.println(" tulos: " + result);
        assertEquals(expResult, result);

    }

    @Test
    public void testMuutaMerkki_ind2_alle_nolla() {
        System.out.println("muutaMerkki");
        int rivi = 1;
        int sarake = -1;
        char merkki = 'O';
        Bingopohja instance = new Bingopohja();
        boolean expResult = false;
        boolean result = instance.muutaMerkki(rivi, sarake, merkki);
        System.out.println(" tulos: " + result);
        assertEquals(expResult, result);

    }

    @Test
    public void testMuutaMerkki_ind2_yli() {
        System.out.println("muutaMerkki");
        int rivi = 1;
        int sarake = 100;
        char merkki = 'O';
        Bingopohja instance = new Bingopohja();
        boolean expResult = false;
        boolean result = instance.muutaMerkki(rivi, sarake, merkki);
        System.out.println(" tulos: " + result);
        assertEquals(expResult, result);

    }

    @Test
    public void testMuutaMerkki_merkki_on_nro() {
        System.out.println("muutaMerkki");
        int rivi = 1;
        int sarake = 1;
        char merkki = '6';
        Bingopohja instance = new Bingopohja();
        boolean expResult = true;
        boolean result = instance.muutaMerkki(rivi, sarake, merkki);
        System.out.println(" tulos: " + result);
        assertEquals(expResult, result);

    }

    @Test
    public void testMuutaMerkki_merkki_on_tyhja() {
        System.out.println("muutaMerkki");
        int rivi = 1;
        int sarake = 1;
        char merkki = ' ';
        Bingopohja instance = new Bingopohja();
        boolean expResult = true;
        boolean result = instance.muutaMerkki(rivi, sarake, merkki);
        System.out.println(" tulos: " + result);
        assertEquals(expResult, result);

    }

    /**
     * Test of onBingo method, of class Bingopohja.
     */
    @Test
    public void testOnBingo() {
        System.out.println("onBingo");
        Bingopohja instance = new Bingopohja();
        boolean expResult = false;
        boolean result = instance.onBingo();
        assertEquals(expResult, result);
    }

    /**
     * Test of onPystyBingo method, of class Bingopohja.
     */
    @Test
    public void testOnPystyBingoTyhjalla() {
        System.out.println("onPystyBingoTyhjällä");
        Bingopohja instance = new Bingopohja();
        boolean expResult = false;
        boolean result = instance.onPystyBingo();
        assertEquals(expResult, result);
    }

    @Test
    public void testOnPystyBingoOk() {
        System.out.println("onPystyBingoOk");
        Bingopohja instance = new Bingopohja();
        for (int i = 0; i < 5; i++) {
            instance.muutaMerkki(i, 3, 'X');
        }
        instance.piirra();
        boolean expResult = true;
        boolean result = instance.onPystyBingo();
        assertEquals(expResult, result);
    }

    @Test
    public void testOnPystyBingoVaakalla() {
        System.out.println("onPystyBingoVaakalla");
        Bingopohja instance = new Bingopohja();
        for (int i = 0; i < 5; i++) {
            instance.muutaMerkki(2, i, 'X');
        }
        instance.piirra();
        boolean expResult = false;
        boolean result = instance.onPystyBingo();
        assertEquals(expResult, result);
    }

    /**
     * Test of onVaakaBingo method, of class Bingopohja.
     */
    @Test
    public void testOnVaakaBingoTyhjalla() {
        System.out.println("onVaakaBingoTyhjalla");
        Bingopohja instance = new Bingopohja();
        boolean expResult = false;
        boolean result = instance.onVaakaBingo();
        assertEquals(expResult, result);

    }

    @Test
    public void testOnVaakaBingoOk() {
        System.out.println("onVaakaBingoOk");
        Bingopohja instance = new Bingopohja();
        for (int i = 0; i < 5; i++) {
            instance.muutaMerkki(3, i, 'X');
        }
        instance.piirra();
        boolean expResult = true;
        boolean result = instance.onVaakaBingo();
        assertEquals(expResult, result);
    }

    @Test
    public void testOnVaakaBingoPystyllä() {
        System.out.println("onVaakaBingoPystyllä");
        Bingopohja instance = new Bingopohja();
        for (int i = 0; i < 5; i++) {
            instance.muutaMerkki(i, 2, 'X');
        }
        instance.piirra();
        boolean expResult = false;
        boolean result = instance.onVaakaBingo();
        assertEquals(expResult, result);
    }

    /**
     * Test of onVino1Bingo method, of class Bingopohja.
     */
    @Test
    public void testOnVino1BingoTyhjalla() {
        System.out.println("onVino1BingoTyhjalla");
        Bingopohja instance = new Bingopohja();
        boolean expResult = false;
        boolean result = instance.onVino1Bingo();
        assertEquals(expResult, result);

    }

    @Test
    public void testOnVino1BingoVaakalla() {
        System.out.println("onVino1BingoVaakalla");
        Bingopohja instance = new Bingopohja();
        for (int i = 0; i < 5; i++) {
            instance.muutaMerkki(2, i, 'X');
        }
        instance.piirra();
        boolean expResult = false;
        boolean result = instance.onVino1Bingo();
        assertEquals(expResult, result);

    }

    @Test
    public void testOnVino1BingoOk() {
        System.out.println("onVino1Bingook");
        Bingopohja instance = new Bingopohja();
        for (int i = 0; i < 5; i++) {
            instance.muutaMerkki(i, i, 'X');
        }
        instance.piirra();
        boolean expResult = true;
        boolean result = instance.onVino1Bingo();
        assertEquals(expResult, result);

    }

    /**
     * Test of onVino2Bingo method, of class Bingopohja.
     */
    @Test
    public void testOnVino2BingoTyhjalla() {
        System.out.println("onVino2BingoTyhjalla");
        Bingopohja instance = new Bingopohja();
        boolean expResult = false;
        boolean result = instance.onVino2Bingo();
        assertEquals(expResult, result);

    }

    @Test
    public void testOnVino2BingoVaakalla() {
        System.out.println("onVino2BingoVaakalla");
        Bingopohja instance = new Bingopohja();
        for (int i = 0; i < 5; i++) {
            instance.muutaMerkki(2, i, 'X');
        }
        instance.piirra();
        boolean expResult = false;
        boolean result = instance.onVino2Bingo();
        assertEquals(expResult, result);

    }

    @Test
    public void testOnVino2BingoOk() {
        System.out.println("onVino2BingoOk");
        Bingopohja instance = new Bingopohja();
        int kx = 4;
        for (int i = 0; i < 5; i++) {
            instance.muutaMerkki(i, kx, 'X');
            kx--;
        }
        instance.piirra();
        boolean expResult = true;
        boolean result = instance.onVino2Bingo();
        assertEquals(expResult, result);

    }

    /**
     * Test of piirra method, of class Bingopohja.
     */
    @Test
    public void testPiirra() {
        System.out.println("piirra");
        Bingopohja instance = new Bingopohja();
        instance.piirra();

    }

}
