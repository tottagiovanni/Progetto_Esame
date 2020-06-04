package it.progetto.Progetto_Esame.GUI;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

import it.progetto.Progetto_Esame.service.DataService;
import it.progetto.Progetto_Esame.service.RecordService;

public class IntroWindow {
	public static void show() {
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
        		redirect(pannello);
        	}
        });
        
        Action action = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
            	try {
					String data = DataService.setTweets(new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q="+cercaText.getText().replaceAll("\\s+","")+"&count=50&result_type=mixed"));
	        		RecordService rs = new RecordService(data);
            	} catch (MalformedURLException e1) {
					System.out.println(e1.toString());
				}
            	cosa.setText("Hai cercato: " + cercaText.getText());
            	redirect(pannello);
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
    	/*
        pannello.addWindowListener(new WindowAdapter() {
        	  public void windowClosing(WindowEvent we) {
        	    System.exit(0);
        	  }
        	});*/
	}
	
	private static void redirect(JFrame pannello) {
		TweetsWindow.show();
		pannello.dispatchEvent(new WindowEvent(pannello, WindowEvent.WINDOW_CLOSING));
	}
}
