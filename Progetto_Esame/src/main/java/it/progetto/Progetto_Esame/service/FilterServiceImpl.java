package it.progetto.Progetto_Esame.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.json.simple.*;

import org.springframework.stereotype.Service;

import it.progetto.Progetto_Esame.model.RecordTwitter;

import it.progetto.Progetto_Esame.exceptions.*;
import it.progetto.Progetto_Esame.utils.*;

@Service
public class FilterServiceImpl implements FilterService{
	public ArrayList<RecordTwitter> getFilterTweets(String filtro){
		JSONObject json = (JSONObject) JSONValue.parse(filtro);
		ArrayList<RecordTwitter> tweets = RecordService.getTweets();
		
		try {
			ControlloJSON.controllo(json);
		}catch(InvalidJSONException e){
			System.out.println(e.toString());
			return null;
		}
		
		String[] filter = FilterSplitter.split(json);
		
		if (filter[0].contains("$")) {
			return CollectionFilter.compare(filter[0], (JSONArray)json.get(filter[0]));
		}
		
		Object value = ((JSONObject) (((JSONObject) json).get(filter[0]))).get(filter[1]);
		
		ArrayList<RecordTwitter> filteredJSON = new ArrayList<RecordTwitter>();
		for(RecordTwitter record: tweets) {
			try {
				Method m = record.getClass().getMethod("get"+filter[0].substring(0, 1).toUpperCase()+filter[0].substring(1),null);
				
				try {
					Object record_value = m.invoke(record);
					try {
						ControlloTipo.controllo(record_value, value);
					} catch (InvalidTypeException e) {
						System.out.println(e.toString());
						break;
					}
					if (value instanceof Number)
						if (NumericalFilter.compare(record_value, value, filter[1]))
							filteredJSON.add(record);
						
					if (value instanceof String)
						if(StringFilter.compare(record_value, value, filter[1]))
							filteredJSON.add(record);
				} catch (IllegalAccessException e) {
					System.out.println(e.toString());
				} catch (IllegalArgumentException e) {
					System.out.println(e.toString());
				} catch (InvocationTargetException e) {
					System.out.println(e.toString());
				}
			} catch (NoSuchMethodException e) {
				System.out.println(e.toString());
				break;
			} catch (SecurityException e) {
				System.out.println(e.toString());
			}
		}
		
		
		return filteredJSON;
	}
}
