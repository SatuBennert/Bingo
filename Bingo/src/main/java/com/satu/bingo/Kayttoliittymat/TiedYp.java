package com.satu.bingo.Kayttoliittymat;

import com.satu.bingo.TiedostoKasittelija;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author satu
 */
public class TiedYp implements ActionListener {

    JTextField otsikko;
    JTextArea textArea;
    JButton talleta, edellinen, seuraava, uusi, poista;
    JFrame jf;
    JPanel paneeli;
    File otstiedosto;
    TiedostoKasittelija tk;
    int koko, lkm;
    String[] bingos = {"Pelaa Bingo 3X3", "Pelaa Bingo 5X5", "Pelaa Bingo 7X7", "Pelaa Bingo 8X8", "Pelaa Bingo 10X10"};

    public TiedYp() {
        jf = new JFrame();
        textArea = new JTextArea(5, 30);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450, 110));

        jf.setLayout(new BorderLayout());
        otsikko = new JTextField("otsikko", 30);
        talleta = new JButton("talleta");
        seuraava = new JButton("seuraava");
        edellinen = new JButton("edellinen");
        uusi = new JButton("uusi");
        poista = new JButton("poista");

        JComboBox bingoGames = new JComboBox(bingos);
        bingoGames.setSelectedIndex(0);

        paneeli = new JPanel();
        paneeli.add(otsikko);
        paneeli.add(edellinen);
        paneeli.add(seuraava);
        paneeli.add(uusi);
        paneeli.add(scrollPane);
        paneeli.add(talleta);
        paneeli.add(bingoGames);
        paneeli.add(poista);
        paneeli.setBackground(Color.pink);

        jf.add(paneeli, BorderLayout.CENTER);

        seuraava.addActionListener(this);
        edellinen.addActionListener(this);
        talleta.addActionListener(this);
        uusi.addActionListener(this);
        poista.addActionListener(this);
        bingoGames.addActionListener(this);

        tk = new TiedostoKasittelija("Satu");
        otstiedosto = new File("Satu.txt");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            if (e.getActionCommand().equals("talleta")) {
                File rivitiedosto = new File(otsikko.getText().concat(".txt"));
                tk.talletaTiedosto(rivitiedosto, textArea.getText());
                tk.talletaBingoOtsikko(otstiedosto, otsikko.getText());
            }
            if (e.getActionCommand().equals("seuraava")) {
                otsikko.setText(tk.haeSeuraava(otstiedosto, otsikko.getText()));
                File rivitiedosto = new File(otsikko.getText().concat(".txt"));
                textArea.setText(tk.haeKaikkiStringiin(rivitiedosto));
            }
            if (e.getActionCommand().equals("edellinen")) {
                otsikko.setText(tk.haeEdellinen(otstiedosto, otsikko.getText()));
                File rivitiedosto = new File(otsikko.getText().concat(".txt"));
                textArea.setText(tk.haeKaikkiStringiin(rivitiedosto));
            }
            if (e.getActionCommand().equals("poista")) {
                File rivitiedosto = new File(otsikko.getText().concat(".txt"));
                tk.poistaTiedosto(rivitiedosto);
                tk.poistaBingoOtsikko(otstiedosto, otsikko.getText());
                textArea.setText("");
                otsikko.setText("Poistettu: " + otsikko.getText());
            }
            if (e.getActionCommand().equals("uusi")) {
                textArea.setText("Kirjoita bingolabelit.\nLabel per rivi.");
                otsikko.setText("Kirjoita uusi bingo");
            }
        } else if (source instanceof JComboBox) {
            JComboBox cb = (JComboBox) e.getSource();
            String valinta = (String) cb.getSelectedItem();
            switch (valinta) {
                case "Pelaa Bingo 3X3":
                    koko = 3;
                    lkm = 9;
                    break;
                case "Pelaa Bingo 5X5":
                    koko = 5;
                    lkm = 25;
                    break;
                case "Pelaa Bingo 7X7":
                    koko = 7;
                    lkm = 49;
                    break;
                case "Pelaa Bingo 8X8":
                    koko = 9;
                    lkm = 81;
                    break;
                case "Pelaa Bingo 10X10":
                    koko = 10;
                    lkm = 100;
                    break;
            }
            if (!valinta.equalsIgnoreCase("")) {
                File rivitiedosto = new File(otsikko.getText().concat(".txt"));
                TiedostoKasittelija pelitk = new TiedostoKasittelija(lkm);
                BingoIkkuna pingoBongo = new BingoIkkuna(pelitk.haeLabelit(rivitiedosto), koko);
                pingoBongo.gui();
            }
        }
        jf.repaint();
//        textArea.repaint();
    }

    public void gui() {
        jf.pack();
        jf.setTitle("Bingon ylläpito");
        jf.setVisible(true);
        jf.setSize(500, 300);
//   	/* j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        System.out.println("gui ok");
    }
}
