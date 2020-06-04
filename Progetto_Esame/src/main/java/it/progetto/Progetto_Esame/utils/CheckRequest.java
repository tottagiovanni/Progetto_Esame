package it.progetto.Progetto_Esame.utils;

import it.progetto.Progetto_Esame.exceptions.InvalidRequestException;

public class CheckRequest {
	public static void check(String s) throws InvalidRequestException{
		if (s.equals(""))
			throw new InvalidRequestException("Parametro field richiesto");
	}
}
