package it.progetto.Progetto_Esame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.progetto.Progetto_Esame.exceptions.*;
import it.progetto.Progetto_Esame.model.*;
import it.progetto.Progetto_Esame.utils.*;
import it.progetto.Progetto_Esame.utils.Filter.NumericalFilter;
import it.progetto.Progetto_Esame.utils.Filter.StringFilter;


/**
 * <p>
 * 	<b>Classe</b> <i>ProgettoEsameApllicationTests</i> per i vari JUnit test
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
@SpringBootTest(classes = ProgettoEsameApplication.class)
public class ProgettoEsameApplicationTests {

	/**
	 * Indica un record
	 */
	private ArrayList<RecordTwitter> records = new ArrayList<>();
	
	/**
	 * Metodo per creazione oggetti e settaggio parametri, viene eseguito prima dei test
	 * @throws Exception
	 * @see it.progetto.Progetto_Esame.model.RecordTwitter
	 */
	@BeforeEach
	void setUp() throws Exception {
		records.add(new RecordTwitter("123", "2020-05-20", "Giovanni Totta", "Prova test", 3000, 33, 12, "it", "Twitter for Android", 0));
		records.add(new RecordTwitter("1434323", "2020-05-20", "Maurizio Cavani", "Ciao a tutti", 11000, 434, 77, "en", "Twitter for iPhone", 2));
	}

	/**
	 * Metodo che viene eseguito alla fine di ogni test
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Test terminato");
	}
	
	/**
	 * Metodo per testare la creazione di oggetti RecordTwitter
	 * @see it.progetto.Progetto_Esame.model.RecordTwitter
	 */
	@Test
	void testRecord() {
		assertAll("valori", ()->assertEquals("123", records.get(0).getId_post()),
				()->assertEquals("2020-05-20", records.get(0).getDate()),
				()->assertEquals("Giovanni Totta", records.get(0).getName()),
				()->assertEquals("Prova test", records.get(0).getText()),
				()->assertEquals(3000, records.get(0).getFollowers()),
				()->assertEquals(33, records.get(0).getLike()),
				()->assertEquals(12, records.get(0).getRetweet()),
				()->assertEquals("it", records.get(0).getNation()),
				()->assertEquals("Twitter for Android", records.get(0).getDevice()),
				()->assertEquals(0, records.get(0).getHashtags()));
		
		assertAll("valori", ()->assertEquals("1434323", records.get(1).getId_post()),
				()->assertEquals("2020-05-20", records.get(1).getDate()),
				()->assertEquals("Maurizio Cavani", records.get(1).getName()),
				()->assertEquals("Ciao a tutti", records.get(1).getText()),
				()->assertEquals(11000, records.get(1).getFollowers()),
				()->assertEquals(434, records.get(1).getLike()),
				()->assertEquals(77, records.get(1).getRetweet()),
				()->assertEquals("en", records.get(1).getNation()),
				()->assertEquals("Twitter for iPhone", records.get(1).getDevice()),
				()->assertEquals(2, records.get(1).getHashtags()));
	}
	
	/**
	 * Metodo per testare il confronto numerico e testuale in base al filtro
	 * @see it.progetto.Progetto_Esame.utils.Filter.NumericalFilter#compare(Object, Object, String)
	 * @see it.progetto.Progetto_Esame.utils.Filter.StringFilter#compare(Object, Object, String)
	 */
	@Test
	void testCompare() {
		assertEquals(true, NumericalFilter.compare(12L, 1L, "$gt"));
		assertEquals(false, NumericalFilter.compare(12L, 1L, "$lt"));
		assertEquals(true, StringFilter.compare("Marco", "Marco", "$eq"));
	}
	
	/**
	 * Metodo per testare l'eccezione di tipo errato
	 * @see it.progetto.Progetto_Esame.exceptions.InvalidTypeException
	 * @see it.progetto.Progetto_Esame.utils.CheckType#check(Object, Object)
	 */
	@Test
	void testException() {
		Object value = 123L;
		InvalidTypeException exception = assertThrows(InvalidTypeException.class, () -> {CheckType.check("string", value);});
		assertEquals("Tipo di dato da filtare non valido! Inserire campo di tipo: "+value.getClass(), exception.getMessage());
	}
}
