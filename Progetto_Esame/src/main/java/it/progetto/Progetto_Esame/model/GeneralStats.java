package it.progetto.Progetto_Esame.model;

/**
 * <p>
 * 	<b>Classe</b> <i>GeneralStats</i> per le statistiche generali dei tweets
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 * @see it.progetto.Progetto_Esame.service.GeneralStatsService
 */
public class GeneralStats {
	/**
	 * Indica il numero totale di tweets
	 */
	private int num_tweets;
	
	/**
	 * Indica la media dei like totali
	 */
	private Long avg_like;
	
	/**
	 * Indica il massimo tra tutti i like
	 */
	private Long max_like;
	
	/**
	 * Indica il minimo tra tutti i like
	 */
	private Long min_like;

	/**
	 * Indica la somma totale dei retweet
	 */
	private Long num_retweet;
	
	/**
	 * Indica la media dei follower totali
	 */
	private Long avg_follower;
	
	/**
	 * Indica il massimo tra i follower
	 */
	private Long max_follower;
	
	/**
	 * Indica il minimo tra i follower
	 */
	private Long min_follower;
	

	/**
	 * Costruttore di default della classe
	 */
	public GeneralStats() {
		
	}
	
	/**
	 * Costruttore che inizializza tutti gli attributi delle classe
	 * @param num_tweets numero totale di tweets
	 * @param avg_like media dei like totali
	 * @param max_like massimo tra tutti i like
	 * @param min_like minimo tra tutti i like
	 * @param num_retweet somma totale dei retweet
	 * @param avg_follower media dei follower totali
	 * @param max_follower massimo tra i follower
	 * @param min_follower minimo tra i follower
	 */
	public GeneralStats(int num_tweets, Long avg_like, Long max_like, Long min_like, Long num_retweet, Long avg_follower, Long max_follower,
			Long min_follower) {
		super();
		this.num_tweets = num_tweets;
		this.avg_like = avg_like;
		this.max_like = max_like;
		this.min_like = min_like;
		this.num_retweet = num_retweet;
		this.avg_follower = avg_follower;
		this.max_follower = max_follower;
		this.min_follower = min_follower;
	}

	/**
	 * Metodo get per l'attributo num_tweets
	 * @return attributo num_tweets di tipo <code>Long</code> 
	 */
	public int getNum_tweets() {
		return num_tweets;
	}

	/**
	 * Metodo set per l'attributo num_tweets
	 * @param num_tweets numero totale di tweets
	 */
	public void setNum_tweets(int num_tweets) {
		this.num_tweets = num_tweets;
	}

	/**
	 * Metodo get per l'attributo avg_like
	 * @return attributo avg_like di tipo <code>Long</code> 
	 */
	public Long getAvg_like() {
		return avg_like;
	}

	/**
	 * Metodo set per l'attributo avg_like
	 * @param avg_like media dei like totali
	 */
	public void setAvg_like(Long avg_like) {
		this.avg_like = avg_like;
	}

	/**
	 * Metodo get per l'attributo max_like
	 * @return attributo max_like di tipo <code>Long</code> 
	 */
	public Long getMax_like() {
		return max_like;
	}

	/**
	 * Metodo set per l'attributo max_like
	 * @param max_like massimo tra tutti i like
	 */
	public void setMax_like(Long max_like) {
		this.max_like = max_like;
	}

	/**
	 * Metodo get per l'attributo min_like
	 * @return attributo min_like di tipo <code>Long</code> 
	 */
	public Long getMin_like() {
		return min_like;
	}

	/**
	 * Metodo set per l'attributo min_like
	 * @param min_like minimo tra tutti i like
	 */
	public void setMin_like(Long min_like) {
		this.min_like = min_like;
	}

	/**
	 * Metodo get per l'attributo num_retweet
	 * @return attributo num_retweet di tipo <code>Long</code> 
	 */
	public Long getNum_retweet() {
		return num_retweet;
	}

	/**
	 * Metodo set per l'attributo num_retweet
	 * @param num_retweet somma totale dei retweet
	 */
	public void setNum_retweet(Long num_retweet) {
		this.num_retweet = num_retweet;
	}

	/**
	 * Metodo get per l'attributo avg_follower
	 * @return attributo avg_follower di tipo <code>Long</code> 
	 */
	public Long getAvg_follower() {
		return avg_follower;
	}

	/**
	 * Metodo set per l'attributo avg_follower
	 * @param avg_follower media dei follower totali
	 */
	public void setAvg_follower(Long avg_follower) {
		this.avg_follower = avg_follower;
	}

	/**
	 * Metodo get per l'attributo max_follower
	 * @return attributo max_follower di tipo <code>Long</code> 
	 */
	public Long getMax_follower() {
		return max_follower;
	}

	/**
	 * Metodo set per l'attributo max_follower
	 * @param max_follower massimo tra tutti i follower
	 */
	public void setMax_follower(Long max_follower) {
		this.max_follower = max_follower;
	}

	/**
	 * Metodo get per l'attributo min_follower
	 * @return attributo min_follower di tipo <code>Long</code> 
	 */
	public Long getMin_follower() {
		return min_follower;
	}

	/**
	 * Metodo set per l'attributo min_follower
	 * @param min_follower minimo tra tutti i follower
	 */
	public void setMin_follower(Long min_follower) {
		this.min_follower = min_follower;
	}

}
