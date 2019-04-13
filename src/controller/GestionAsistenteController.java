package controller;

import javax.faces.bean.ManagedBean;

//@SuppressWarnings("deprecation")
@ManagedBean
public class GestionAsistenteController {
	public String botonInicioSesion(){
		
		
		//Show the next page
		return "principalAsistente.xhtml";
	}
}
