package it.progetto.Progetto_Esame.exceptions;

/**
 * <p>
 * 	<b>Classe</b> <i>InvalidJSONException</i> per i formati json errati
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 * @see it.progetto.Progetto_Esame.utils.JSON.CheckJSON#check
 */
public class InvalidJSONException extends Exception{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Costruttore della classe
	 * @param message messaggio da visualizzare se si verifica l'eccezione
	 */
	public InvalidJSONException(String message) {
		super(message);
	}
}
