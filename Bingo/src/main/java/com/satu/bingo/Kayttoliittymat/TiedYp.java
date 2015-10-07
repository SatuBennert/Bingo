/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.satu.bingo.Kayttoliittymat;
import com.satu.bingo.TiedostoKasittelija;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author satu
 */
public class TiedYp implements ActionListener {
	JTextField otsikko;
	JScrollPane jsp;
	TextArea textArea;
	JButton talleta, edellinen, seuraava, uusi;
	JFrame jf;
	JPanel paneeli;
	File otstiedosto;
	TiedostoKasittelija tk;
	public TiedYp() {
    	jf = new JFrame();
    	jf.setLayout(new BorderLayout());
    	otsikko = new JTextField("otsikko", 30);
    	talleta = new JButton("talleta");
    	seuraava = new JButton("seuraava");
    	edellinen = new JButton("edellinen");
    	uusi = new JButton("uusi");
    	textArea = new TextArea();
    	textArea.setSize(800, 600);
    	tk = new TiedostoKasittelija("Satu");
    	otstiedosto = new File("Satu.txt");
    	ArrayList<String> tiedsis = new ArrayList<>();
//    	textArea.setText(tk.haeKaikkiStringiin(tiedosto));
    	// oletuksena haetaan Käyttäjän eka bingo
//    	otsikko.setText(tk.haeSeuraavaOtsikko(otstiedosto, "  "));
//    	System.out.println("otsikon haku ok" + otsikko.getText());
//    	File rivitiedosto = new File(otsikko.getText().concat(".txt"));
//    	System.out.println("rivin haku lähtee arvolla: " + rivitiedosto.toString());
//    	textArea.setText(tk.haeKaikkiStringiin(rivitiedosto));
//    	System.out.println("rivin haku ok");
    	// add text to it; we want to make it scroll
//    	textArea.setText("xx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxkkkkkkkkkkkkkkkkkkkkkkkkkkklkajlkfjalkjf");
    	// create a scrollpane, givin it the textarea as a constructor argument
    	jsp = new JScrollPane(textArea);
    	paneeli = new JPanel();
    	paneeli.add(otsikko);
    	paneeli.add(edellinen);
    	paneeli.add(seuraava);
    	paneeli.add(uusi);
    	paneeli.add(jsp);
    	paneeli.add(talleta);
//    	paneeli.add(etiketit);
    	paneeli.setBackground(Color.pink);
    	jf.add(paneeli, BorderLayout.CENTER);
    	seuraava.addActionListener(this);
    	edellinen.addActionListener(this);
    	talleta.addActionListener(this);
    	uusi.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
    	if (e.getActionCommand().equals("talleta")) {
        	System.out.println("talleta painettu: " + textArea.getText());
    	}
    	if (e.getActionCommand().equals("seuraava")) {
        	otsikko.setText(tk.haeSeuraavaOtsikko(otstiedosto, otsikko.getText()));
        	File rivitiedosto = new File(otsikko.getText().concat(".txt"));
        	textArea.setText(tk.haeKaikkiStringiin(rivitiedosto));
        	
    	}
    	if (e.getActionCommand().equals("edellinen")) {
        	System.out.println("edellinen painettu");
        	otsikko.setText(tk.haeEdellinenOtsikko(otstiedosto, otsikko.getText()));
        	File rivitiedosto = new File(otsikko.getText().concat(".txt"));
        	textArea.setText(tk.haeKaikkiStringiin(rivitiedosto));
        	
    	}
    	if (e.getActionCommand().equals("uusi")) {
        	textArea.setText("Kirjoita bingon labelit\nyksi label kullekin riville ");
        	otsikko.setText("Kirjoita bingon nimi");
    	}
    	jf.repaint();
	}
	public void gui() {
    	jf.pack();
    	jf.setTitle("Bingojen ylläpito");
    	jf.setVisible(true);
    	jf.setSize(500, 300);
//   	/* j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
    	System.out.println("gui ok");
	}
}
