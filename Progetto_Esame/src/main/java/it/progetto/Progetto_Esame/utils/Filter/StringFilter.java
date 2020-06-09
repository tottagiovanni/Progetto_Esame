package it.progetto.Progetto_Esame.utils.Filter;

/**
 * <p>
 * 	<b>Classe</b> <i>StringFilter</i> per selezionare i tweets in base a filtri sui dati testuali
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class StringFilter {
	
	/**
	 * Metodo che effettua il controllo testuale sui valori in base al filtro scelto 
	 * @param r valore del campo di un record presente nell'ArrayList
	 * @param v valore passatogli per filtrare i dati
	 * @param op tipo di filtro scelto
	 * @return boolean che segnala se il confronto è riuscito
	 */
	public static boolean compare(Object r, Object v, String op) {
		String r_cast = (String) r;
		String v_cast = (String) v;
		
		if (op.equals("$eq"))
			return r_cast.equals(v_cast);
		else if (op.equals("$in"))
			return r_cast.contains(v_cast);
		else if (op.equals("$!eq"))
			return !(r_cast.equals(v_cast));
		else
			return false;
	}
}
