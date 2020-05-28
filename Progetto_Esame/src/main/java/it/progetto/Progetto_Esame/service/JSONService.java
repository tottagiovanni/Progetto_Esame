package it.progetto.Progetto_Esame.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import it.progetto.Progetto_Esame.model.*;

@Service
public interface JSONService {
	public abstract ArrayList<RecordTwitter> getAllTweets();
}
