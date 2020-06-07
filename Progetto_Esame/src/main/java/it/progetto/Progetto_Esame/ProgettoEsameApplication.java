package it.progetto.Progetto_Esame;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import it.progetto.Progetto_Esame.GUI.IntroWindow;

/**
 * <p>
 * 	<b>Classe</b> per l'avvio della <i>Progetto Esame Application</i>
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @see it.progetto.Progetto_Esame.GUI.IntroWindow
 * @version 1.0
 */
@SpringBootApplication
public class ProgettoEsameApplication {
	/**
	 * Avvia l'applicazione
	 * @param args parametro di default del main
	 * @see it.progetto.Progetto_Esame.GUI.IntroWindow#show
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(ProgettoEsameApplication.class).headless(false).run(args);
        IntroWindow.show();
	}
}
