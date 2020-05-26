package it.progetto.Progetto_Esame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import it.progetto.Progetto_Esame.api.*;

@SpringBootApplication
public class ProgettoEsameApplication {

	public static void main(String[] args) {
		GestioneAPI.caricamentoJSON("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=covid19&count=3&result_type=popular");
		SpringApplication.run(ProgettoEsameApplication.class, args);
	}

}
