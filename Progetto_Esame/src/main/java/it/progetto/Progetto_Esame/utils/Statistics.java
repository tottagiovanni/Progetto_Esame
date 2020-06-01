package it.progetto.Progetto_Esame.utils;

import java.util.ArrayList;

public class Statistics {
	public static Long avg(ArrayList<Long> stats) {
		Long avg = 0L;  //zero long
		for(Long stat: stats)
			avg += stat;
		try {
			avg = avg / stats.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return avg;
	}
	
	public static Long min(ArrayList<Long> stats){
		Long min = stats.get(0);
		for(Long stat:stats)
			if(min > stat)
				min = stat;
		return min;			
	}

	public static Long max(ArrayList<Long> stats){
		Long max = stats.get(0);
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
	
}
