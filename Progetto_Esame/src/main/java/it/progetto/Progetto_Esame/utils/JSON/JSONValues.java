package it.progetto.Progetto_Esame.utils.JSON;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * <p>
 * 	<b>Classe</b> <i>JSONValues</i> per ottenere i valori dei campi presenti nel JSON
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class JSONValues {
	
	/**
	 * Metodo che restituisce i valori dei campi del JSON
	 * @param json json contenente i campi da filtrare
	 * @return ArrayList con i valori dei campi di tipo <code>Object</code>
	 */
	public static ArrayList<Object> getValues(ArrayList<String> keys, JSONArray json){
		ArrayList<Object> values = new ArrayList<Object>();
		int i = 0;
		for (Object o: json) {
			JSONObject jobj = (JSONObject) o;
			values.add(jobj.get(keys.get(i)));
			i++;
		}
		
		return values;
	}
}
