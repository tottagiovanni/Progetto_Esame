package it.progetto.Progetto_Esame.GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.service.RecordService;

public class TweetsWindow {
	public static void show() {
		ArrayList<RecordTwitter> tweets = RecordService.getTweets();
		
        JFrame pannello = new JFrame("PROVA");
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane(panel); 
		
		int num = tweets.size();
		if(num < 15)
			num = 15;

        panel.setLayout(new GridLayout(num+1,1));
        
        JButton[] buttons = new JButton[num];
        
        int i  = 0;
        for(RecordTwitter tweet : tweets) {
        	buttons[i] = new JButton("<html>Utente: "+ tweet.getName() + "<br>Testo: " + tweet.getText() + "</html>");
        	//buttons[i].setPreferredSize(new Dimension(100, 50));
        	buttons[i].setHorizontalAlignment(SwingConstants.LEFT);
            panel.add(buttons[i]);
            
            buttons[i].addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		InfoWindow.show(tweet.getId_post());
            	}
            });
            
            i++;
        }
        JButton chiudi = new JButton("CHIUDI");
        panel.add(chiudi);
        
        panel.revalidate();
        panel.repaint();
        
        
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        
        pannello.add(scrollPane);
        pannello.setResizable(true);
        pannello.pack();
        pannello.setVisible(true);
        
        chiudi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        
        pannello.addWindowListener(new WindowAdapter() {
        	  public void windowClosing(WindowEvent we) {
        	    System.exit(0);
        	  }
        	});
	}
}
