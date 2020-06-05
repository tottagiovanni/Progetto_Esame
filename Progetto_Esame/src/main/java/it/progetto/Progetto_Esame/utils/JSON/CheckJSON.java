package it.progetto.Progetto_Esame.utils.JSON;

import org.json.simple.JSONObject;

import it.progetto.Progetto_Esame.exceptions.InvalidJSONException;

public class CheckJSON {
	public static void check(JSONObject json) throws InvalidJSONException{
		if (json == null)
			throw new InvalidJSONException("Formato JSON non corretto!");
	}
}
