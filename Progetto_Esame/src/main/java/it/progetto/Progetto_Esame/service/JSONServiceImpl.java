package it.progetto.Progetto_Esame.service;


import java.util.ArrayList;

import org.springframework.stereotype.Service;

import it.progetto.Progetto_Esame.model.RecordTwitter;

/**
 * <p>
 * 	<b>Classe</b> <i>JSONServiceImpl</i> che implementa l'interfaccia JSONService
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
@Service
public class JSONServiceImpl implements JSONService{
	/**
	 * Implementazione del metodo che restituisce tutti i tweets
	 * @see it.progetto.Progetto_Esame.service.JSONServiceImpl#getAllTweets()
	 * @see it.progetto.Progetto_Esame.model.RecordService
	 * @return ArrayList di RecordTwitter
	 */
	public ArrayList<RecordTwitter> getAllTweets() {
		return RecordService.getTweets();
	}
}
