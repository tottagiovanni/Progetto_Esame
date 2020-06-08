package it.progetto.Progetto_Esame.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import it.progetto.Progetto_Esame.model.RecordTwitter;

/**
 * <p>
 * 	<b>Interfaccia</b> <i>FilterService</i> per la restituzione dei tweets filtrati
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
@Service
public interface FilterService {
	/**
	 * Intestazione del metodo che restituisce i tweets filtrati
	 * @param filtro filtro applicato alla ricerca
	 * @return ArrayList di RecordTwitter
	 * @see it.progetto.Progetto_Esame.service.FilterServiceImpl#getFilterTweets(String)
	 */
	public abstract ArrayList<RecordTwitter> getFilterTweets(String filtro);
}
