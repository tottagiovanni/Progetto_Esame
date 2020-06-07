package it.progetto.Progetto_Esame;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.progetto.Progetto_Esame.exceptions.*;
import it.progetto.Progetto_Esame.model.*;
import it.progetto.Progetto_Esame.utils.*;

@SpringBootTest(classes = ProgettoEsameApplication.class)

class ProgettoEsameApplicationTests {

	private RecordTwitter record;
	
	@BeforeEach
	void setUp() throws Exception {
		record = new RecordTwitter("123", "2020-05-20", "Giovanni Totta", "Prova test", 3000, 33, 12, "it", "Twitter for Android", 0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
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
	
	@Test
	void test2() {
		// TO DO
	}
	
	@Test
	void testException() {
		Object value = 123L;
		InvalidTypeException exception = assertThrows(InvalidTypeException.class, () -> {CheckType.check("string", value);});
		assertEquals("Tipo di dato da filtare non valido! Inserire campo di tipo: "+value.getClass(), exception.getMessage());
	}
}
