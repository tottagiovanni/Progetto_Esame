package it.progetto.Progetto_Esame.model;

public class RecordTwitter {
	private String id_post;
	private String date;
	private String name;
	private String text;
	private long followers;
	private long like;
	private long retweet;
	private String nation;
	private String device;
	private long hashtags;
	
	public RecordTwitter() {
		super();
	}
	
	public RecordTwitter(String text) {
		super();
		this.text = text;
	}

	public long getFollowers() {
		return followers;
	}

	public void setFollowers(long followers) {
		this.followers = followers;
	}
	
	public String getId_post() {
		return id_post;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setId_post(String id_post) {
		this.id_post = id_post;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getLike() {
		return like;
	}
	public void setLike(long like) {
		this.like = like;
	}
	public long getRetweet() {
		return retweet;
	}
	public void setRetweet(long retweet) {
		this.retweet = retweet;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}

	public long getHashtags() {
		return hashtags;
	}

	public void setHashtags(long hashtags) {
		this.hashtags = hashtags;
	}
	
	
	
}
