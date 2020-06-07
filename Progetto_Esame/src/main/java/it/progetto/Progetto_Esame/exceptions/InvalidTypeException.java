package it.progetto.Progetto_Esame.exceptions;

/**
 * <p>
 * 	<b>Classe</b> <i>InvalidTypeException</i> per i tipi di filtro errati
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 * @see it.progetto.Progetto_Esame.utils.CheckType#check
 */
public class InvalidTypeException extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore della classe
	 * @param message messaggio da visualizzare se si verifica l'eccezione
	 */
	public InvalidTypeException(String message){
		super(message);
	}
}
