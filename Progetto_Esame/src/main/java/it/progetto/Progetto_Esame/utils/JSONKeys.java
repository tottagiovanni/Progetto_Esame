package it.progetto.Progetto_Esame.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONKeys { 
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
