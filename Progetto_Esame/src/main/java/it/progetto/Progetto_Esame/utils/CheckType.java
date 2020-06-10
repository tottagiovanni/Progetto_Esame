package it.progetto.Progetto_Esame.utils;

import it.progetto.Progetto_Esame.exceptions.InvalidTypeException;

/**
 * <p>
 * 	<b>Classe</b> <i>CheckType</i> per il controllo di tipi di dato non corrispondenti
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class CheckType {
	
	/**
	 * Metodo che controlla se i tipi di dato sono diversi e, in caso affermativo, lancia l'eccezione
	 * @param r valore dell'attributo di un record presente nell'ArrayList
	 * @param v valore passatogli per filtrare i dati
	 * @throws InvalidTypeException se i tipi di dato non corrispondono {@link it.progetto.Progetto_Esame.exceptions.InvalidTypeException}
	 */
	public static void check(Object r, Object v) throws InvalidTypeException{
		if (r.getClass() != v.getClass()) {
			throw new InvalidTypeException("Tipo di dato da filtare non valido! Inserire campo di tipo: "+r.getClass());
		}
	}
}
