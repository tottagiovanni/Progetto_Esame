package it.progetto.Progetto_Esame.service;

import java.util.ArrayList;

import it.progetto.Progetto_Esame.model.GeneralStats;
import it.progetto.Progetto_Esame.model.RecordTwitter;

import it.progetto.Progetto_Esame.utils.Statistics;

public class GeneralStatsService {
	private ArrayList<RecordTwitter> tweets  = RecordService.getTweets();
	private GeneralStats generalStats = new GeneralStats();
	
	public GeneralStatsService() {
		this.setGeneralFollowersStats();
		this.setGeneralRetweetStats();
		this.setGeneralLikeStats();
		generalStats.setNum_tweets(tweets.size());
	}

	public void setGeneralLikeStats() {
		ArrayList<Long> likes = new ArrayList<>();
		
		for(RecordTwitter tweet:tweets)
			likes.add(tweet.getLike());

		generalStats.setAvg_like(Statistics.avg(likes));
		generalStats.setMin_like(Statistics.min(likes));
		generalStats.setMax_like(Statistics.max(likes));
		
	}
	public void setGeneralFollowersStats() {
		ArrayList<Long> followers = new ArrayList<>();
		
		for(RecordTwitter tweet:tweets)
			followers.add(tweet.getFollowers());

		generalStats.setAvg_follower(Statistics.avg(followers));
		generalStats.setMin_follower(Statistics.min(followers));
		generalStats.setMax_follower(Statistics.max(followers));
		
	}
	public void setGeneralRetweetStats() {
		ArrayList<Long> retweets = new ArrayList<>();
		
		for(RecordTwitter tweet:tweets)
			retweets.add(tweet.getRetweet());

		generalStats.setNum_retweet(Statistics.sum(retweets));
		
	}
	
	public GeneralStats getGeneralStats() {
		return generalStats;
	}
	
}
