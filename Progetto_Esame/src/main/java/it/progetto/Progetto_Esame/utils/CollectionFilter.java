package it.progetto.Progetto_Esame.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import org.json.simple.JSONArray;

import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.service.RecordService;

public class CollectionFilter {
	private static ArrayList<RecordTwitter> filteredJSON = new ArrayList<RecordTwitter>();
	public static ArrayList<RecordTwitter> compare(String op, JSONArray json) {
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
							if (record_value.equals(values.get(i)))
								filteredJSON.add(record);
						}
						
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
				i++;
			}
			
			if (op.equals("$and")) {
				if(AND(op, filteredValues, values))
					filteredValues.add(record);
			}
		}
		
		return filteredJSON;
	}
	 
	private static boolean AND(String op, ArrayList<Object> filteredValues, ArrayList<Object> values) {
		boolean ok = true;
		for (Object value: values) {
			if (!filteredValues.contains(value))
					ok = false;
		}
		return ok;
	}
}
