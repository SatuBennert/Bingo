/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satu.bingo;

import java.io.File;
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
public class TiedostoKasittelijaTest {

    private File tiedostolyhyt = new File("bingo.txt");
    private File tiedostopitka = new File("golfbingo.txt");
    private File tiedostoeiole = new File("huuhaa");
    

    public TiedostoKasittelijaTest() {

    }

    /**
     * Test of onkoFOlemassa method, of class TiedostoKasittelija.
     */
    @Test
    public void testOnkoFOlemassaOk() {
        System.out.println("onkoFOlemassa");
        TiedostoKasittelija instance = new TiedostoKasittelija();
        boolean expResult = true;
        boolean result = instance.onkoFOlemassa(tiedostolyhyt);
        assertEquals(expResult, result);

    }
     @Test
    public void testOnkoFOlemassaEiOk() {
        System.out.println("onkoFOlemassa");
        TiedostoKasittelija instance = new TiedostoKasittelija();
        boolean expResult = false;
        boolean result = instance.onkoFOlemassa(tiedostoeiole);
        assertEquals(expResult, result);

    }

    /**
     * Test of luoF method, of class TiedostoKasittelija.
     * luonti ei vielä käytössä
     */
    /* @Test
     public void testLuoF() {
     System.out.println("luoF");
     File tiedosto = null;
     String tiedostonimi = "";
     TiedostoKasittelija instance = new TiedostoKasittelija();
     boolean expResult = false;
     File tiedosto = new File();
     String tiedostonimi = "heippa";
     boolean result = instance.luoF(tiedosto, tiedostonimi);
     assertEquals(expResult, result);
     // TODO review the generated test code and remove the default call to fail.
     fail("The test case is a prototype.");
     } */
    /**
     * Test of haeLabelit method, of class TiedostoKasittelija.
     */
    @Test
    public void testHaeLabelitTiedostolyhytOk() {
        System.out.println("haeLabelit");
        File tiedosto = null;
        TiedostoKasittelija instance = new TiedostoKasittelija();
        String[] result = instance.haeLabelit(tiedostolyhyt);
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
        System.out.println("haeLabelit_tiedostopitkaok");
        File tiedosto = null;
        TiedostoKasittelija instance = new TiedostoKasittelija();
        String[] result = instance.haeLabelit(tiedostopitka);
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
        System.out.println("haeLabelit_tiedostoeiok");
        TiedostoKasittelija instance = new TiedostoKasittelija();
        String[] result = instance.haeLabelit(tiedostoeiole);
        for (String result1 : result) {
            System.out.println(result1);
            if (result1.equalsIgnoreCase("")) {
                fail("testHaeLabelitTiedostoVirhe epäonnistui. Labelit blanco.");
            }
        } 
    }

    /**
     * LueArrayhin method testattu kutsuvan metodin kautta, ei omaa testiä
     * 
    @Test
    public void testLueArrayhin() {
        
        System.out.println("lueArrayhin");
        TiedostoKasittelija instance = new TiedostoKasittelija();
        instance.lueArrayhin(tiedostoeiole);
        
    } */

    /**
     * lueTauluun method testattu kutsuvan metodin kautta, ei omaa testiä
     *
    @Test
    public void testLueTauluun() {
        System.out.println("lueTauluun");
        TiedostoKasittelija instance = new TiedostoKasittelija();
        instance.lueTauluun();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */
}
