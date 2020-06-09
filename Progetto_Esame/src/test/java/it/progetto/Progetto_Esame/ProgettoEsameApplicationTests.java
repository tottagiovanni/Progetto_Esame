package it.progetto.Progetto_Esame;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.progetto.Progetto_Esame.exceptions.*;
import it.progetto.Progetto_Esame.model.*;
import it.progetto.Progetto_Esame.utils.*;
import it.progetto.Progetto_Esame.utils.Filter.NumericalFilter;


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
	private RecordTwitter record;
	
	/**
	 * Metodo per creazione oggetti e settaggio parametri, viene eseguito prima dei test
	 * @throws Exception
	 * @see it.progetto.Progetto_Esame.model.RecordTwitter
	 */
	@BeforeEach
	void setUp() throws Exception {
		record = new RecordTwitter("123", "2020-05-20", "Giovanni Totta", "Prova test", 3000, 33, 12, "it", "Twitter for Android", 0);
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
		assertAll("valori", ()->assertEquals("123", record.getId_post()),
				()->assertEquals("2020-05-20", record.getDate()),
				()->assertEquals("Giovanni Totta", record.getName()),
				()->assertEquals("Prova test", record.getText()),
				()->assertEquals(3000, record.getFollowers()),
				()->assertEquals(33, record.getLike()),
				()->assertEquals(12, record.getRetweet()),
				()->assertEquals("it", record.getNation()),
				()->assertEquals("Twitter for Android", record.getDevice()),
				()->assertEquals(0, record.getHashtags()));
	}
	
	/**
	 * Metodo per testare il confronto numerico in base al filtro
	 * @see it.progetto.Progetto_Esame.utils.Filter.NumericalFilter#compare(Object, Object, String)
	 */
	@Test
	void testCompare() {
		assertEquals(true, NumericalFilter.compare(12L, 1L, "$gt"));
		assertEquals(false, NumericalFilter.compare(12L, 1L, "$lt"));
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
