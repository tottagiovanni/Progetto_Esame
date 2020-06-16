package it.progetto.Progetto_Esame;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.progetto.Progetto_Esame.exceptions.*;
import it.progetto.Progetto_Esame.utils.*;
import it.progetto.Progetto_Esame.utils.Filter.*;
import it.progetto.Progetto_Esame.utils.JSON.*;

/**
 * <p>
 * 	<b>Classe</b> <i>ProgettoEsameExceptionTests</i> per i vari JUnit test sulle eccezioni gestite
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
@SpringBootTest(classes = ProgettoEsameApplication.class)
public class ProgettoEsameExceptionTests {
	private Object record;
	private Object value;
	private String filter;
	private JSONObject json;
	private String field;
	
	/**
	 * Metodo per creazione oggetti e settaggio parametri, viene eseguito prima dei test
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		record = null;
		value = null;
		filter = "";
		json = null;
		field = "";
	}

	/**
	 * Metodo che viene eseguito alla fine di ogni test
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Test terminato.");
	}

	/**
	 * Metodo per testare l'eccezione di tipo errato
	 * @see it.progetto.Progetto_Esame.exceptions.InvalidTypeException
	 * @see it.progetto.Progetto_Esame.utils.CheckType#check(Object, Object)
	 */
	@Test
	void testInvalidTypeException() {
		record = "stringa";
		value = 123L;
		InvalidTypeException exception = assertThrows(InvalidTypeException.class, () -> {CheckType.check(record, value);});
		assertEquals("Tipo di dato da filtare non valido! Inserire campo di tipo: "+record.getClass(), exception.getMessage());
	}
	
	/**
	 * Metodo per testare l'eccezione di record vuoto
	 * @see it.progetto.Progetto_Esame.exceptions.EmptyRecordException
	 * @see it.progetto.Progetto_Esame.utils.CheckRecord#check(Object)
	 */
	@Test
	void testEmptyRecordException() {
		record = null;
		EmptyRecordException exception = assertThrows(EmptyRecordException.class, () -> {CheckRecord.check(record);});
		assertEquals("Campo vuoto a causa di un filtro errato!", exception.getMessage());
	}
	
	/**
	 * Metodo per testare l'eccezione di fitro non presente
	 * @see it.progetto.Progetto_Esame.exceptions.InvalidFilterException
	 * @see it.progetto.Progetto_Esame.utils.Filter.CheckFilter#check(String)
	 */
	@Test
	void testInvalidFilterException() {
		filter = "$bt";
		InvalidFilterException exception = assertThrows(InvalidFilterException.class, () -> {CheckFilter.isAFilter(filter);});
		assertEquals("Filtro non presente!", exception.getMessage());
	}
	
	/**
	 * Metodo per testare l'eccezione di formato json errato
	 * @see it.progetto.Progetto_Esame.exceptions.InvalidJSONException
	 * @see it.progetto.Progetto_Esame.utils.JSON.CheckJSON#check(JSONObject)
	 */
	@Test
	void testInvalidJSONException() {
		json = null;
		InvalidJSONException exception = assertThrows(InvalidJSONException.class, () -> {CheckJSON.check(json);});
		assertEquals("Formato JSON non corretto!", exception.getMessage());
	}
	
	/**
	 * Metodo per testare l'eccezione di parametro field mancante
	 * @see it.progetto.Progetto_Esame.exceptions.InvalidRequestException
	 * @see it.progetto.Progetto_Esame.utils.CheckRequest#check(Object)
	 */
	@Test
	void testInvalidRequestException1() {
		field = "";
		InvalidRequestException exception = assertThrows(InvalidRequestException.class, () -> {CheckRequest.check(field);});
		assertEquals("Parametro field mancante!", exception.getMessage());
	}
	
	/**
	 * Metodo per testare l'eccezione di parametro filter mancante
	 * @see it.progetto.Progetto_Esame.exceptions.InvalidRequestException
	 * @see it.progetto.Progetto_Esame.utils.CheckRequest#check(Object)
	 */
	@Test
	void testInvalidRequestException2(){
		filter = null;
		InvalidRequestException exception = assertThrows(InvalidRequestException.class, () -> {CheckRequest.check(filter);});
		assertEquals("Parametro filter mancante!", exception.getMessage());
	}
}
