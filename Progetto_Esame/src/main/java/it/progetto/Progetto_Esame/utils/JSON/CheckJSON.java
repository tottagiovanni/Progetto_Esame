package it.progetto.Progetto_Esame.utils.JSON;

import org.json.simple.JSONObject;

import it.progetto.Progetto_Esame.exceptions.InvalidJSONException;

/**
 * <p>
 * 	<b>Classe</b> <i>CheckJSON</i> per il controllo dei JSON vuoti
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class CheckJSON {
	
	/**
	 * Metodo che controlla se il JSON è vuoto e, in caso affermativo, lancia l'eccezione
	 * @param json json contenente i dati dei tweets
	 * @throws InvalidJSONException se il JSON è vuoto {@link it.progetto.Progetto_Esame.exceptions.InvalidJSONException}
	 */
	public static void check(JSONObject json) throws InvalidJSONException{
		if (json == null)
			throw new InvalidJSONException("Formato JSON non corretto!");
	}
}
