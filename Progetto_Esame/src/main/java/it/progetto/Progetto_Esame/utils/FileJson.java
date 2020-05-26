package it.progetto.Progetto_Esame.utils;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;

public class FileJson {
	public FileJson(){
	}
	
	public static void newJSON(JSONArray json) {
		try (FileWriter file = new FileWriter("tweets.json")) {
	       	 
            file.write(json.toString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
