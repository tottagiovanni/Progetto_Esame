package it.progetto.Progetto_Esame.service;

import java.io.*;
import java.net.*;
import java.util.*;

import it.progetto.Progetto_Esame.utils.PersistenceJSON;


public class DataService {
	public DataService() {
	}
	
	public static String setTweets(URL query){
	    URLConnection yc = null;
		try {
			yc = query.openConnection();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	    BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    
	    
	    String inputLine = "";
	    String data = "";
	
	    try {
			while ((inputLine = in.readLine()) != null)
				data += inputLine;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    
	    PersistenceJSON.writeJSONFile(data);
	    return data;
	}  
	
	public static String setLocalTweets() {
		String data = "";
		try {
			Scanner reader = new Scanner(new File("ultima_ricerca.json"));
			while (reader.hasNextLine()) {
				 data = reader.nextLine();
				System.out.println(data);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errore nel caricamento del file!");
			e.printStackTrace();
		}
		return data;
	}
	
}
