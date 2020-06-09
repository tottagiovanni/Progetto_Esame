package it.progetto.Progetto_Esame.utils.Filter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.progetto.Progetto_Esame.exceptions.InvalidJSONException;
import it.progetto.Progetto_Esame.exceptions.InvalidTypeException;
import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.service.RecordService;
import it.progetto.Progetto_Esame.utils.JSON.JSONKeys;
import it.progetto.Progetto_Esame.utils.JSON.JSONValues;

/**
 * <p>
 * 	<b>Classe</b> <i>CollectionFilter</i> che applica i filtri in base ai dati presenti nella Collection
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class CollectionFilter {
	
	/**
	 * Indica l'ArrayList di tweets filtrati 
	 */
	private static ArrayList<RecordTwitter> filteredJSON = new ArrayList<RecordTwitter>();
	
	/**
	 * Metodo che applica i filtri, restituendo l'ArrayList filtrato
	 * @param op operatore che indica il tipo di filtro
	 * @return ArrayList di RecordTwitter
	 * @see it.progetto.Progetto_Esame.model.RecordTwitter
	 * @see it.progetto.Progetto_Esame.utils
	 * @see it.progetto.Progetto_Esame.service.RecordService#getTweets()
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException se il metodo non è presente tra quelli di RecordTwitter
	 * @throws SecurityException
	 */
	public static ArrayList<RecordTwitter> compare(String op, JSONArray json) {
		filteredJSON.clear();
		ArrayList<RecordTwitter> tweets = RecordService.getTweets();
		ArrayList<String> keys = JSONKeys.getKeys(json);
		ArrayList<Object> values = JSONValues.getValues(keys, json);
		
 		int i = 0;
 		
		for (RecordTwitter record: tweets) {
			i = 0;
			ArrayList<Object> filteredValues = new ArrayList<Object>();
			for (String k: keys) {
				try {
					Method m = record.getClass().getMethod("get"+k.substring(0, 1).toUpperCase()+k.substring(1),null);
					
					try {
						Object record_value = m.invoke(record);
						filteredValues.add(record_value);
						if (op.equals("$or")) {
							if (record_value.equals(values.get(i)) && notinArray(record.getId_post()))
									filteredJSON.add(record);
						}
						
					} catch (IllegalAccessException e) {
						System.out.println(e.toString());
					} catch (IllegalArgumentException e) {
						System.out.println(e.toString());
					} catch (InvocationTargetException e) {
						System.out.println(e.toString());
					}
				} catch (NoSuchMethodException e) {
					filteredJSON.add(new RecordTwitter(e.toString()));
					return filteredJSON;
				} catch (SecurityException e) {
					System.out.println(e.toString());
				}
				i++;
			}
			
			if (op.equals("$and")) {
				if(AND(filteredValues, values))
					filteredJSON.add(record);
			}
		}
		
		return filteredJSON;
	}
	
	/**
	 * Metodo che verifica se il dato presente nell'ArrayList soddisfa le condizioni del filtro AND
	 * @param filteredValues ArrayList di tweets filtrati in base ai campi scelti
	 * @param values ArrayList contenente i valori dei tweets da scegliere 
	 * @return boolean che segnala se vengono rispettate le condizioni dell'AND
	 */
	private static boolean AND(ArrayList<Object> filteredValues, ArrayList<Object> values) {
		boolean ok = true;
		for (Object value: values) {
			if (!filteredValues.contains(value))
					ok = false;
		}
		return ok;
	}
	
	/**
	 * Metodo che controlla che non si formano tweets duplicati nell'ArrayList filtrato 
	 * @param id id del tweet
	 * @return boolean che segnala se il tweet è già presente
	 */
	private static boolean notinArray(String id) {
		for (RecordTwitter o: filteredJSON) {
			if((o.getId_post()).equals(id))
				return false;
		}
		return true;
	}
}
