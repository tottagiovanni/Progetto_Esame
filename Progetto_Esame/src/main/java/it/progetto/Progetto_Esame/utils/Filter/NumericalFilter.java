package it.progetto.Progetto_Esame.utils.Filter;

public class NumericalFilter {
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
		else
			return false;
	}
}