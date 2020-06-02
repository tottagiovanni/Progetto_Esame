package it.progetto.Progetto_Esame.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.json.simple.*;

import org.springframework.stereotype.Service;

import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.utils.CollectionFilter;
//import it.progetto.Progetto_Esame.utils.CollectionFilter;
import it.progetto.Progetto_Esame.utils.FilterSplitter;
import it.progetto.Progetto_Esame.utils.NumericalFilter;
import it.progetto.Progetto_Esame.utils.StringFilter;

@Service
public class FilterServiceImpl implements FilterService{
	public ArrayList<RecordTwitter> getFilterTweets(String filtro){
		JSONObject json = (JSONObject) JSONValue.parse(filtro);
		ArrayList<RecordTwitter> tweets = RecordService.getTweets();
		String[] filter = FilterSplitter.split(json);
		
		if (filter[0].contains("$")) {
			//JSONArray j_arr = (JSONArray) json.get(filter[0]);
			return CollectionFilter.compare(filter[0], (JSONArray)json.get(filter[0]));
		}
		
		Object value = ((JSONObject) (((JSONObject) json).get(filter[0]))).get(filter[1]);
		
		ArrayList<RecordTwitter> filteredJSON = new ArrayList<RecordTwitter>();
		for(RecordTwitter record: tweets) {
			try {
				Method m = record.getClass().getMethod("get"+filter[0].substring(0, 1).toUpperCase()+filter[0].substring(1),null);
				
				try {
					Object record_value = m.invoke(record);
					if (value instanceof Number)
						if (NumericalFilter.compare(record_value, value, filter[1]))
							filteredJSON.add(record);
					
					/*if (value instanceof Collection)
						if (CollectionFilter.compare(value, filter[0]))
							filteredJSON.add(record);*/
					
					if (value instanceof String)
						if(StringFilter.compare(record_value, value, filter[1]))
							filteredJSON.add(record);
					
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
		}
		
		
		return filteredJSON;
	}
}
