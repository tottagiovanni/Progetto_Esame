package it.progetto.Progetto_Esame.utils;

public class StringFilter {
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
