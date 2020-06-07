package it.progetto.Progetto_Esame.model;

/**
 * <p>
 * 	<b>Classe</b> <i>MetadataTwitter</i> per la creazione di oggetti MetadataTwitter
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class MetadataTwitter {
	/**
	 * Indica il nome del campo
	 */
	private String name;
	/**
	 * Indica la descrizione del campo
	 */
	private String description;
	/**
	 * Indica il tipo del campo
	 */
	private String type;
	
	/**
	 * Costruttore che inizializza gli attributi delle classe
	 * @param name nome campo
	 * @param description descrizione campo
	 * @param type tipo campo
	 */
	public MetadataTwitter(String name, String description, String type){
		super();
		this.name = name;
		this.description = description;
		this.type = type;
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
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo get per l'attributo description
	 * @return attributo description di tipo <code>String</code>
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metodo set per l'attributo description
	 * @param description
	 */
 	public void setDescription(String description) {
		this.description = description;
	}

 	/**
 	 * Metodo get per l'attributo type
 	 * @return attributo type di tipo <code>String</code>
 	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Metodo set per l'attributo type
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
}
