package controller;

import javax.faces.bean.ManagedBean;
//import javax.faces.context.FacesContext;

//import beans.User;

//@SuppressWarnings("deprecation")
@ManagedBean
public class LoginAsistenteController {
	public String botonRegistrar(){
		
		//Show the next page
		return "registro-Asistente.xhtml";
	}
	
	public String botonLoginAsistente(){
			
		//Show the next page
		return "login-Asistente.xhtml";
	}
	

}
