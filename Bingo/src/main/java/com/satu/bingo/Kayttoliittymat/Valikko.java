/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satu.bingo.Kayttoliittymat;

import com.satu.bingo.Bingopohja;
import com.satu.bingo.Kayttaja;
import com.satu.bingo.TiedostoKasittelija;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author bensatu
 */
public class Valikko implements ActionListener {

    JFrame frame;

    public Valikko() {
        frame = new JFrame();

        JPanel menuPaneeli = new JPanel();
        menuPaneeli.setBackground(Color.pink);
        JButton login = new JButton("log in");
        JButton pelaa = new JButton("pelaa");
        JButton paivita = new JButton("päivitä bingo");
        menuPaneeli.add(login);
        menuPaneeli.add(pelaa);
        menuPaneeli.add(paivita);
        frame.add(menuPaneeli, "North");
        login.addActionListener(this);
        pelaa.addActionListener(this);
        paivita.addActionListener(this);

//        JPanel keskiPaneeli = new JPanel();
//        JButton paivita = new JButton("päivitä bingo");
//        keskiPaneeli.add(paivita);
//        keskiPaneeli.setSize(500, 500);
//        keskiPaneeli.setBackground(Color.pink);
//        frame.add(keskiPaneeli, "East");
//        paivita.addActionListener(this);
    }

    public void gui() {
        frame.pack();
        frame.setTitle("Bingo-otus");
        frame.setVisible(true);

        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("log in")) {
            Kirjautuminen k = new Kirjautuminen();
            k.gui();
        }
        if (e.getActionCommand().equals("pelaa")) {
            File tiedosto = new File("bingo.txt");
            TiedostoKasittelija tk = new TiedostoKasittelija();
            Bingopohja b = new Bingopohja();
            BingoIkkuna pingoBongo = new BingoIkkuna(tk.haeLabelit(tiedosto));
            pingoBongo.gui();
        }
        if (e.getActionCommand().equals("päivitä bingo")) {
            System.out.println("päivitä");
        }
        frame.repaint();
    } // actionPerformed-end
}
