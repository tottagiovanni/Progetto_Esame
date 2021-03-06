package it.progetto.Progetto_Esame.utils;

import it.progetto.Progetto_Esame.exceptions.InvalidRequestException;

/**
 * <p>
 * 	<b>Classe</b> <i>CheckRequest</i> per il controllo di parametri mancanti nelle richieste
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class CheckRequest {
	
	/**
	 * Metodo che controlla se il parametro passatogli è vuoto e, in caso affermativo, lancia l'eccezione
	 * @param param parametro da controllare
	 * @throws InvalidRequestException se il parametro richiesto manca {@link it.progetto.Progetto_Esame.exceptions.InvalidRequestException}
	 */
	public static void check(Object param) throws InvalidRequestException{
		if (param == null)
			throw new InvalidRequestException("Parametro filter mancante!");
		else if (param.equals(""))
			throw new InvalidRequestException("Parametro field mancante!");
	}
}
