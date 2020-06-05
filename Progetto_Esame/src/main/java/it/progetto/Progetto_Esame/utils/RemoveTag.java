package it.progetto.Progetto_Esame.utils;

public class RemoveTag {
	public RemoveTag(){
	}

	static public String remove(String jsonConTag) {
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
