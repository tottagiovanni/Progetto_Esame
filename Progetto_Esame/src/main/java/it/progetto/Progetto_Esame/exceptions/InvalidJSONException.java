package it.progetto.Progetto_Esame.exceptions;

public class InvalidJSONException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidJSONException(String message) {
		super(message);
	}
}
