package it.progetto.Progetto_Esame.exceptions;

/**
 * <p>
 * 	<b>Classe</b> <i>EmptyRecordException</i> per i record vuoti
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 * @see it.progetto.Progetto_Esame.utils.CheckRecord#check(Object)
 */
public class EmptyRecordException extends Exception{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Costruttore della classe
	 * @param message messaggio da visualizzare se si verifica l'eccezione
	 */
	public EmptyRecordException(String message) {
		super(message);
	}
}
