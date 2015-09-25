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
     * Test of taulukkoEiTäysi method, of class Bingopohja.
     */
    @Test
    public void testTaulukkoEiTaysi_uusitaulukko() {
        // palauttaa arvon true, jos taulukko ei ole täynnä ja
        // uusi taulukko ei ole koskaan täynnä
        System.out.println("taulukkoEiTaysi");
        Bingopohja instance = new Bingopohja();
        boolean expResult = true;
        boolean result = instance.taulukkoEiTaysi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    @Test
    public void testTaulukkoEiTaysi_taysitaulukko() {
        // laitetaan taulukko täyteen, jolloin palauttaa false
        System.out.println("taulukkoEiTaysi");
        Bingopohja instance = new Bingopohja();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean totuusarvo = instance.muutaMerkki(i, j, 'X');
            }
        }
        boolean expResult = false;
        boolean result = instance.taulukkoEiTaysi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    

    /**
     * Test of taulukkoVoittaja method, of class Bingopohja.
     */
    @Test
    public void testTaulukkoVoittaja() {
        System.out.println("taulukkoVoittaja");
        Bingopohja instance = new Bingopohja();
        char expResult = ' ';
        char result = instance.taulukkoVoittaja();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of piirra method, of class Bingopohja.
     */
    @Test
    public void testPiirra() {
        // tulostuksen testaaminen?
        System.out.println("piirra");
        Bingopohja instance = new Bingopohja();
        instance.piirra();
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

}
