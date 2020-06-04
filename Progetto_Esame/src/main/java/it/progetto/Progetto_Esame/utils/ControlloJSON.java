package it.progetto.Progetto_Esame.utils;

import org.json.simple.JSONObject;

import it.progetto.Progetto_Esame.exceptions.InvalidJSONException;

public class ControlloJSON {
	public static void controllo(JSONObject json) throws InvalidJSONException{
		if (json == null)
			throw new InvalidJSONException("Formato JSON non corretto!");
	}
}
