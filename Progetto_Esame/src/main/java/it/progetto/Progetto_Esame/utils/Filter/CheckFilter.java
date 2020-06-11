package it.progetto.Progetto_Esame.utils.Filter;

import java.util.ArrayList;
import java.util.Arrays;

import it.progetto.Progetto_Esame.exceptions.InvalidFilterException;

public class CheckFilter {
	public static void isAFilter(String op) throws InvalidFilterException{
		ArrayList<String> filters = new ArrayList<String>(Arrays.asList("$gte", "$lte", "$gt", "$lt", "$eq", "$!eq", "$in", "$!in", "$and", "$or"));
		
		if (!(filters.contains(op)))
			throw new InvalidFilterException("Filtro non presente!");
	}
}
