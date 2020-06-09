package it.progetto.Progetto_Esame.utils.Filter;

import org.json.simple.JSONObject;

/**
 * <p>
 * 	<b>Classe</b> <i>FilterSplitter</i> per selezionare il filtro e l'operatore di confronto dalla richiesta
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class FilterSplitter {
	
	/**
	 * Metodo che restituisce un array di stringhe contenente il filtro e l'operatore
	 * @param json json contenente i dati dei tweets
	 * @return <code>String[]</code> contenente il filtro e l'operatore
	 */
	public static String[] split(JSONObject json) {
 		String s = json.toString();
		String field = s.split("\\\"")[1];
		String operator = s.split("\\\"")[3];
		
		String [] str_arr = {field, operator};
			
		return str_arr;
	}
}
