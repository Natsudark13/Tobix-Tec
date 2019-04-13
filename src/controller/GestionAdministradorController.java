package controller;

import javax.faces.bean.ManagedBean;

//@SuppressWarnings("deprecation")
@ManagedBean

public class GestionAdministradorController {
	public String botonInicioSesion(){
				
		//Show the next page
		return "principalAdministrador.xhtml";
	}
}
