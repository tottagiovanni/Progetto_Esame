package it.progetto.Progetto_Esame.utils;

/**
 * <p>
 * 	<b>Classe</b> <i>RemoveTag</i> per la rimozione di tag HTML in alcuni campi del JSON
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class RemoveTag {
	
	/**
	 * Costruttore di default della classe
	 */
	public RemoveTag(){
	}

	/**
	 *  Metodo che rimuove i tag HTML indesiderati dal json
	 * @param jsonConTag json con campi contenenti i tag HTML
	 * @return json con campi senza tag HTML
	 */
	public static String remove(String jsonConTag) {
		String JSONTagless = "";
		boolean confirm = true;
		for(char c : jsonConTag.toCharArray()) {
			if(c == '<')
				confirm = true;
			if(!confirm)
				JSONTagless += c;
			if(c == '>')
				confirm = false;
		}
		return JSONTagless;
	}
}
