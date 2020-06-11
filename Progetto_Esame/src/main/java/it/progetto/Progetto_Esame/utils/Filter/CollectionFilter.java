package it.progetto.Progetto_Esame.utils.Filter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import org.json.simple.JSONArray;

import it.progetto.Progetto_Esame.exceptions.InvalidFilterException;
import it.progetto.Progetto_Esame.exceptions.InvalidTypeException;
import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.service.RecordService;
import it.progetto.Progetto_Esame.utils.CheckType;
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
	 * @param json json contenente i dati da filtrare
	 * @return ArrayList di RecordTwitter
	 * @see it.progetto.Progetto_Esame.model.RecordTwitter
	 * @see it.progetto.Progetto_Esame.utils
	 * @see it.progetto.Progetto_Esame.service.RecordService#getTweets()
	 * @see it.progetto.Progetto_Esame.utils.CheckType#check(Object, Object)
	 * @see it.progetto.Progetto_Esame.exceptions.InvalidTypeException
	 * @see it.progetto.Progetto_Esame.utils.Filter.CheckFilter#isAFilter(String)
	 * @see it.progetto.Progetto_Esame.exceptions.InvalidFilterException
	 */
	public static ArrayList<RecordTwitter> compare(String op, JSONArray json) {
		filteredJSON.clear();
		
		try {
			CheckFilter.isAFilter(op);
		}catch(InvalidFilterException e) {
			filteredJSON.add((new RecordTwitter(e.toString())));
			return filteredJSON;
		}
		
		ArrayList<RecordTwitter> tweets = RecordService.getTweets();
		ArrayList<String> keys = JSONKeys.getKeys(json);
		ArrayList<Object> values = JSONValues.getValues(keys, json);
		
 		int i = 0;
 		Method m = null;
 		
		for (RecordTwitter record: tweets) {
			i = 0;
			ArrayList<Object> filteredValues = new ArrayList<Object>();
			ArrayList<String> methods = new ArrayList<String>();
			for (String k: keys) {
				try {
					m = record.getClass().getMethod("get"+k.substring(0, 1).toUpperCase()+k.substring(1),null);
					methods.add((m.toString()).substring((m.toString()).lastIndexOf(".") + 1));
					try {
						Object record_value = m.invoke(record);
						filteredValues.add(record_value);
						
						try {
							CheckType.check(record_value, values.get(i));
						} catch (InvalidTypeException e) {
							filteredJSON.clear();
							filteredJSON.add(new RecordTwitter(e.toString()));			
							return filteredJSON;
						}
						
						if (op.equals("$or")) {
							if (equals(record_value, values.get(i)) && notinArray(record.getId_post()))
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
					filteredJSON.clear();
					filteredJSON.add(new RecordTwitter(e.toString()));
					return filteredJSON;
				} catch (SecurityException e) {
					System.out.println(e.toString());
				}
				i++;
			}
			
			if (op.equals("$and")) {
				if(AND(filteredValues, values, methods, keys))
					filteredJSON.add(record);
			}
		}
		
		return filteredJSON;
	}
	
	/**
	 * Metodo che confronta i tipi di dato e richiami i corrispondenti metodi per filtrare
	 * @param record_value valore del campo di un RecordTwitter
	 * @param value valore del campo da filtrare
	 * @return boolean che segnala se il confronto tra i valori è riuscito
	 * @see it.progetto.Progetto_Esame.utils.Filter.NumericalFilter#compare(Object, Object, String)
	 * @see it.progetto.Progetto_Esame.utils.Filter.StringFilter#compare(Object, Object, String)
	 */
	public static boolean equals(Object record_value, Object value) {
		if (value instanceof Number)
			return NumericalFilter.compare(record_value, value, "$eq");
		else if (value instanceof String)
			return StringFilter.compare(record_value, value, "$in");
		else
			return false;
	}
	
	/**
	 * Metodo che verifica se il dato presente nell'ArrayList soddisfa le condizioni del filtro AND
	 * @param filteredValues ArrayList di tweets filtrati in base ai campi scelti
	 * @param values ArrayList contenente i valori dei tweets da scegliere 
	 * @return boolean che segnala se vengono rispettate le condizioni dell'AND
	 */
	private static boolean AND(ArrayList<Object> filteredValues, ArrayList<Object> values, ArrayList<String> methods, ArrayList<String> keys) {
		int cont = 0, i = 0, j = 0;
		for (Object value: values) {
			j = 0;
			for (Object record: filteredValues) {
				String key = "get" + (keys.get(i)).substring(0, 1).toUpperCase() + (keys.get(i)).substring(1) + "()";
				if (record.getClass() == value.getClass())
					if (equals(record, value) && (methods.get(j)).equals(key)){
						cont++;
					}
				j++;
			}
			i++;
		}
		
		if (cont == values.size())
			return true;
		else
			return false;
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
