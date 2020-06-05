package it.progetto.Progetto_Esame.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.json.simple.*;
import org.springframework.stereotype.Service;

import it.progetto.Progetto_Esame.model.RecordTwitter;

import it.progetto.Progetto_Esame.exceptions.*;
import it.progetto.Progetto_Esame.utils.*;
import it.progetto.Progetto_Esame.utils.Filter.CollectionFilter;
import it.progetto.Progetto_Esame.utils.Filter.FilterSplitter;
import it.progetto.Progetto_Esame.utils.Filter.NumericalFilter;
import it.progetto.Progetto_Esame.utils.Filter.StringFilter;
import it.progetto.Progetto_Esame.utils.JSON.CheckJSON;

@Service
public class FilterServiceImpl implements FilterService{
	private static ArrayList<RecordTwitter> filteredJSON = new ArrayList<RecordTwitter>();
	public ArrayList<RecordTwitter> getFilterTweets(String filtro){
		filteredJSON.clear();
		JSONObject json = (JSONObject) JSONValue.parse(filtro);
		ArrayList<RecordTwitter> tweets = RecordService.getTweets();
		
		try {
			CheckJSON.check(json);
		}catch(InvalidJSONException e){
			filteredJSON.add((new RecordTwitter(e.toString())));
			return filteredJSON;
		}
		
		String[] filter = FilterSplitter.split(json);
		
		if (filter[0].contains("$")) {
			return CollectionFilter.compare(filter[0], (JSONArray)json.get(filter[0]));
		}
		
		Object value = ((JSONObject) (((JSONObject) json).get(filter[0]))).get(filter[1]);
		
		for(RecordTwitter record: tweets) {
			try {
				Method m = record.getClass().getMethod("get"+filter[0].substring(0, 1).toUpperCase()+filter[0].substring(1),null);
				
				try {
					Object record_value = m.invoke(record);
					try {
						CheckType.check(record_value, value);
					} catch (InvalidTypeException e) {
						filteredJSON.add(new RecordTwitter(e.toString()));			
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
