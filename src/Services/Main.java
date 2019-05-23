package Services;

import java.util.ArrayList;

import beans.AnalizadorSentimientos;
import beans.SingletonAnalizadorSentimientos;

public class Main {
	    public static void main(String[] args) {
	    	/*Traductor x = SingletonTraductor.getInstance();
	    	String z = x.traducirTexto("Hello World!, incredible this works almost perfectly");
	        System.out.println(z);*/

	    	AnalizadorSentimientos y = SingletonAnalizadorSentimientos.getInstance();
	    	ArrayList<String> lista = new ArrayList();
	    	lista.add("Odio toda esta presentacion");
	    	lista.add("No me gusto para nada esta presentacion");
	    	lista.add("No me parecio tan mala como pense");
	    	lista.add("Pudo ser mas corto la verdad");
	    	lista.add("Me parecio genial, la verdad muy bien hecho");
	    	lista.add("Lastima que la presentacion se cancelo");
	    	lista.add("Quien es la persona que organizo este evento");
	    	lista.add("Esto fue una perdida de tiempo, una estupidez");
	    	
	    	ArrayList<String> lista2 = y.obtenerComentariosSentimiento(lista, "Tristeza");
	    	for(int i = 0; lista2.size() > i ; i++) {
	    		System.out.println("Selecionado : "+lista2.get(i));
	    	}
	        
	    }
	}

