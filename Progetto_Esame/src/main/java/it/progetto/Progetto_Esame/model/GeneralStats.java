package it.progetto.Progetto_Esame.model;

/**
 * <p>
 * 	<b>Classe</b> <i>GeneralStats</i> per le statistiche generali dei tweets
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class GeneralStats {
	/**
	 * Indica il numero totale di tweets
	 */
	private Long num_tweets;
	
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
	 * Indica la somma totale dei like
	 */
	private Long sum_like;
	
	/**
	 * Indica la media dei retweet totali
	 */
	private Long avg_retweet;
	
	/**
	 * Indica il massimo tra i retweet 
	 */
	private Long max_retweet;
	
	/**
	 * Indica il minimo tra i retweet
	 */
	private Long min_retweet;
	
	/**
	 * Indica la somma totale dei retweet
	 */
	private Long sum_retweet;
	
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
	 * Indica la somma totale dei follower
	 */
	private Long sum_follower;
	
	/**
	 * Costruttore che inizializza tutti gli attributi delle classe
	 * @param num_tweets numero totale di tweets
	 * @param avg_like media dei like totali
	 * @param max_like massimo tra tutti i like
	 * @param min_like minimo tra tutti i like
	 * @param sum_like somma totale dei like
	 * @param avg_retweet media dei retweet totali
	 * @param max_retweet massimo tra i retweet 
	 * @param min_retweet minimo tra i retweet
	 * @param sum_retweet somma totale dei retweet
	 * @param avg_follower media dei follower totali
	 * @param max_follower massimo tra i follower
	 * @param min_follower minimo tra i follower
	 * @param sum_follower somma totale dei follower
	 */
	public GeneralStats(Long num_tweets, Long avg_like, Long max_like, Long min_like, Long sum_like, Long avg_retweet,
			Long max_retweet, Long min_retweet, Long sum_retweet, Long avg_follower, Long max_follower,
			Long min_follower, Long sum_follower) {
		super();
		this.num_tweets = num_tweets;
		this.avg_like = avg_like;
		this.max_like = max_like;
		this.min_like = min_like;
		this.sum_like = sum_like;
		this.avg_retweet = avg_retweet;
		this.max_retweet = max_retweet;
		this.min_retweet = min_retweet;
		this.sum_retweet = sum_retweet;
		this.avg_follower = avg_follower;
		this.max_follower = max_follower;
		this.min_follower = min_follower;
		this.sum_follower = sum_follower;
	}

	/**
	 * Metodo get per l'attributo num_tweets
	 * @return attributo num_tweets di tipo <code>Long</code> 
	 */
	public Long getNum_tweets() {
		return num_tweets;
	}

	/**
	 * Metodo set per l'attributo num_tweets
	 * @param num_tweets numero totale di tweets
	 */
	public void setNum_tweets(Long num_tweets) {
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
	 * Metodo get per l'attributo sum_like
	 * @return attributo sum_like di tipo <code>Long</code> 
	 */
	public Long getSum_like() {
		return sum_like;
	}

	/**
	 * Metodo set per l'attributo sum_like
	 * @param sum_like somma totale dei like
	 */
	public void setSum_like(Long sum_like) {
		this.sum_like = sum_like;
	}

	/**
	 * Metodo get per l'attributo avg_retweet
	 * @return attributo avg_retweet di tipo <code>Long</code> 
	 */
	public Long getAvg_retweet() {
		return avg_retweet;
	}

	/**
	 * Metodo set per l'attributo avg_retweet
	 * @param avg_retweet media dei retweet totali
	 */
	public void setAvg_retweet(Long avg_retweet) {
		this.avg_retweet = avg_retweet;
	}

	/**
	 * Metodo get per l'attributo max_retweet
	 * @return attributo max_retweet di tipo <code>Long</code> 
	 */
	public Long getMax_retweet() {
		return max_retweet;
	}

	/**
	 * Metodo set per l'attributo max_retweet
	 * @param max_retweet massimo tra tutti i retweet
	 */
	public void setMax_retweet(Long max_retweet) {
		this.max_retweet = max_retweet;
	}

	/**
	 * Metodo get per l'attributo min_retweet
	 * @return attributo min_retweet di tipo <code>Long</code> 
	 */
	public Long getMin_retweet() {
		return min_retweet;
	}

	/**
	 * Metodo set per l'attributo min_retweet
	 * @param min_retweet minimo tra tutti i retweet
	 */
	public void setMin_retweet(Long min_retweet) {
		this.min_retweet = min_retweet;
	}

	/**
	 * Metodo get per l'attributo sum_retweet
	 * @return attributo sum_retweet di tipo <code>Long</code> 
	 */
	public Long getSum_retweet() {
		return sum_retweet;
	}

	/**
	 * Metodo set per l'attributo sum_retweet
	 * @param sum_retweet somma totale dei retweet
	 */
	public void setSum_retweet(Long sum_retweet) {
		this.sum_retweet = sum_retweet;
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

	/**
	 * Metodo get per l'attributo sum_follower
	 * @return attributo sum_follower di tipo <code>Long</code> 
	 */
	public Long getSum_follower() {
		return sum_follower;
	}

	/**
	 * Metodo set per l'attributo sum_follower
	 * @param sum_follower somma totale dei follower
	 */
	public void setSum_follower(Long sum_follower) {
		this.sum_follower = sum_follower;
	}
}
