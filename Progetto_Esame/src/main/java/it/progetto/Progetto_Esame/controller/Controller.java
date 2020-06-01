package it.progetto.Progetto_Esame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.progetto.Progetto_Esame.service.FilterService;
import it.progetto.Progetto_Esame.service.JSONService;
import it.progetto.Progetto_Esame.service.StatsService;

@RestController
public class Controller {
	@Autowired
	JSONService twitter;
	@Autowired
	FilterService filter;
	@Autowired
	StatsService stats;

	@RequestMapping(value = "/tweets", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweets(@RequestParam(name = "filter", required = false) String filtro){
		if (filtro != null)
			return new ResponseEntity<>(filter.getFilterTweets(filtro), HttpStatus.OK);
		else
			return new ResponseEntity<>(twitter.getAllTweets(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public ResponseEntity<Object> getStats(@RequestParam(name = "field", required = false) String field){
		return new ResponseEntity<>(stats.getStats(field), HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/tweets", method = RequestMethod.GET)
	public ResponseEntity<Object> getFilterTweets(@RequestParam(name = "filter", required = false) String filtro){
		return new ResponseEntity<>(filter.getFilterTweets(filtro), HttpStatus.OK);
	}*/
	
	
}
