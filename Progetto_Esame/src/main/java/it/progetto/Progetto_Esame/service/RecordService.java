package it.progetto.Progetto_Esame.service;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.utils.RemoveTag;

public class RecordService {
	private static ArrayList<RecordTwitter> tweets= new ArrayList<>();

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
	public static ArrayList<RecordTwitter> getTweets() {
		return tweets;
	}


	public static RecordTwitter getRecord(String id_post) {
		for(RecordTwitter tweet: tweets) {
			if(tweet.getId_post().equals(id_post)) {
				return tweet;
			}
		}
		return null;
	}
}
