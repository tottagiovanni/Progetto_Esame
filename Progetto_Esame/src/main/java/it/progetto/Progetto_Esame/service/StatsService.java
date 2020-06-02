package it.progetto.Progetto_Esame.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.model.StatsTwitter;

@Service
public interface StatsService {
	public abstract StatsTwitter getStats(String field);
	public abstract StatsTwitter getStats(String field, ArrayList<RecordTwitter> tweets);
}
