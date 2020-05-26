package it.progetto.Progetto_Esame.utils;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;

public class Utilità {
	public static String rimuoviTag(String stringa) {
		String ris = "";
		boolean ok = false;
		for (char c: stringa.toCharArray()) {
			if (c == '<' && ok)
				break;
			
			if (ok)
				ris += c;
			
			if (c == '>')
				ok = true;
		}
		return ris;
	}
	
	public static void parser(JSONArray json) {
		try (FileWriter file = new FileWriter("tweets.json")) {
	       	 
            file.write(json.toString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
