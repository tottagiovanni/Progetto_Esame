package it.progetto.Progetto_Esame.exceptions;

public class InvalidFilterException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidFilterException(String message) {
		super(message);
	}
}
