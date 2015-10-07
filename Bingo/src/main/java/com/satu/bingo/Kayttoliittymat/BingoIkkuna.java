/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satu.bingo.Kayttoliittymat;

import com.satu.bingo.Bingopohja;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author bensatu
 */
public class BingoIkkuna extends JFrame implements ActionListener {

    JTextField tulostuskentta;
    String[] etiketit;
    JButton[] napit;
    private int[][] koordinaatit;
    int lkmmax;
    // Bingopohjassa pidetään yllä valittuja ruutuja 
    Bingopohja uusiBingo;

    public BingoIkkuna(String[] labelit, int lkmmax) {

        napit = new JButton[labelit.length];
        this.lkmmax = lkmmax;
        koordinaatit = new int[labelit.length][2];
        etiketit = new String[labelit.length];
        System.arraycopy(labelit, 0, etiketit, 0, labelit.length);
        this.setLayout(new GridLayout(lkmmax, lkmmax));
//    	tulostuskentta = new JTextField(10);
//    	this.add(tulostuskentta);
// luodaan niin monta nappia kuin on taulukossa tietoja
        for (int k = 0; k < etiketit.length; k++) {
            napit[k] = new JButton(etiketit[k]);
            napit[k].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        }
        // lisätään napit taulukkoon ja otetaan koordinaatit (rivi, sarake) talteen
        int h = 0;
        for (int i = 0; i < lkmmax; i++) {
            for (int j = 0; j < lkmmax; j++) {
                this.add(napit[h]);
                koordinaatit[h][0] = i;
                koordinaatit[h][1] = j;
                h++;
            }
        }
        uusiBingo = new Bingopohja(lkmmax, koordinaatit);
        lisaaKuuntelijat();
    }

    private void lisaaKuuntelijat() {
        for (int k = 0; k < etiketit.length; k++) {
            napit[k].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int a = 0; a < etiketit.length; a++) {
            // satu sama label: ottaa kaikki samat labelit kerralla.
            if (e.getActionCommand().equals(etiketit[a])) {
                napit[a].removeActionListener(this);
//            	napit[a].setBackground(Color.pink);
                uusiBingo.muutaMerkki(koordinaatit[a][0], koordinaatit[a][1], 'X');
                napit[a].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            }
        }
        if (uusiBingo.onBingo()) {
            for (int b = 0; b < etiketit.length; b++) {
                if (' ' != (uusiBingo.getBingonapit()[b])) {
                    napit[b].setBackground(Color.RED);
                }
            }
        }
        repaint();
    } // actionPerformed-end

    public void gui() {
        this.pack();
        this.setTitle("Bingotin");
        this.setVisible(true);
        this.setSize(800, 600);
//    	/*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
    }
} // class-end

