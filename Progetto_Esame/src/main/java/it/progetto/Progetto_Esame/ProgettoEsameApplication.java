package it.progetto.Progetto_Esame;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import it.progetto.Progetto_Esame.GUI.IntroWindow;

@SpringBootApplication
public class ProgettoEsameApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(ProgettoEsameApplication.class).headless(false).run(args);
        IntroWindow.show();
	}
}
