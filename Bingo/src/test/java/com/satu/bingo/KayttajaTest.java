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
public class KayttajaTest {
    
    public KayttajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
@Test
    public void testKayttajaOk() {
        System.out.println("kayttaja(): parametritön konstruktori");
        Kayttaja instance = new Kayttaja();
        String expResult = "";
        String result = instance.getNimi();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getNimi method, of class Kayttaja.
     */
    @Test
    public void testGetNimi() {
        System.out.println("getNimi");
        Kayttaja instance = new Kayttaja("Mango");
        String expResult = "Mango";
        String result = instance.getNimi();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getSalasana method, of class Kayttaja.
     */
    @Test
    public void testGetSalasana() {
        System.out.println("getSalasana");
        Kayttaja instance = new Kayttaja("Mango" , "koira");
        String expResult = "koira";
        String result = instance.getSalasana();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setSalasana method, of class Kayttaja.
     */
    @Test
    public void testSetSalasana() {
        System.out.println("setSalasana");
        Kayttaja instance = new Kayttaja("Mango");
        String salasana = "koira";
        instance.setSalasana(salasana);
        String expResult = "koira";
        String result = instance.getSalasana();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of tarkistaSalasana method, of class Kayttaja.
     */
    @Test
    public void testTarkistaSalasanaOk() {
        System.out.println("tarkistaSalasana: salasana oikein");
        TiedostoKasittelija tk = new TiedostoKasittelija("Mango");
        File tiedosto = new File("userit.txt");
        tk.lisaaTiedostoon(tiedosto, "Mango koira ");
        Kayttaja instance = new Kayttaja("Mango" , "koira");
        boolean expResult = true;
        boolean result = instance.tarkistaSalasana(tiedosto, "Mango", "koira");
        assertEquals(expResult, result);
        tk.poistaTiedosto(tiedosto);
        
    }
    @Test
    public void testTarkistaSalasanaEiOk() {
        System.out.println("tarkistaSalasana: salasana väärin");
        TiedostoKasittelija tk = new TiedostoKasittelija("Mango");
        File tiedosto = new File("userit.txt");
        tk.lisaaTiedostoon(tiedosto, "Mango koira ");
        Kayttaja instance = new Kayttaja("Mango" , "koira");
        boolean expResult = false;
        boolean result = instance.tarkistaSalasana(tiedosto, "Mango", "kissa");
        assertEquals(expResult, result);
        tk.poistaTiedosto(tiedosto);
        
    }
    
}
