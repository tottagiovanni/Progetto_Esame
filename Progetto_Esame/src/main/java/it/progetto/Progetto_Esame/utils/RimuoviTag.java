package it.progetto.Progetto_Esame.utils;

public class RimuoviTag {
	public RimuoviTag(){
	}

	static public String rimuovi(String jsonConTag) {
		String jsonSenzaTag = "";
		boolean confirm = true;
		for(char c : jsonConTag.toCharArray()) {
			if(c == '<')
				confirm = true;
			if(!confirm)
				jsonSenzaTag += c;
			if(c == '>')
				confirm = false;
		}
		return jsonSenzaTag;
	}
}
