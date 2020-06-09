package it.progetto.Progetto_Esame.model;

/**
 * <p>
 * 	<b>Classe</b> <i>RecordTwitter</i> per la creazione di oggetti RecordTwitter
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class RecordTwitter {
	/**
	 * Indica l'id del tweet
	 */
	private String id_post;
	/**
	 * Indica la data del tweet
	 */
	private String date;
	/**
	 * Indica il nome dell'autore del tweet
	 */
	private String name;
	/**
	 * Indica il testo del tweet
	 */
	private String text;
	/**
	 * Indica i followers dell'autore del tweet
	 */
	private long followers;
	/**
	 * Indica i like al tweet
	 */
	private long like;
	/**
	 * Indica i retweet del tweet
	 */
	private long retweet;
	/**
	 * Indica la nazione da dove è scritto il tweet
	 */
	private String nation;
	/**
	 * Indica il dispositivo dal quale è scritto il tweet
	 */
	private String device;
	/**
	 * Indica il numero di hashtag del tweet
	 */
	private long hashtags;
	
	/**
	 * Costruttore di default della classe
	 */
	public RecordTwitter() {
		super();
	}
	
	/**
	 * Costruttore che inizializza gli attributi della classe
	 * @param id_post id del tweet
	 * @param date data del tweet
	 * @param name nome dell'autore del tweet
	 * @param text testo del tweet
	 * @param followers followers dell'autore del tweet
	 * @param like like al tweet
	 * @param retweet retweet del tweet
	 * @param nation nazione del tweet
	 * @param device dispositivo dell'autore del tweet
	 * @param hashtags numero di hashtags del tweet
	 */
	public RecordTwitter(String id_post, String date, String name, String text, long followers, long like, long retweet,
			String nation, String device, long hashtags) {
		super();
		this.id_post = id_post;
		this.date = date;
		this.name = name;
		this.text = text;
		this.followers = followers;
		this.like = like;
		this.retweet = retweet;
		this.nation = nation;
		this.device = device;
		this.hashtags = hashtags;
	}

	/**
	 * Costruttore che inizializza il testo del tweet
	 * @param text testo del tweet
	 */
	public RecordTwitter(String text) {
		super();
		this.text = text;
	}
	
	/**
	 * Metodo get per l'attributo followers
	 * @return attributo followers di tipo <code>Long</code> 
	 */
	public long getFollowers() {
		return followers;
	}

	/**
	 * Metodo set per l'attributo followers
	 * @param followers followers dell'autore del tweet
	 */
	public void setFollowers(long followers) {
		this.followers = followers;
	}
	
	/**
	 * Metodo get per l'attributo id_post
	 * @return attributo id_post di tipo <code>String</code> 
	 */
	public String getId_post() {
		return id_post;
	}
	
	/**
	 * Metodo set per l'attributo id_post
	 * @param id_post id del tweet
	 */
	public void setId_post(String id_post) {
		this.id_post = id_post;
	}
	
	/**
	 * Metodo get per l'attributo date
	 * @return attributo date di tipo <code>String</code> 
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Metodo set per l'attributo date
	 * @param date data del tweet
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * Metodo get per l'attributo name
	 * @return attributo name di tipo <code>String</code> 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Metodo set per l'attributo name
	 * @param name nome dell'autore del tweet
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Metodo get per l'attributo text
	 * @return attributo text di tipo <code>String</code> 
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Metodo set per l'attributo text
	 * @param text testo del tweet
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Metodo get per l'attributo like
	 * @return attributo like di tipo <code>Long</code> 
	 */
	public long getLike() {
		return like;
	}
	
	/**
	 * Metodo set per l'attributo like
	 * @param like like al tweet
	 */
	public void setLike(long like) {
		this.like = like;
	}
	
	/**
	 * Metodo get per l'attributo retweet
	 * @return attributo retweet di tipo <code>Long</code> 
	 */
	public long getRetweet() {
		return retweet;
	}
	
	/**
	 * Metodo set per l'attributo retweet
	 * @param retweet retweet del tweet
	 */
	public void setRetweet(long retweet) {
		this.retweet = retweet;
	}
	
	/**
	 * Metodo get per l'attributo nation
	 * @return attributo nation di tipo <code>String</code> 
	 */
	public String getNation() {
		return nation;
	}
	
	/**
	 * Metodo set per l'attributo nation
	 * @param nation nazione del tweet
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	/**
	 * Metodo get per l'attributo device
	 * @return attributo device di tipo <code>String</code> 
	 */
	public String getDevice() {
		return device;
	}
	
	/**
	 * Metodo set per l'attributo device
	 * @param device dispositivo dell'autore del tweet
	 */
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	 * Metodo get per l'attributo hashtags
	 * @return attributo hashtags di tipo <code>Long</code> 
	 */
	public long getHashtags() {
		return hashtags;
	}

	/**
	 * Metodo set per l'attributo hashtags
	 * @param hashtags numero di hashtags del tweet
	 */
	public void setHashtags(long hashtags) {
		this.hashtags = hashtags;
	}
	
	
	
}
