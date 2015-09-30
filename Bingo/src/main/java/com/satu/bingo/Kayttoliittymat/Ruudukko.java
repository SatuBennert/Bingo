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
    JTextField nimi;
    JTextField salasana;
    JButton tarkista;
    // metodi actionPerformed tarvitsee etiketteja... 
    String[] etiketit = new String[25];
    JButton[] napit = new JButton[25];
    private int[][] koordinaatit = new int[25][2];
    int xk, yk = 0;
    int lkmmax = 5;

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

// bingopelipaneeli:
        JPanel bingoPaneeli = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        bingoPaneeli.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();
        bingoPaneeli.setBackground(Color.pink);

// luodaan niin monta nappia kuin on taulukossa tietoja 
        for (int k = 0; k < etiketit.length; k++) {
            napit[k] = new JButton(etiketit[k]);
        }
// laitetaan napit taulukon muotoon ja otetaan koordinaatit talteen
        int h = 0;
        for (int i = 0; i < lkmmax; i++) {
            for (int j = 0; j < lkmmax; j++) {
                c.gridx = i;
                c.gridy = j;
                bingoPaneeli.add(napit[h], c);
                koordinaatit[h][0] = i;
                koordinaatit[h][1] = j;
                h++;
            }
        }
        
        this.add(bingoPaneeli, "South");
        
        /* JPanel tekstiPaneeli = new JPanel();
        tekstiPaneeli.setLayout(new FlowLayout());
        tekstiPaneeli.setBackground(Color.pink); */
        tulostuskentta = new JTextField("paina nappia", 20);
        /* tekstiPaneeli.add(tulostuskentta);
        this.add(tekstiPaneeli, "South"); */
        bingoPaneeli.add(tulostuskentta);
        
        
    }
    
    public void lisaaKuuntelijat() {
        for (int k = 0; k < etiketit.length; k++) {
            napit[k].addActionListener(this);
        }
        
    }

    public void rakennaYlaosa() {
        JPanel userPaneeli = new JPanel();
        userPaneeli.setLayout(new FlowLayout());
        userPaneeli.setBackground(Color.white);
        nimi = new JTextField("syötä käyttäjätunnus", 20);
        salasana = new JTextField("syötä salasana", 20);
        tarkista = new JButton("tarkistas alasana");
        userPaneeli.add(nimi);
        userPaneeli.add(salasana);
        userPaneeli.add(tarkista);
        this.add(userPaneeli, "North");        
        tarkista.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int a = 0; a < etiketit.length; a++) {
            // satu sama label: ottaa kaikki samat labelit kerralla.
            if (e.getActionCommand().equals(etiketit[a])) {
                napit[a].removeActionListener(this);
                napit[a].setBackground(Color.red);
                uusiBingo.muutaMerkki(koordinaatit[a][1], koordinaatit[a][0], 'X');
                // uusiBingo.piirra();
            }
        }
        if (uusiBingo.onBingo()) {
            tulostuskentta.setText("B I N G O !!!");
        }
        if (e.getActionCommand().equals("tarkista")) {
            salasana.setText("painettu");
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
