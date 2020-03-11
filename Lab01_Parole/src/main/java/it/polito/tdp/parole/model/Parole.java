package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
//	LinkedList<String> parole;
	//LinkedList<String> tempi;
	ArrayList<String> parole;
	ArrayList<String> tempi;
	public Parole() {
	//	parole = new LinkedList<String>();
	//	tempi= new LinkedList<String>();
		parole= new ArrayList<String>();
		tempi= new ArrayList<String>();
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}

	public void remove(String parola) {
		
		parole.remove(parole.indexOf(parola));
	}

	public void addTempo(String tempo) {
	tempi.add(tempo);
		
	}

	public String getTempi() {
		String risultato="";
		for(String s: tempi) {
			if (risultato.equals(""))
				risultato += s;
			else
				risultato += "\n" + s;
		}
		
		return risultato;
	}

}
