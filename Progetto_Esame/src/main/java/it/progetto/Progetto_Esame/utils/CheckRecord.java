package it.progetto.Progetto_Esame.utils;

import it.progetto.Progetto_Esame.exceptions.EmptyRecordException;

/**
 * <p>
 * 	<b>Classe</b> <i>CheckRecord</i> per il controllo di record vuoti in caso di filtri errati
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class CheckRecord{
	/**
	 * Metodo che controlla se l'oggetto passatogli è nullo e, in caso affermativo, lancia l'eccezione
	 * @param r record da controllare
	 * @throws EmptyRecordException se il record è vuoto {@link it.progetto.Progetto_Esame.exceptions.EmptyRecordException}
	 */
	public static void check(Object r) throws EmptyRecordException{
		if (r == null)
			throw new EmptyRecordException("Campo vuoto a causa di un filtro errato!");
	}
}
