package it.progetto.Progetto_Esame.service;

import java.io.*;
import java.net.*;
import java.util.*;

import org.springframework.stereotype.Service;

import it.progetto.Progetto_Esame.utils.JSON.PersistenceJSON;

/**
 * <p>
 * 	<b>Classe</b> <i>DataService</i> per il salvataggio dei dati e la scrittura su file locale
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @see it.progetto.Progetto_Esame.exceptions
 * @see it.progetto.Progetto_Esame.utils
 * @version 1.0
 */
@Service
public class DataService {
	
	/**
	 * Costruttore di default della classe
	 */
	public DataService() {
	}
	
	
	/**
	 * Metodo per il salvataggio dei tweets ottenuti dalla richiesta e la scrittura su file
	 * @param query url della richiesta effettuata alle api di Twitter
	 * @return insieme dei tweets in formato <code>String</code>
	 * @see it.progetto.Progetto_Esame.utils.JSON.PersistenceJSON#writeJSONFile(String)
	 */
	public static String setTweets(URL query){
		
	    URLConnection yc = null;
		try {
			yc = query.openConnection();
		} catch (IOException e1) {
			System.out.println(e1.toString());
		}
		
	    BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		} catch (IOException e1) {
			System.out.println(e1.toString());
		}
	    
	    
	    String inputLine = "";
	    String data = "";
	
	    try {
			while ((inputLine = in.readLine()) != null)
				data += inputLine;
		} catch (IOException e1) {
			System.out.println(e1.toString());
		}
	    
	    PersistenceJSON.writeJSONFile(data);
	    return data;
	}  
	
	/**
	 * Metodo per l'estrazione dell'ultima ricerca da file locale
	 * @return insieme dei tweets in formato <code>String</code>
	 */
	public static String setLocalTweets() {
		String data = "";
		try {
			Scanner reader = new Scanner(new File("ultima_ricerca.json"));
			while (reader.hasNextLine()) {
				 data = reader.nextLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errore nel caricamento del file!");
			System.out.println(e.toString());
		}
		return data;
	}
	
}
