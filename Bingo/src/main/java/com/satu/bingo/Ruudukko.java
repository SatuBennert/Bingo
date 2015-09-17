/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satu.bingo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author bensatu
 */
public class Ruudukko extends JFrame implements ActionListener {

    // tekstikentat:
    private JTextField tulostuskentta;
    private String[] etiketit = new String[3];

    // painikkeet:
    private JButton nappi00, nappi01, nappi02, nappi10, nappi11, nappi12, nappi20, nappi21, nappi22;
    // private ActionListener listener;

    // Bingopohjassa pidetään yllä valittuja ruutuja  
    Bingopohja uusiBingo = new Bingopohja();

    public Ruudukko(String[] labelit) {
        for (int i = 0; i < labelit.length; i++) {
            System.out.println(labelit[i]);
            etiketit[i] = labelit[i];

        }
// BorderLayout mahdollistaa 'ilmansuuntien' kayton layoutia suunniteltaessa:
        this.setLayout(new BorderLayout());

// koko ja taustan vari:
        this.setBackground(Color.green);

// luodaan ylin paneeli: 
        JPanel lukuPaneeli = new JPanel();
        lukuPaneeli.setLayout(new FlowLayout());
        lukuPaneeli.setBackground(Color.white);
        this.add(lukuPaneeli, "North");
// kayttoliittymakomponenttien luonti ja niiden liittaminen paneeliin:
        // JLabel arvosanaotsikko = new JLabel("Arvosana");
        // arvosanaotsikko.setForeground(Color.white);
        // lukuPaneeli.add(arvosanaotsikko);
        // arvosanakentta = new JTextField("", 1);
        // arvosanakentta.setBackground(Color.white);
        // lukuPaneeli.add(arvosanakentta);

// bingopelipaneeli:
        JPanel nappiPaneeli1 = new JPanel();
        nappiPaneeli1.setLayout(new FlowLayout());
        nappiPaneeli1.setBackground(Color.pink);

// sen komponentit
        //     nappi00 = new JButton("00");
        nappi00 = new JButton(etiketit[0]);
        nappi01 = new JButton(etiketit[1]);
        nappi02 = new JButton(etiketit[2]);

        nappiPaneeli1.add(nappi00);
        nappiPaneeli1.add(nappi01);
        nappiPaneeli1.add(nappi02);

        this.add(nappiPaneeli1, "North");
        // bingopelipaneeli:
        JPanel nappiPaneeli2 = new JPanel();
        nappiPaneeli2.setLayout(new FlowLayout());

        nappiPaneeli2.setBackground(Color.pink);

// sen komponentit
        nappi10 = new JButton("10");
        nappi11 = new JButton("11");
        nappi12 = new JButton("12");

        nappiPaneeli2.add(nappi10);
        nappiPaneeli2.add(nappi11);
        nappiPaneeli2.add(nappi12);

        this.add(nappiPaneeli2);

        // bingopelipaneeli:
        JPanel nappiPaneeli3 = new JPanel();
        nappiPaneeli3.setLayout(new FlowLayout());
        nappiPaneeli3.setBackground(Color.pink);

// sen komponentit
        nappi20 = new JButton("20");
        nappi21 = new JButton("21");
        nappi22 = new JButton("22");

        nappiPaneeli3.add(nappi20);
        nappiPaneeli3.add(nappi21);
        nappiPaneeli3.add(nappi22);
        // tulostusrivi
        tulostuskentta = new JTextField("paina nappia", 20);
        nappiPaneeli3.add(tulostuskentta);
        this.add(nappiPaneeli3, "South");

// kuuntelijat:
        nappi00.addActionListener(this);
        nappi01.addActionListener(this);
        nappi02.addActionListener(this);
        nappi10.addActionListener(this);
        nappi11.addActionListener(this);
        nappi12.addActionListener(this);
        nappi20.addActionListener(this);
        nappi21.addActionListener(this);
        nappi22.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
// Tanne tullaan, kun kuuntelijat havaitsevat tapahtuman
        System.out.println("action performed alkaa: ");
        // String nimike = "00";
        // System.out.println("eka etiketti" + etiketit[0]);
        if (e.getActionCommand().equals(etiketit[0])) {
            // tallenna tieto, mitä painettu 
            boolean ok = uusiBingo.muutaMerkki(0, 0, 'X');
            // lukitse nappi, ettei voi valita uudelleen
            nappi00.removeActionListener(this);
            // esitä värillä, että on lukittu
            nappi00.setBackground(Color.red);
        }
        if (e.getActionCommand().equals(etiketit[1])) {
            boolean ok = uusiBingo.muutaMerkki(0, 1, 'X');
            nappi01.removeActionListener(this);
            nappi01.setBackground(Color.red);

        }
        if (e.getActionCommand().equals(etiketit[2])) {
            boolean ok = uusiBingo.muutaMerkki(0, 2, 'X');
            nappi02.removeActionListener(this);
            nappi02.setBackground(Color.red);
        }
        if (e.getActionCommand().equals("10")) {
            boolean ok = uusiBingo.muutaMerkki(1, 0, 'X');
            nappi10.removeActionListener(this);
            nappi10.setBackground(Color.red);

        }
        if (e.getActionCommand().equals("11")) {
            boolean ok = uusiBingo.muutaMerkki(1, 1, 'X');
            nappi11.removeActionListener(this);
            nappi11.setBackground(Color.red);

        }
        if (e.getActionCommand().equals("12")) {
            boolean ok = uusiBingo.muutaMerkki(1, 2, 'X');
            nappi12.removeActionListener(this);
            nappi12.setBackground(Color.red);
        }

        if (e.getActionCommand().equals("20")) {
            boolean ok = uusiBingo.muutaMerkki(2, 0, 'X');
            nappi20.removeActionListener(this);
            nappi20.setBackground(Color.red);

        }

        if (e.getActionCommand().equals("21")) {
            boolean ok = uusiBingo.muutaMerkki(2, 1, 'X');
            nappi21.removeActionListener(this);
            nappi21.setBackground(Color.red);

        }

        if (e.getActionCommand().equals("22")) {
            boolean ok = uusiBingo.muutaMerkki(2, 2, 'X');
            nappi22.removeActionListener(this);
            nappi22.setBackground(Color.red);
        }

        // piirtäminen välivaihe ohjelmanteossa
        uusiBingo.piirra();
        // tarkistus yms. logiikka pitää siirtää PaaOhjelmaan.... 
        // tarkista, onko bingo
        char voittaja = ' ';
        if (uusiBingo.taulukkoVoittaja() != voittaja) {
            tulostuskentta.setText("B I N G O !!!");
        }
        repaint();
    } // actionPerformed-end

    public void gui() {
        System.out.println("ruudukko luotu");
        this.pack();
        this.setTitle("Bingo-otus");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
} // class-ruudukko-end
