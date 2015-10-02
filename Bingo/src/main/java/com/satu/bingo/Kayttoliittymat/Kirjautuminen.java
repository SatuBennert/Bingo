/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satu.bingo.Kayttoliittymat;

import com.satu.bingo.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author bensatu
 */
public class Kirjautuminen implements ActionListener {

    private JTextField nimi, salasana, tiedote;
    private JFrame frame;

    public Kirjautuminen() {
        frame = new JFrame();
        frame.setLayout(new GridLayout(1, 4));
        JPanel userPaneeli = new JPanel();
        userPaneeli.setBackground(Color.pink);
        nimi = new JTextField("tunnus", 20);
        salasana = new JTextField("salasana", 20);
        tiedote = new JTextField(20);
        tiedote.setBackground(Color.pink);
        tiedote.setBorder(null);
        JButton tarkista = new JButton("tarkista salasana");
        userPaneeli.add(nimi);
        userPaneeli.add(salasana);
        userPaneeli.add(tarkista);
        userPaneeli.add(tiedote);
        frame.add(userPaneeli, "North");
        tarkista.addActionListener(this);
    }

    public void gui() {
        frame.pack();
//        frame.setTitle("Bingo-otus");
        frame.setVisible(true);
        frame.setSize(300, 400);
//        /*frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
    }

    static boolean tarkistaKayttaja(String user, String salasana) {
        Kayttaja kayttaja = new Kayttaja(user);
        if (kayttaja.tarkistaSalasana(user, salasana)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("tarkista salasana")) {
            if (tarkistaKayttaja(nimi.getText(), salasana.getText())) {
                tiedote.setText("Salasana ok.");
                salasana.setText("");
                frame.dispose();
            } else {
                tiedote.setText("Salasana ei kelpaa. Syötä uusi.");
            }
        }
        frame.repaint();
    } // actionPerformed-end

}
