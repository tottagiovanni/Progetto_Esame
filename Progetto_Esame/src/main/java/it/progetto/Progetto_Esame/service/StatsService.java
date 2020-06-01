package it.progetto.Progetto_Esame.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public interface StatsService {
	public abstract HashMap<String, Long> getStats(String field);
}
