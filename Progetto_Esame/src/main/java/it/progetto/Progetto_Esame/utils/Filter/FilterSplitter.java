package it.progetto.Progetto_Esame.utils.Filter;

import org.json.simple.JSONObject;

public class FilterSplitter {
	public static String[] split(JSONObject json) {
 		String s = json.toString();
		String field = s.split("\\\"")[1];
		String operator = s.split("\\\"")[3];
		
		String [] str_arr = {field, operator};
			
		return str_arr;
	}
}
