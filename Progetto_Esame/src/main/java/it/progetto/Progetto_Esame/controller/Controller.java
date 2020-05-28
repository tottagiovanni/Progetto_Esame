package it.progetto.Progetto_Esame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.progetto.Progetto_Esame.service.JSONService;

@RestController
public class Controller {
	@Autowired
	JSONService twitter;
	
	@RequestMapping(value = "/tweets", method = RequestMethod.GET)
	public ResponseEntity<Object> getProduct(){
		return new ResponseEntity<>(twitter.getAllTweets(), HttpStatus.OK);
	}
	
	
}
