package it.progetto.Progetto_Esame.exceptions;

/**
 * <p>
 * 	<b>Classe</b> <i>InvalidFilterException</i> per i filtri non presenti
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 * @see it.progetto.Progetto_Esame.utils.Filter.CheckFilter#isAFilter(String)
 */
public class InvalidFilterException extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore della classe
	 * @param message messaggio da visualizzare se si verifica l'eccezione
	 */
	public InvalidFilterException(String message) {
		super(message);
	}
}
