package it.progetto.Progetto_Esame.utils.Filter;

/**
 * <p>
 * 	<b>Classe</b> <i>NumericalFilter</i> per selezionare i tweets in base a filtri sui dati numerici
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class NumericalFilter {
	
	/**
	 * Metodo che effettua il controllo numerico sui valori in base al filtro scelto 
	 * @param r valore del campo di un record presente nell'ArrayList
	 * @param v valore passatogli per filtrare i dati
	 * @param op tipo di filtro scelto
	 * @return boolean che segnala se il confronto è riuscito
	 */
	public static boolean compare(Object r, Object v, String op) {

		Long r_cast = (Long) r;
		Long v_cast = (Long) v;

		if (op.equals("$gt"))
			return r_cast > v_cast;

		else if (op.equals("$gte"))
			return r_cast >= v_cast;

		else if (op.equals("$lt"))
			return r_cast < v_cast;

		else if (op.equals("$lte"))
			return r_cast <= v_cast;

		else if (op.equals("$eq"))
			return r_cast.equals(v_cast);
		
		else if (op.equals("$!eq"))
			return !(r_cast.equals(v_cast));
		else
			return false;
	}
}
