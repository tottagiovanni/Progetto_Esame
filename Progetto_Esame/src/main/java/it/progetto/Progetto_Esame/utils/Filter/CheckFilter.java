package it.progetto.Progetto_Esame.utils.Filter;

import java.util.ArrayList;
import java.util.Arrays;

import it.progetto.Progetto_Esame.exceptions.InvalidFilterException;
import it.progetto.Progetto_Esame.exceptions.InvalidJSONException;

/**
 * <p>
 * 	<b>Classe</b> <i>CheckFilter</i> per verificare l'esistenza del filtro sceltos
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class CheckFilter {
	
	/**
	 * Metodo che controlla se il filtro è presente e, in caso negativo, lancia l'eccezione
	 * @param op stringa contenente il filtro
	 * @throws InvalidFilterException se il filtro non è presente {@link it.progetto.Progetto_Esame.exceptions.InvalidFilterException}
	 */
	public static void isAFilter(String op) throws InvalidFilterException{
		ArrayList<String> filters = new ArrayList<String>(Arrays.asList("$gte", "$lte", "$gt", "$lt", "$eq", "$!eq", "$in", "$!in", "$and", "$or"));
		
		if (!(filters.contains(op)))
			throw new InvalidFilterException("Filtro non presente!");
	}
}
