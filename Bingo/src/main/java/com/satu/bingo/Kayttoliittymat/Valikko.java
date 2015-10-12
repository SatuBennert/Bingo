/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satu.bingo.Kayttoliittymat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        JButton bingo = new JButton("bingo");
        menuPaneeli.add(login);
        menuPaneeli.add(bingo);
        frame.add(menuPaneeli, "North");

        login.addActionListener(this);
        bingo.addActionListener(this);

    }

    public void gui() {
        frame.pack();
        frame.setTitle("Bingo-otus");
        frame.setBackground(Color.pink);
        frame.setVisible(true);
//        frame.setSize(3000, 2000); demo
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("log in")) {
            Kirjautuminen k = new Kirjautuminen();
            k.gui();
        }

        if (e.getActionCommand().equals("bingo")) {
            BingoYllapito ty = new BingoYllapito();
            ty.gui();
        }

        frame.repaint();
    } // actionPerformed-end
}
