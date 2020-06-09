package it.progetto.Progetto_Esame.utils.JSON;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * <p>
 * 	<b>Classe</b> <i>JSONKeys</i> per ottenere i nomi dei campi presenti nel JSON
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class JSONKeys { 
	
	/**
	 * Metodo che restituisce i nomi dei campi del JSON
	 * @param json json contenente i campi da filtrare
	 * @return ArrayList con i nomi dei campi di tipo <code>String</code>
	 */
	public static ArrayList<String> getKeys(JSONArray json){
		Iterator<Object> iterator = json.iterator();
		
		ArrayList<String> keys = new ArrayList<String>();
		while (iterator.hasNext()) {
            JSONObject jsonObject = (JSONObject) iterator.next();
			Set<String> set = jsonObject.keySet();
            for (String key : set) {
                keys.add(key);
            }
        }
		
		return keys;
	}
}
