package it.progetto.Progetto_Esame.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.progetto.Progetto_Esame.exceptions.InvalidRequestException;
import it.progetto.Progetto_Esame.service.FilterService;
import it.progetto.Progetto_Esame.service.JSONService;
import it.progetto.Progetto_Esame.service.MetadataService;
import it.progetto.Progetto_Esame.service.StatsService;
import it.progetto.Progetto_Esame.utils.CheckRequest;

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
	public ResponseEntity<Object> getStats(@RequestParam(name = "field", defaultValue = "") String field, @RequestParam(name ="filter", required=false) String filtro){
		try {
			CheckRequest.check(field);
		}catch(InvalidRequestException e) {
			return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		}
		
		if(filtro == null)
			return new ResponseEntity<>(stats.getStats(field), HttpStatus.OK);
		else {
			return new ResponseEntity<>(stats.getStats(field, filter.getFilterTweets(filtro)), HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata(){
		MetadataService ms = new MetadataService();
		return new ResponseEntity<>(ms.getMetadata(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tweets", method = RequestMethod.POST)
	public ResponseEntity<Object> getPostTweets(@RequestBody String filtro){
		return new ResponseEntity<>(filter.getFilterTweets(filtro), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/stats", method = RequestMethod.POST)
	public ResponseEntity<Object> getPostTweets(@RequestParam(name = "field", defaultValue = "") String field, @RequestBody String filtro){
		try {
			CheckRequest.check(field);
		}catch(InvalidRequestException e) {
			return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(stats.getStats(field, filter.getFilterTweets(filtro)), HttpStatus.OK);
	}
}
