package it.progetto.Progetto_Esame.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import it.progetto.Progetto_Esame.utils.*;

public class GestioneAPI {
	public static void caricamentoJSON(String url) {
		try {
			URLConnection openConnection = new URL(url).openConnection();
			InputStream in = openConnection.getInputStream();
			
			String data = "";
			String line = "";
			InputStreamReader inR = new InputStreamReader(in);
			BufferedReader buf = new BufferedReader(inR);
			
			while((line = buf.readLine()) != null)
				data += line;
			
			JSONObject json = (JSONObject) JSONValue.parse(data);
			
			JSONArray jarr = (JSONArray) json.get("statuses");
			
			
			JSONArray nuovo = new JSONArray();
			for (Object o: jarr) {
				JSONObject j = new JSONObject();
				//JSONObject o = (JSONObject)jarr.get(i);
				j.put("Id_post", (((JSONObject) o).get("id_str")));
	          
	            j.put("Name", ((JSONObject) (((JSONObject) o).get("user"))).get("name"));
	            
	            j.put("Followers", ((JSONObject) (((JSONObject) o).get("user"))).get("followers_count"));
	         
	            j.put("Paese", (((JSONObject) o).get("lang")));
	            j.put("Amici", ((JSONObject) (((JSONObject) o).get("user"))).get("favourites_count"));
	            j.put("Like", (((JSONObject) o).get("favorite_count")));
	            //int s = (Integer)(((JSONObject) o).get("favorite_count"));
	            
	            j.put("Retweet", (((JSONObject) o).get("retweet_count")));
	           
	            j.put("Text", (((JSONObject) o).get("text")));
	            String device = RimuoviTag.rimuovi((String) (((JSONObject) o).get("source")));
	            j.put("Device", device);
	            
	            nuovo.add(j);
			}
			
			FileJson.newJSON(nuovo);
		}
		catch(MalformedURLException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
