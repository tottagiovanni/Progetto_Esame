package it.progetto.Progetto_Esame.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.model.StatsTwitter;

/**
 * <p>
 * 	<b>Interfaccia</b> <i>StatsService</i> per la restituzione delle statistiche
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
@Service
public interface StatsService {
	/**
	 * Intestazione del metodo che restituisce le statistiche su tutti i tweets
	 * @param field campo sul quale effettuare le statistiche
	 * @return oggetto StatsTwitter contenente le statistiche
	 * @see it.progetto.Progetto_Esame.service.StatsServiceImpl#getStats(String)
	 */
	public abstract StatsTwitter getStats(String field);
	
	/**
	 * Intestazione del metodo che restituisce le statistiche sui tweets filtrati
	 * @param field campo sul quale effettuare le statistiche
	 * @param tweets ArrayList dei tweets filtrati
	 * @return oggetto StatsTwitter contenente le statistiche
	 * @see it.progetto.Progetto_Esame.service.StatsServiceImpl#getStats(String, ArrayList)
  	 */
	public abstract StatsTwitter getStats(String field, ArrayList<RecordTwitter> tweets);
}
