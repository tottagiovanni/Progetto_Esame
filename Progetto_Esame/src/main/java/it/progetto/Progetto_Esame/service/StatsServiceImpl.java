package it.progetto.Progetto_Esame.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import it.progetto.Progetto_Esame.exceptions.EmptyRecordException;
import it.progetto.Progetto_Esame.exceptions.InvalidTypeException;
import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.model.StatsTwitter;
import it.progetto.Progetto_Esame.utils.CheckRecord;
import it.progetto.Progetto_Esame.utils.CheckType;
import it.progetto.Progetto_Esame.utils.Statistics;

/**
 * <p>
 * 	<b>Classe</b> <i>StatsServiceImpl</i> che implementa l'interfaccia StatsService
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
@Service
public class StatsServiceImpl implements StatsService {
	/**
	 * Metodo che restituisce le statistiche di un campo
	 * @param field campo sul quale effettuare le statistiche
	 * @return oggetto StatsTwitter contenente le statistiche
	 * @see it.progetto.Progetto_Esame.service.StatsServiceImpl#getStats(String, ArrayList)
	 * @see it.progetto.Progetto_Esame.service.RecordService#getTweets()
	 */
	public StatsTwitter getStats(String field) {
		ArrayList<RecordTwitter> tweets = RecordService.getTweets();
		return getStats(field, tweets);
	}
	
	/**
	 * Metodo che restituisce le statistiche di un campo, applicando i filtri (se presenti)
	 * @param field campo sul quale effettuare le statistiche
	 * @param tweets ArrayList dei tweets filtrat o di tutti i tweets (filtro nullo)
	 * @return oggetto StatsTwitter contenente le statistiche
	 * @see it.progetto.Progetto_Esame.model.StatsTwitter
	 * @see it.progetto.Progetto_Esame.utils.Statistics
	 */
	public StatsTwitter getStats(String field, ArrayList<RecordTwitter> tweets) {
		ArrayList<Long> stats = new ArrayList<Long>();
		
		try {
			RecordTwitter app = new RecordTwitter();
			Method check = app.getClass().getMethod("get" + field.substring(0, 1).toUpperCase() + field.substring(1), null);
		}catch(NoSuchMethodException e) {
			return new StatsTwitter(e.toString());
		}
		
		for (RecordTwitter tweet : tweets) {
			Method m;
			try {
				m = tweet.getClass().getMethod("get" + field.substring(0, 1).toUpperCase() + field.substring(1), null);
				try {
					Object record_value = m.invoke(tweet);
					
					try {
						CheckRecord.check(record_value);
					} catch (EmptyRecordException e) {
						return new StatsTwitter(e.toString());
					}
						
					
					try {
						Object tmp = 0L; 
						CheckType.check(tmp, record_value);
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

		StatsTwitter stats_twitter = new StatsTwitter(field, Statistics.avg(stats), Statistics.min(stats), Statistics.max(stats), Statistics.sum(stats), (long)Statistics.count(stats), Statistics.standardDeviation(stats), Statistics.mode(stats));
		
		if (!tweets.isEmpty() && tweets.get(0).getId_post() == null) {
			stats_twitter.setField(tweets.get(0).getText());
			stats_twitter.setCount(0L);
		}
		
			
		return stats_twitter;
	}
}
