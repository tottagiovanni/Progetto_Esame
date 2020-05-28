package it.progetto.Progetto_Esame.utils;

import java.io.FileWriter;
import java.io.IOException;

public class PersistenceJSON {
	public PersistenceJSON() {
	}
	
	public static void writeJSONFile(String JSONString) {
		try (FileWriter file = new FileWriter("ultima_ricerca.json")) {
            
            file.write(JSONString);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
