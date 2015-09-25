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
    JTextField tulostuskentta;
    // metodi actionPerformed tarvitsee etiketteja... 
    String[] etiketit = new String[9];
    JButton[] napit = new JButton[9];
    int[][] koordinaatit = new int[3][3];
    int xk, yk = 0;

    // Bingopohjassa pidetään yllä valittuja ruutuja  
    Bingopohja uusiBingo = new Bingopohja();

    public Ruudukko(String[] labelit) {

        // private ActionListener listener;
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
// bingopelipaneeli:
        JPanel nappiPaneeli1 = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        nappiPaneeli1.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();
        nappiPaneeli1.setBackground(Color.pink);

// sen komponentit
        for (int k = 0; k < 9; k++) {
            // luodaan napit
            napit[k] = new JButton(etiketit[k]);
            // lisätään napit paneeliin
            Component add = nappiPaneeli1.add(napit[k]);
            c.gridx = 0;
            c.gridy = 0;
            gridbag.setConstraints(napit[k], c);
            nappiPaneeli1.add(napit[k]);
            System.out.println("lisäys arvolla" + napit[k]);
        }
        int h = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                c.gridx = i;
                c.gridy = j;
                nappiPaneeli1.add(napit[h], c);
                h++;
                System.out.println("i=" + i + " J=" + j + " h=" + h);
            }

        }

        this.add(nappiPaneeli1, "North");
        // bingopelipaneeli:
        /**
         * * JPanel nappiPaneeli2 = new JPanel(); nappiPaneeli2.setLayout(new
         * FlowLayout());
         *
         * nappiPaneeli2.setBackground(Color.pink); **
         */

// sen komponentit
       /* nappi10 = new JButton("10");
         nappi11 = new JButton("11");
         nappi12 = new JButton("12"); 
         nappiPaneeli2.add(napit[3]);
         nappiPaneeli2.add(napit[4]);
         nappiPaneeli2.add(napit[5]); */
        /**
         * this.add(nappiPaneeli2); *
         */
        // bingopelipaneeli:
        JPanel nappiPaneeli3 = new JPanel();
        nappiPaneeli3.setLayout(new FlowLayout());
        nappiPaneeli3.setBackground(Color.pink);
        tulostuskentta = new JTextField("paina nappia", 20);
        nappiPaneeli3.add(tulostuskentta);
        this.add(nappiPaneeli3, "South");

// kuuntelijat:
        // vinkki: napit ja kuuntelijat omiin metodeihinsa
        for (int k = 0; k < 9; k++) {
            // luodaan napit
            napit[k].addActionListener(this);
            // lisätään napit paneeliin
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
// Tanne tullaan, kun kuuntelijat havaitsevat tapahtuman
        // vinkki: for -luuppi tai HashMap: etiketti avaimena ja nappi arvona?

        System.out.println("action performed alkaa: ");

        for (int a = 0; a < 9; a++) {
            if (e.getActionCommand().equals(etiketit[a])) {
                napit[a].removeActionListener(this);
                napit[a].setBackground(Color.red);
                // bingopohjan koordinaatit? miten saadaan? mitä niillä tehdään?
            }
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
        this.pack();
        this.setTitle("Bingo-otus");
        this.setVisible(true);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

} // class-ruudukko-end
