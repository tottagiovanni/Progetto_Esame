package it.progetto.Progetto_Esame.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.Statistic;
import it.progetto.Progetto_Esame.exceptions.InvalidTypeException;
import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.model.StatsTwitter;
import it.progetto.Progetto_Esame.utils.ControlloTipo;
import it.progetto.Progetto_Esame.utils.Statistics;

@Service
public class StatsServiceImpl implements StatsService {
	public StatsTwitter getStats(String field) {
		ArrayList<RecordTwitter> tweets = RecordService.getTweets();
		return getStats(field, tweets);
	}

	@Override
	public StatsTwitter getStats(String field, ArrayList<RecordTwitter> tweets) {
		ArrayList<Long> stats = new ArrayList<Long>();

		for (RecordTwitter tweet : tweets) {
			Method m;
			try {
				m = tweet.getClass().getMethod("get" + field.substring(0, 1).toUpperCase() + field.substring(1), null);
				try {
					Object record_value = m.invoke(tweet);
					
					try {
						Object tmp = 0L; 
						ControlloTipo.controllo(record_value, tmp);
					} catch (InvalidTypeException e) {
						return new StatsTwitter(e.toString());
					}

					if (record_value instanceof Long)
						stats.add((Long) record_value);

				} catch (IllegalAccessException e) {
					System.out.println(e.toString());
				} catch (IllegalArgumentException e) {
					System.out.println(e.toString());
				} catch (InvocationTargetException e) {
					System.out.println(e.toString());
				}

			} catch (NoSuchMethodException e) {
				return new StatsTwitter(e.toString());
			} catch (SecurityException e) {
				System.out.println(e.toString());
			}
		}

		StatsTwitter stats_twitter = new StatsTwitter(field, Statistics.avg(stats), Statistics.min(stats), Statistics.max(stats), Statistics.sum(stats), (long)Statistics.count(stats), Statistics.standardDeviation(stats), Statistics.moda(stats));
		
		return stats_twitter;
	}

}
