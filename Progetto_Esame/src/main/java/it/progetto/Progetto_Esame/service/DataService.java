package it.progetto.Progetto_Esame.service;

import java.io.*;
import java.net.*;
import java.util.*;

import org.json.simple.*;

import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.utils.PersistenceJSON;
import it.progetto.Progetto_Esame.utils.RimuoviTag;


public class DataService {
	private static ArrayList<RecordTwitter> tweets= new ArrayList<>();
	
	
	public DataService() {
	}
	
	public static void setTweets(URL query){
	    URLConnection yc = null;
		try {
			yc = query.openConnection();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	    BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    
	    
	    String inputLine = "";
	    String data = "";
	
	    try {
			while ((inputLine = in.readLine()) != null)
				data += inputLine;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    
	    PersistenceJSON.writeJSONFile(data);
        
        JSONObject json = (JSONObject) JSONValue.parse(data);       
        JSONArray jsonArray = (JSONArray) json.get("statuses");
        

        for(Object o : jsonArray) {
        	RecordTwitter tweet = new RecordTwitter();
        	tweet.setId_post((String)((JSONObject) o).get("id_str"));
            tweet.setName((String)((JSONObject) (((JSONObject) o).get("user"))).get("name"));
            tweet.setNation((String)((JSONObject) o).get("lang"));
            tweet.setFollowers((Long)((JSONObject) (((JSONObject) o).get("user"))).get("followers_count"));
            tweet.setLike((Long)((JSONObject) o).get("favorite_count"));
            tweet.setRetweet((Long)((JSONObject) o).get("retweet_count"));
            tweet.setText((String)((JSONObject) o).get("text"));
            tweet.setDevice(RimuoviTag.rimuovi((String) (((JSONObject) o).get("source"))));
            tweets.add(tweet);
       }
	}  
	
	public static void setLocalTweets(){
		
	}
	
	
	public static ArrayList<RecordTwitter> getTweets() {
		return tweets;
	}
}
