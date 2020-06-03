package it.progetto.Progetto_Esame;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.progetto.Progetto_Esame.GUI.IntroWindow;
import it.progetto.Progetto_Esame.service.DataService;
import it.progetto.Progetto_Esame.service.RecordService;

@SpringBootApplication
public class ProgettoEsameApplication {
	public static void main(String[] args) {
        IntroWindow.start();
	         
		/*try {
			String data = DataService.setTweets(new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=covid19&count=50&result_type=mixed"));
			RecordService rs = new RecordService(data);
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}*/
		 
		SpringApplication.run(ProgettoEsameApplication.class, args);
	}
}
