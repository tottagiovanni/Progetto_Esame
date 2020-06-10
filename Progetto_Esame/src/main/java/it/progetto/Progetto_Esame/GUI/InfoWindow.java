package it.progetto.Progetto_Esame.GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.service.RecordService;

/**
 * <p>
 * 	<b>Classe</b> <i>InfoWindow</i> per permettere all'utente di visualizzare i dettagli di uno specifico tweet
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class InfoWindow {
	/**
	 * Metodo che consente di visualizzare i dettagli di un tweet tramite il suo id
	 * @param id_post id che identifica il tweet
	 */
	public static void show(String id_post) {
			JFrame infoFrame = new JFrame("Informazioni su "+id_post);
			infoFrame.getContentPane().setLayout(new GridBagLayout());
			
			RecordTwitter tweet = RecordService.getRecord(id_post);
			JLabel name = new JLabel("Nome: " + tweet.getName());
			JLabel date = new JLabel("Data: " + tweet.getDate());
			JLabel text = new JLabel("Post: " + tweet.getText());
			JLabel like = new JLabel("Like: " + tweet.getLike());
			JLabel followers = new JLabel("Followers: " + tweet.getFollowers());
			JLabel retweet = new JLabel("Retweet: " + tweet.getRetweet());
			JLabel nation = new JLabel("Nazione: " + tweet.getNation());
			JLabel device = new JLabel("Dispositivo: " + tweet.getDevice());
			JLabel hashtag = new JLabel("Numero hashtag: " + tweet.getHashtags());

			JPanel panelInfo = new JPanel();
			panelInfo.setLayout(new GridLayout(9,1));
			
			panelInfo.add(name);
			panelInfo.add(date);
			panelInfo.add(text);
			panelInfo.add(like);
			panelInfo.add(followers);
			panelInfo.add(retweet);
			panelInfo.add(nation);
			panelInfo.add(device);
			panelInfo.add(hashtag);

	        GridBagConstraints c = new GridBagConstraints();

    		c.fill = GridBagConstraints.HORIZONTAL;
        	c.gridx = 0;
        	c.gridy = 0;
        	c.gridwidth = 1;
        	infoFrame.add(panelInfo, c);

        	
			JButton chiudi = new JButton("CHIUDI");	
			chiudi.setPreferredSize(new Dimension(30,30));
			
    		c.fill = GridBagConstraints.HORIZONTAL;
        	c.gridx = 0;
        	c.gridy = 1;
        	c.gridwidth = 1;
			infoFrame.add(chiudi, c);
			
	        infoFrame.pack();
	        infoFrame.setVisible(true);
	        infoFrame.setResizable(false);
	        
	        chiudi.addActionListener(new ActionListener() {
	        	/**
	        	 * Metodo che chiude la finestra se viene premuto il bottone "CHIUDI"
	        	 */
	        	public void actionPerformed(ActionEvent e) {
	        		infoFrame.dispose();
	        	}
	        });
	        
		}
}
