package it.progetto.Progetto_Esame.utils;

import java.util.ArrayList;

public class Statistics {
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
	
	public static Long min(ArrayList<Long> stats){
		Long min = 0L;
		try {
			min = stats.get(0);
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		
		for(Long stat:stats)
			if(min > stat)
				min = stat;
		return min;			
	}

	public static Long max(ArrayList<Long> stats){
		Long max = 0L;
		try {
			max = stats.get(0);
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		
		for(Long stat:stats)
			if(max < stat)
				max = stat;
		return max;			
	}

	public static Long sum(ArrayList<Long> stats){
		Long sum = 0L;
		for(Long stat:stats)
			sum += stat;
		return sum;			
	}
	
	public static int count(ArrayList<Long> stats){
		return stats.size();			
	}
	
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
	
	public static double standardDeviation(ArrayList<Long> stats) {
		double sum = 0;
		
		for (Long stat: stats)
			sum += (Math.pow((stat - avg(stats)) ,2));
		
		return Math.sqrt(sum/stats.size());
	}
	
}
