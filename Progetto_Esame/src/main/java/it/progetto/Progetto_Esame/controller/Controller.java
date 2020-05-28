package it.progetto.Progetto_Esame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import it.progetto.Progetto_Esame.service.DataService;

@RestController
public class Controller {
	@Autowired
	DataService record;
	
	//@RequestMapping
	
	
}
