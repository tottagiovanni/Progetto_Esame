package it.progetto.Progetto_Esame.utils;

import java.util.ArrayList;

/**
 * <p>
 * 	<b>Classe</b> <i>Statistics</i> per il calcolo delle statistiche associate al campo scelto
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class Statistics {
	
	/**
	 * Metodo che calcola la media dei valori del campo
	 * @param stats ArrayList contenente i valori
	 * @return <code>Long</code> media 
	 * @throws ArithmeticException se si ha una divisione per 0
	 */
	public static Long avg(ArrayList<Long> stats) {
		Long avg = 0L;  //zero long
		for(Long stat: stats)
			avg += stat;
		try {
			avg = avg / stats.size();
		} catch (ArithmeticException e) {
			System.out.println(e.toString());
		}
		return avg;
	}
	
	/**
	 * Metodo che calcola il minimo tra i valori del campo
	 * @param stats ArrayList contenente i valori
	 * @return <code>Long</code> minimo
	 * @throws IndexOutOfBoundsException se l'ArrayList è vuoto
	 */
	public static Long min(ArrayList<Long> stats){
		Long min = 0L;
		try {
			min = stats.get(0);
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println(e.toString());
		}
		
		for(Long stat:stats)
			if(min > stat)
				min = stat;
		return min;			
	}

	/**
	 * Metodo che calcola il massimo tra i valori del campo
	 * @param stats ArrayList contenente i valori
	 * @return <code>Long</code> massimo
	 * @throws IndexOutOfBoundsException se l'ArrayList è vuoto
	 */
	public static Long max(ArrayList<Long> stats){
		Long max = 0L;
		try {
			max = stats.get(0);
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println(e.toString());
		}
		
		for(Long stat:stats)
			if(max < stat)
				max = stat;
		return max;			
	}
	
	/**
	 * Metodo che calcola la somma dei valori del campo
	 * @param stats ArrayList contenente i valori
	 * @return <code>Long</code> somma
	 */
	public static Long sum(ArrayList<Long> stats){
		Long sum = 0L;
		for(Long stat:stats)
			sum += stat;
		return sum;			
	}
	
	/**
	 * Metodo che calcola il numero di tweets analizzati
	 * @param stats ArrayList contenente i valori
	 * @return <code>int</code> numero tweets
	 */
	public static int count(ArrayList<Long> stats){
		return stats.size();			
	}
	
	/**
	 * Metodo che calcola la moda dei valori del campo
	 * @param stats ArrayList contenente i valori
	 * @return <code>Long</code> moda
	 */
	public static Long mode(ArrayList<Long> stats) {
		Long cont = 0L;
		ArrayList<Long> val = new ArrayList<Long>();
		
		Long max = 0L, max_occ = 0L;
		for(int i = 0; i < stats.size()-1; i++) {
			cont = 1L;
			for (int j = 0; j < stats.size()-1; j++) {
				if (stats.get(i) == stats.get(j) && i != j)
					cont++;
			}
			val.add(cont);
			max = max(val);
			if (max == cont)	
				max_occ = stats.get(i);
		}
		
		return max_occ;
	}
	
	/**
	 * Metodo che calcola la deviazione standard dei valori del campo
	 * @param stats ArrayList contenente i valori
	 * @return <code>double</code> deviazione standard
	 */
	public static double standardDeviation(ArrayList<Long> stats) {
		double sum = 0;
		
		for (Long stat: stats)
			sum += (Math.pow((stat - avg(stats)) ,2));
		
		return Math.sqrt(sum/stats.size());
	}
	
}
