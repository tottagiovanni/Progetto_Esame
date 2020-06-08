package it.progetto.Progetto_Esame.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import it.progetto.Progetto_Esame.model.*;

/**
 * <p>
 * 	<b>Interfaccia</b> <i>JSONService</i> per la restituzione di tutti i tweets
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
@Service
public interface JSONService {
	/**
	 * Intestazione del metodo che restituisce tutti i tweets
	 * @return ArrayList di RecordTwitter
	 * @see it.progetto.Progetto_Esame.service.JSONServiceImpl#getAllTweets()
	 */
	public abstract ArrayList<RecordTwitter> getAllTweets();
}
