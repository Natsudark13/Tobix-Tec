package controller;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.User;

//@SuppressWarnings("deprecation")
@ManagedBean
public class LoginAdministradorController {
	
	public String btnLoginAdministrador(){
		
		//Show the next page
		return "login-Administrador.xhtml";
	}

}
