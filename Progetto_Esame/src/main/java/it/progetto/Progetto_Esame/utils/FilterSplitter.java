package it.progetto.Progetto_Esame.utils;

import org.json.simple.JSONObject;

public class FilterSplitter {
	public static String[] split(JSONObject json) {
		String[] str_arr = new String[2];
 		String s = json.toString();
		String field = s.split("\\\"")[1];
		String operator = s.split("\\\"")[3];
		str_arr[0] = field;
		str_arr[1] = operator;
			
		return str_arr;
	}
}
