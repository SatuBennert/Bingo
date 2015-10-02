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
    String[] etiketit = new String[25];
    JButton[] napit = new JButton[25];
    private int[][] koordinaatit = new int[25][2];
    int lkmmax = 5;

    // Bingopohjassa pidetään yllä valittuja ruutuja  
    Bingopohja uusiBingo = new Bingopohja();

    public BingoIkkuna(String[] labelit) {

        for (int i = 0; i < labelit.length; i++) {
            System.out.println(labelit[i]);
            etiketit[i] = labelit[i];
        }
        this.setLayout(new GridLayout(5, 5));
//        tulostuskentta = new JTextField(10);
//        this.add(tulostuskentta);

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
                koordinaatit[h][0] = j;
                koordinaatit[h][1] = i;
                h++;
            }
        }
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
            if (e.getActionCommand().
                    equals(etiketit[a])) {
                napit[a].removeActionListener(this);
                napit[a].setBackground(Color.pink);
                uusiBingo.muutaMerkki(koordinaatit[a][1], koordinaatit[a][0], 'X');
                napit[a].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
//                System.out.println("rivi " + koordinaatit[a][1] +  " sara: " + koordinaatit[a][0]);
//                uusiBingo.piirra();
            }
        }
//        if (uusiBingo.onBingo()) {
//            tulostuskentta.setText("B I N G O !!!");
//        }

        repaint();
    } // actionPerformed-end

    public void gui() {
        this.pack();
        this.setTitle("Bingotin");
        this.setVisible(true);
        this.setSize(800, 600);
//        /*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
    }

} // class-end

