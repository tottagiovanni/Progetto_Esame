package it.progetto.Progetto_Esame.utils;

import it.progetto.Progetto_Esame.exceptions.InvalidTypeException;

public class CheckType {
	public static void check(Object r, Object v) throws InvalidTypeException{
		if (r.getClass() != v.getClass()) {
			throw new InvalidTypeException("Tipo di dato da filtare non valido! Inserire campo di tipo: "+v.getClass());
		}
	}
}
