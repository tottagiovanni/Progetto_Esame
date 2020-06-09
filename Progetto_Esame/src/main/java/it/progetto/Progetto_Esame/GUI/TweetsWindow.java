package it.progetto.Progetto_Esame.GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.service.RecordService;

/**
 * <p>
 * 	<b>Classe</b> <i>TweetsWindow</i> per permettere all'utente di visualizzare i tweets ricercati
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class TweetsWindow {
	/**
	 * Metodo che consente la visualizzazione di tutti i tweets ricercati (argomento o ultima ricerca)
	 */
	public static void show() {
		ArrayList<RecordTwitter> tweets = RecordService.getTweets();

		JFrame tweetsFrame = new JFrame("PROVA");
		JPanel panel = new JPanel();

		JScrollPane scrollPane = new JScrollPane(panel);

		int num = tweets.size();
		if (num < 15)
			num = 15;

		panel.setLayout(new GridLayout(num + 1, 1));
		
		if (tweets.isEmpty())
			panel.add(new JLabel("Non ci sono risultati associati."));
		else {
			JButton[] buttons = new JButton[num];

			int i = 0;
			for (RecordTwitter tweet : tweets) {
				buttons[i] = new JButton(
						"<html>Utente: " + tweet.getName() + "<br>Testo: " + tweet.getText() + "</html>");
				
				buttons[i].setHorizontalAlignment(SwingConstants.LEFT);
				panel.add(buttons[i]);

				buttons[i].addActionListener(new ActionListener() {
					/**
					 * Metodo che permette di selezionare un post per visualizzarne i dettagli
					 * @see it.progetto.Progetto_Esame.GUI.InfoWindow#show(String)
					 */
					public void actionPerformed(ActionEvent e) {
						InfoWindow.show(tweet.getId_post());
					}
				});
				i++;
			}
		}
		JButton chiudi = new JButton("CHIUDI");
		panel.add(chiudi);
		
		panel.revalidate();
		panel.repaint();

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		tweetsFrame.add(scrollPane);
		tweetsFrame.setResizable(true);
		tweetsFrame.pack();
		tweetsFrame.setVisible(true);

		chiudi.addActionListener(new ActionListener() {
			/**
			 * Metodo che chiude la finestra se viene premuto il bottone "CHIUDI"
			 */
			public void actionPerformed(ActionEvent e) {
				tweetsFrame.dispose();
			}
		});

		tweetsFrame.addWindowListener(new WindowAdapter() {
			/**
			 * Metodo che chiude la finestra
			 */
			public void windowClosing(WindowEvent we) {
				tweetsFrame.dispose();
			}
		});
	}
}
