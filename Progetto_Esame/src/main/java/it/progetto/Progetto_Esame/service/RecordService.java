package it.progetto.Progetto_Esame.service;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.utils.RemoveTag;

/**
 * <p>
 * 	<b>Classe</b> <i>RecordService</i> per la gestione e il salvataggio dei dati json in un ArrayList
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class RecordService {
	/**
	 * Indica un ArrayList di RecordTwitter
	 */
	private static ArrayList<RecordTwitter> tweets= new ArrayList<>();

	/**
	 * Costruttore che carica i dati in formato json in un ArrayList di RecordTwitter
	 * @param data stringa contenente i tweets in formato json
	 */
	public RecordService(String data) {
		tweets.clear();
		JSONObject json = (JSONObject) JSONValue.parse(data);       
        JSONArray jsonArray = (JSONArray) json.get("statuses");
        

        for(Object o : jsonArray) {
        	RecordTwitter tweet = new RecordTwitter();
        	tweet.setId_post((String)((JSONObject) o).get("id_str"));
        	tweet.setDate((String)((JSONObject) o).get("created_at"));
            tweet.setName((String)((JSONObject) (((JSONObject) o).get("user"))).get("name"));
            tweet.setNation((String)((JSONObject) o).get("lang"));
            tweet.setFollowers((Long)((JSONObject) (((JSONObject) o).get("user"))).get("followers_count"));
            tweet.setLike((Long)((JSONObject) o).get("favorite_count"));
            tweet.setRetweet((Long)((JSONObject) o).get("retweet_count"));
            tweet.setText((String)((JSONObject) o).get("text"));
            tweet.setDevice(RemoveTag.remove((String) (((JSONObject) o).get("source"))));
            JSONArray hashtags = (JSONArray)((JSONObject) (((JSONObject) o).get("entities"))).get("hashtags");
            tweet.setHashtags(hashtags.size());
            tweets.add(tweet);
        }
	}
	
	/**
	 * Metodo che restituisce l'ArrayList di RecordTwitter
	 * @return ArrayList di RecordTwitter
	 */
	public static ArrayList<RecordTwitter> getTweets() {
		return tweets;
	}

	/**
	 * Metodo che restituisce il tweet corrispondente all'id passato come parametro
	 * @param id_post id che identifica il tweet
	 * @return oggetto di tipo RecordTwitter
	 */
	public static RecordTwitter getRecord(String id_post) {
		for(RecordTwitter tweet: tweets) {
			if(tweet.getId_post().equals(id_post)) {
				return tweet;
			}
		}
		return null;
	}
}
