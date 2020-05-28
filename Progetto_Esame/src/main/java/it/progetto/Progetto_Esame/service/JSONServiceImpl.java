package it.progetto.Progetto_Esame.service;


import java.util.ArrayList;

import org.springframework.stereotype.Service;

import it.progetto.Progetto_Esame.model.RecordTwitter;

@Service
public class JSONServiceImpl implements JSONService{
	public ArrayList<RecordTwitter> getAllTweets() {
		return DataService.getTweets();
	}
}
