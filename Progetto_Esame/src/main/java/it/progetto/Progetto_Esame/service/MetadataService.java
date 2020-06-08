package it.progetto.Progetto_Esame.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import it.progetto.Progetto_Esame.model.MetadataTwitter;

/**
 * <p>
 * 	<b>Classe</b> <i>MetadataService</i> per la creazione di un ArrayList di MetadataTwitter
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @see it.progetto.Progetto_Esame.model.MetadataTwitter
 * @version 1.0
 */
@Service
public class MetadataService {
	/**
	 * Indica un ArrayList di MetadataTwitter
	 */
	private static ArrayList<MetadataTwitter> metadati = new ArrayList<>();
	
	/**
	 * Costruttore che aggiunge oggetti MetadataTwitter all'ArrayList
	 */
	public MetadataService(){
		metadati.add(new MetadataTwitter("id_post", "Numero identificativo del post", "String"));
		metadati.add(new MetadataTwitter("data", "Data e ora di creazione del post", "String"));
		metadati.add(new MetadataTwitter("name", "Nome dell'utente del post", "String"));
		metadati.add(new MetadataTwitter("text", "Testo del post", "String"));
		metadati.add(new MetadataTwitter("followers", "Numero di followers dell'utente del post", "Long"));
		metadati.add(new MetadataTwitter("like", "Numero di like al post", "Long"));
		metadati.add(new MetadataTwitter("retweet", "Numero di retweet del post", "Long"));
		metadati.add(new MetadataTwitter("nation", "Nazione nella quale è stato scritto il post", "String"));
		metadati.add(new MetadataTwitter("device", "Dispositivo dal quale è stato scritto il post", "String"));
		metadati.add(new MetadataTwitter("hashtags", "Numero di hashtags in un post", "Long"));
	}
	
	/**
	 * Metodo che restituisce l'ArrayList di MetadataTwitter
	 * @return ArrayList di MetadataTwitter
	 */
	public ArrayList<MetadataTwitter> getMetadata(){
		return metadati;
	}
}
