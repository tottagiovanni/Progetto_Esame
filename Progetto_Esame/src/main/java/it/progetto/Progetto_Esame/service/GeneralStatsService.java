package it.progetto.Progetto_Esame.service;

import java.util.ArrayList;

import it.progetto.Progetto_Esame.model.GeneralStats;
import it.progetto.Progetto_Esame.model.RecordTwitter;

import it.progetto.Progetto_Esame.utils.Statistics;

/**
 * <p>
 * 	<b>Classe</b> <i>GeneralStatsService</i> per caricare le statistiche generali sui tweets
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @see it.progetto.Progetto_Esame.model.GeneralStats
 * @version 1.0
 */
public class GeneralStatsService {
	
	/**
	 * Indica l'ArrayList di RecordTwitter con tutti i tweets
	 */
	private ArrayList<RecordTwitter> tweets  = RecordService.getTweets();
	
	/**
	 * Indica un oggetto GeneralStats contenente le statistiche generali
	 */
	private GeneralStats generalStats = new GeneralStats();
	
	/**
	 * Costruttore che carica le statistiche generali
	 */
	public GeneralStatsService() {
		this.setGeneralFollowersStats();
		this.setGeneralRetweetStats();
		this.setGeneralLikeStats();
		generalStats.setNum_tweets(tweets.size());
	}

	/**
	 * Metodo che calcola le statistiche generali sui like
	 * @see it.progetto.Progetto_Esame.utils.Statistics
	 */
	public void setGeneralLikeStats() {
		ArrayList<Long> likes = new ArrayList<>();
		
		for(RecordTwitter tweet:tweets)
			likes.add(tweet.getLike());

		generalStats.setAvg_like(Statistics.avg(likes));
		generalStats.setMin_like(Statistics.min(likes));
		generalStats.setMax_like(Statistics.max(likes));
		
	}
	
	/**
	 * Metodo che calcola le statistiche generali sui followers
	 * @see it.progetto.Progetto_Esame.utils.Statistics
	 */
	public void setGeneralFollowersStats() {
		ArrayList<Long> followers = new ArrayList<>();
		
		for(RecordTwitter tweet:tweets)
			followers.add(tweet.getFollowers());

		generalStats.setAvg_follower(Statistics.avg(followers));
		generalStats.setMin_follower(Statistics.min(followers));
		generalStats.setMax_follower(Statistics.max(followers));
		
	}
	
	/**
	 * Metodo che calcola le statistiche generali sui retweet
	 * @see it.progetto.Progetto_Esame.utils.Statistics
	 */
	public void setGeneralRetweetStats() {
		ArrayList<Long> retweets = new ArrayList<>();
		
		for(RecordTwitter tweet:tweets)
			retweets.add(tweet.getRetweet());

		generalStats.setNum_retweet(Statistics.sum(retweets));
		
	}
	
	/**
	 * Metodo che restituisce le statistiche generali
	 * @return oggetto GeneralStats contenente le statistiche
	 */
	public GeneralStats getGeneralStats() {
		return generalStats;
	}
	
}
