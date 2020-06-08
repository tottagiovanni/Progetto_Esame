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
		JFrame introFrame = new JFrame("CARICA");
        introFrame.getContentPane().setLayout(new GridLayout(5,1));
        
        JButton savedButton = new JButton("CARICA ULTIMA RICERCA");
        
        JLabel oppure = new JLabel("oppure");
        oppure.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel searchLabel = new JLabel("inserisci msgLabel vuoi cercare: ");
        JTextField searchText = new JTextField();
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(1,2));
        searchPanel.add(searchLabel);
        searchPanel.add(searchText);
        
        JLabel msgLabel = new JLabel();
        
        JButton okCerca = new JButton("Cerca");
        JButton esciButton = new JButton("Esci");
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2));
        buttonsPanel.add(okCerca);
        buttonsPanel.add(esciButton);
        

        introFrame.getContentPane().add(savedButton);
        introFrame.getContentPane().add(oppure);
        introFrame.getContentPane().add(searchPanel);  	
        introFrame.getContentPane().add(msgLabel);  	
        introFrame.getContentPane().add(buttonsPanel);  	

        introFrame.setResizable(false);
        introFrame.pack();
        introFrame.setVisible(true);
        
        savedButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String data = DataService.setLocalTweets();
        		try {
        			RecordService rs = new RecordService(data);
        			JOptionPane.showMessageDialog(null, "Tweet caricati con successo");
        			redirect();
        		}catch(NullPointerException e1){
        			System.out.println(e1.toString());
        			JOptionPane.showMessageDialog(null, "Ultima ricerca non disponibile");
        		}
        	}
        });
        
        Action action = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
            	try {
					String data = DataService.setTweets(new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q="+searchText.getText().replaceAll("\\s+","")+"&count=50&result_type=mixed"));
	        		RecordService rs = new RecordService(data);
            	} catch (MalformedURLException e1) {
					System.out.println(e1.toString());
					
				}
            	msgLabel.setText("Hai cercato: " + searchText.getText());
            	redirect();
            }
        };
        
        searchText.addActionListener(action);
        
        okCerca.addActionListener(action);
        
        esciButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		introFrame.dispose();
        		System.exit(0);
        	}
        });
    	
        introFrame.addWindowListener(new WindowAdapter() {
        	  public void windowClosing(WindowEvent we) {
        	    System.exit(0);
        	  }
        	});
	}
	
	private static void redirect() {
		TweetsWindow.show();
	}
}
