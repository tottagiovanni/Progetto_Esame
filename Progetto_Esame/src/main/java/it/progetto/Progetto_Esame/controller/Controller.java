package it.progetto.Progetto_Esame.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.progetto.Progetto_Esame.exceptions.InvalidRequestException;
import it.progetto.Progetto_Esame.model.RecordTwitter;
import it.progetto.Progetto_Esame.model.StatsTwitter;
import it.progetto.Progetto_Esame.service.FilterService;
import it.progetto.Progetto_Esame.service.JSONService;
import it.progetto.Progetto_Esame.service.MetadataService;
import it.progetto.Progetto_Esame.service.StatsService;
import it.progetto.Progetto_Esame.utils.CheckRequest;

/**
 * <p>
 * 	<b>Classe</b> <i>Controller</i> per la gestione delle richieste al server locale
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @see it.progetto.Progetto_Esame.service
 * @see it.progetto.Progetto_Esame.exceptions
 * @see it.progetto.Progetto_Esame.utils
 * @see it.progetto.Progetto_Esame.model
 * @version 1.0
 */
@RestController
public class Controller {
	/**
	 * Indica i record
	 */
	@Autowired
	JSONService twitter;
	/**
	 * Indica i filtri
	 */
	@Autowired
	FilterService filter;
	/**
	 * Indica le statistiche
	 */
	@Autowired
	StatsService stats;
	
	/**
	 * Restituisce tutti i tweets oppure solo i tweets filtrati (GET)
	 * @param filtro filtro da applicare alla ricerca
	 * @return json contenente i tweets ricercati
	 * @see it.progetto.Progetto_Esame.service.JSONService#getAllTweets()
	 * @see it.progetto.Progetto_Esame.service.FilterService#getFilterTweets(String)
	 */
	@RequestMapping(value = "/tweets", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweets(@RequestParam(name = "filter", required = false) String filtro){
		if (filtro != null) {
			ArrayList<RecordTwitter> res = filter.getFilterTweets(filtro);
			if (!(res.isEmpty()) && (res.get(0).getId_post()) == null)
				return new ResponseEntity<>(res.get(0).getText(), HttpStatus.BAD_REQUEST);
			else
				return new ResponseEntity<>(res, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(twitter.getAllTweets(), HttpStatus.OK);
	}
	
	/**
	 * Restituisce le statistiche di un campo di tutti i tweets o dei tweets filtrati (GET)
	 * @param field campo sul quale effettuare le statistiche
	 * @param filtro filtro da applicare alla ricerca
	 * @return json contenente le statistiche
	 * @see it.progetto.Progetto_Esame.service.StatsService#getStats(String)
	 * @see it.progetto.Progetto_Esame.service.StatsService#getStats(String, ArrayList)
	 * @see it.progetto.Progetto_Esame.service.FilterService#getFilterTweets(String)
	 * @see it.progetto.Progetto_Esame.exceptions.InvalidRequestException
	 * @see it.progetto.Progetto_Esame.utils.CheckRequest#check(Object)
	 */
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public ResponseEntity<Object> getStats(@RequestParam(name = "field", defaultValue = "") String field, @RequestParam(name ="filter", required=false) String filtro){
		try {
			CheckRequest.check(field);
		}catch(InvalidRequestException e) {
			return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		}
		
		if(filtro == null) {
			StatsTwitter res = stats.getStats(field);
			if (res.getMin() == null)
				return new ResponseEntity<>(res.getField(), HttpStatus.BAD_REQUEST);
			else 
				return new ResponseEntity<>(stats.getStats(field), HttpStatus.OK);
		}
		else {
			StatsTwitter res = stats.getStats(field, filter.getFilterTweets(filtro));
			if (res.getMin() == null || (res.getStandardDeviation() == 0.0 && res.getCount() == 0))
				return new ResponseEntity<>(res.getField(), HttpStatus.BAD_REQUEST);
			else
				return new ResponseEntity<>(res, HttpStatus.OK);
		}
	}
	
	/**
	 * Restituisce i metadati dei tweets (GET)
	 * @see it.progetto.Progetto_Esame.service.MetadataService#getMetadata()
	 * @return json contenente i metadati
	 */
	@RequestMapping(value = "/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata(){
		MetadataService ms = new MetadataService();
		return new ResponseEntity<>(ms.getMetadata(), HttpStatus.OK);
	}
	
	/**
	 * Restituisce i tweets filtrati (POST) 
	 * @param filtro filtro da applicare alla ricerca
	 * @return json contenente i tweets ricercati
	 * @see it.progetto.Progetto_Esame.service.FilterService#getFilterTweets(String)
	 * @see it.progetto.Progetto_Esame.exceptions.InvalidRequestException
	 * @see it.progetto.Progetto_Esame.utils.CheckRequest#check(Object)
	 */
	@RequestMapping(value = "/tweets", method = RequestMethod.POST)
	public ResponseEntity<Object> getPostTweets(@RequestBody(required = false) String filtro){
		try {
			CheckRequest.check(filtro);
		}catch(InvalidRequestException e) {
			return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		}
		
		ArrayList<RecordTwitter> res = filter.getFilterTweets(filtro);
		if (!(res.isEmpty()) && (res.get(0).getId_post()) == null)
			return new ResponseEntity<>(res.get(0).getText(), HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	/**
	 * Restituisce le statistiche di un campo dei tweets filtrati (POST)
	 * @param field campo sul quale effettuare le statistiche
	 * @param filtro filtro da applicare alla ricerca
	 * @return json contenente le statistiche
	 * @see it.progetto.Progetto_Esame.service.StatsService#getStats(String, ArrayList)
	 * @see it.progetto.Progetto_Esame.service.FilterService#getFilterTweets(String)
	 * @see it.progetto.Progetto_Esame.exceptions.InvalidRequestException
	 * @see it.progetto.Progetto_Esame.utils.CheckRequest#check(Object)
	 */
	@RequestMapping(value = "/stats", method = RequestMethod.POST)
	public ResponseEntity<Object> getPostTweets(@RequestParam(name = "field", defaultValue = "") String field, @RequestBody(required = false) String filtro){
		try {
			CheckRequest.check(field);
			try {
				CheckRequest.check(filtro);
			}catch(InvalidRequestException e) {
				return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
			}
		}catch(InvalidRequestException e) {
			return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		}
		
		StatsTwitter res = stats.getStats(field, filter.getFilterTweets(filtro));
		if (res.getMin() == null || (res.getStandardDeviation() == 0.0 && res.getCount() == 0))
			return new ResponseEntity<>(res.getField(), HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
