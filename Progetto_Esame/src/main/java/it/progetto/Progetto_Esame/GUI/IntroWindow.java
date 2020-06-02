package it.progetto.Progetto_Esame.GUI;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

import it.progetto.Progetto_Esame.service.DataService;
import it.progetto.Progetto_Esame.service.RecordService;

public class IntroWindow {
	public static void start() {
		JFrame pannello = new JFrame("CARICA");
        pannello.getContentPane().setLayout(new GridLayout(5,1));
        
        JButton savedButton = new JButton("CARICA ULTIMA RICERCA");
        
        JLabel oppure = new JLabel("oppure");
        oppure.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel cercaLabel = new JLabel("inserisci cosa vuoi cercare: ");
        JTextField cercaText = new JTextField();
        JPanel cercaPanel = new JPanel();
        cercaPanel.setLayout(new GridLayout(1,2));
        cercaPanel.add(cercaLabel);
        cercaPanel.add(cercaText);
        
        JLabel cosa = new JLabel();
        
        JButton okCerca = new JButton("Cerca");
        JButton esciButton = new JButton("Esci");
        
        JPanel bottoniPanel = new JPanel();
        bottoniPanel.setLayout(new GridLayout(1,2));
        bottoniPanel.add(okCerca);
        bottoniPanel.add(esciButton);
        

        pannello.getContentPane().add(savedButton);
        pannello.getContentPane().add(oppure);
        pannello.getContentPane().add(cercaPanel);  	
        pannello.getContentPane().add(cosa);  	
        pannello.getContentPane().add(bottoniPanel);  	

        pannello.setResizable(false);
        pannello.pack();
        pannello.setVisible(true);
        
        savedButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String data = DataService.setLocalTweets();
        		RecordService rs = new RecordService(data);
        		JOptionPane.showMessageDialog(null, "Tweet caricati con successo");
        	}
        });
        
        Action action = new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
            	try {
					String data = DataService.setTweets(new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q="+cercaText.getText()+"&count=50&result_type=mixed"));
	        		RecordService rs = new RecordService(data);
            	} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	cosa.setText("Hai cercato: " + cercaText.getText());
            }
        };
        
        cercaText.addActionListener(action);
        
        okCerca.addActionListener(action);
        
        esciButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		pannello.dispose();
        		System.exit(0);
        	}
        });
	}
}
