package it.progetto.Progetto_Esame.utils;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONValues {
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
