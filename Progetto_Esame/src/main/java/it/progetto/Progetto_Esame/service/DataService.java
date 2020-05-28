package it.progetto.Progetto_Esame.service;

import java.io.*;
import java.net.*;
import java.util.*;

import org.json.simple.*;

import it.progetto.Progetto_Esame.utils.RimuoviTag;


public class DataService {
	private static ArrayList<RecordTwitter> tweets= new ArrayList<>();
	
	
	public DataService() {
	}
	
	public static void setTweets(){
		final int COUNT = 5;
		
		URL query = null;
		try {
			query = new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=covid19&result_type=popular&count="+COUNT);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
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
        
        JSONObject json = (JSONObject) JSONValue.parse(data);       
        JSONArray jsonArray = (JSONArray) json.get("statuses");
        

        for(Object o : jsonArray) {
        	RecordTwitter tweet = new RecordTwitter();
            tweet.setName(((JSONObject) (((JSONObject) o).get("user"))).get("name"));
            tweet.setNation(((JSONObject) o).get("lang"));
            tweet.setFollowers(((JSONObject) (((JSONObject) o).get("user"))).get("followers_count"));
            tweet.setLike(((JSONObject) o).get("favorite_count"));
            tweet.setRetweet(((JSONObject) o).get("retweet_count"));
            tweet.setText(((JSONObject) o).get("text"));
            tweet.setPlatform(RimuoviTag.rimuovi((String) (((JSONObject) o).get("source"))));
            tweets.add(tweet);
       }
	}   
	public static ArrayList<RecordTwitter> getTweets() {
		return tweets;
	}
}
