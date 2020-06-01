package it.progetto.Progetto_Esame.service;

import java.util.ArrayList;

import it.progetto.Progetto_Esame.model.MetadataTwitter;

public class MetadataService {
	private static ArrayList<MetadataTwitter> metadati = new ArrayList<>();
	
	public MetadataService(){
		metadati.add(new MetadataTwitter("id_post", "Numero identificativo del post", "String"));
		metadati.add(new MetadataTwitter("name", "Nome dell'utente del post", "String"));
		metadati.add(new MetadataTwitter("text", "Testo del post", "String"));
		metadati.add(new MetadataTwitter("followers", "Numero di followers dell'utente del post", "Long"));
		metadati.add(new MetadataTwitter("like", "Numero di like al post", "Long"));
		metadati.add(new MetadataTwitter("retweet", "Numero di retweet del post", "Long"));
		metadati.add(new MetadataTwitter("nation", "Nazione nella quale è stato scritto il post", "String"));
		metadati.add(new MetadataTwitter("device", "Dispositivo dal quale è stato scritto il post", "String"));
	}
	
	public ArrayList<MetadataTwitter> getMetadata(){
		return metadati;
	}
}
