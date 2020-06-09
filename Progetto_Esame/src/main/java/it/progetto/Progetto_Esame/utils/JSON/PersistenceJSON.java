package it.progetto.Progetto_Esame.utils.JSON;

import java.io.FileWriter;
import java.io.IOException;

/**
 * <p>
 * 	<b>Classe</b> <i>PersistenceJSON</i> per il salvataggio dell'ultima ricerca su file locale
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class PersistenceJSON {
	
	/**
	 * Costruttore di default
	 */
	public PersistenceJSON() {
	}
	
	/**
	 * Metodo che scrive il json contenente la ricerca su file
	 * @param JSONString Stringa contenente i tweets ricercati
	 * @throws IOException se ci sono problemi di apertura del file in scrittura
	 */
	public static void writeJSONFile(String JSONString) {
		try (FileWriter file = new FileWriter("ultima_ricerca.json")) {
            
            file.write(JSONString);
            file.flush();

        } catch (IOException e) {
            System.out.println(e.toString());
        }
	}
}
