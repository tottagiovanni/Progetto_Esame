package it.progetto.Progetto_Esame.exceptions;

/**
 * <p>
 * 	<b>Classe</b> <i>InvalidRequestException</i> per le richieste errate
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 * @see it.progetto.Progetto_Esame.utils.CheckRequest#check
 */
public class InvalidRequestException extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore dell classe
	 * @param message messaggio da visualizzare se si verifica l'eccezione
	 */
	public InvalidRequestException(String message) {
		super(message);
	}
}
