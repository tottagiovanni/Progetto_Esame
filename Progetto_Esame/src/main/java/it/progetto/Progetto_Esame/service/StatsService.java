package it.progetto.Progetto_Esame.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import it.progetto.Progetto_Esame.model.RecordTwitter;

@Service
public interface StatsService {
	public abstract HashMap<String, Long> getStats(String field);
	public abstract HashMap<String, Long> getStats(String field, ArrayList<RecordTwitter> tweets);
}
