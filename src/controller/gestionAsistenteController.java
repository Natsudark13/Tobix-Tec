package controller;

import javax.faces.bean.ManagedBean;

//@SuppressWarnings("deprecation")
@ManagedBean
public class gestionAsistenteController {
	public String botonInicioSesion(){
		
		
		//Show the next page
		return "principalAsistente.xhtml";
	}
}
