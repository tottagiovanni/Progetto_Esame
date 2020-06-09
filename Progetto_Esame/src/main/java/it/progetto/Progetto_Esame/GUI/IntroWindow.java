package it.progetto.Progetto_Esame.GUI;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

import it.progetto.Progetto_Esame.service.DataService;
import it.progetto.Progetto_Esame.service.RecordService;

/**
 * <p>
 * 	<b>Classe</b> <i>IntroWindow</i> per permettere all'utente di cercare i tweets per argomento o di caricare l'ultima ricerca locale
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class IntroWindow {
	/**
	 * Metodo che mostra la finestra per l'inserimento dell'argomento da cercare o per caricare l'ultima ricerca
	 */
	public static void show() {
		JFrame introFrame = new JFrame("CARICA");
        introFrame.getContentPane().setLayout(new GridLayout(5,1));
        
        JButton savedButton = new JButton("CARICA ULTIMA RICERCA");
        
        JLabel oppure = new JLabel("oppure");
        oppure.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel searchLabel = new JLabel("inserisci cosa vuoi cercare: ");
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
        	/**
        	 * Metodo che permette la selezione dell'ultima ricerca presente localmente
        	 * @see it.progetto.Progetto_Esame.service.RecordService
        	 * @see it.progetto.Progetto_Esame.service.DataService#setLocalTweets()
        	 * @throws NullPointerException se l'ultima ricerca non è disponibile
        	 */
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
			
			/**
        	 * Metodo che permette l'inserimento dell'argomento di ricerca dei tweets
        	 * @see it.progetto.Progetto_Esame.service.RecordService
        	 * @see it.progetto.Progetto_Esame.service.DataService#setTweets()
        	 * @throws MalformedURLException se si inseriscono parametri non validi nell'URL
        	 */
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
        	/**
        	 * Metodo che chiude la finestra e il programma se viene premuto il bottone "Esci"
        	 */
        	public void actionPerformed(ActionEvent e) {
        		introFrame.dispose();
        		System.exit(0);
        	}
        });
    	
        introFrame.addWindowListener(new WindowAdapter() {
        	  /**
        	   * Metodo che chiude la finestra e il programma
        	   */
        	  public void windowClosing(WindowEvent we) {
        	    System.exit(0);
        	  }
        	});
	}
	
	/**
	 * Metodo che reindirizza alla finestra di visualizzazione dei tweets cercati
	 * @see it.progetto.Progetto_Esame.GUI.TweetsWindow#show()
	 */
	private static void redirect() {
		TweetsWindow.show();
	}
}
