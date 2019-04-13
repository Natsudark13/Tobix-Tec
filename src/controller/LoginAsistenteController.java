package controller;

import javax.faces.bean.ManagedBean;
//import javax.faces.context.FacesContext;
import javax.faces.context.FacesContext;

import beans.Asistente;
import beans.User;

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
	
	public String logIN(){
		
		// get the user values from the input form.
		FacesContext context = FacesContext.getCurrentInstance();
		Asistente asistente = context.getApplication().evaluateExpressionGet(context, "#{asistente}", Asistente.class);
	
		
		// show the user data in console
		System.out.println("look: "+asistente.getCorreo()+" "+asistente.getContrasenaAsistente());
		
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("asistente", asistente);
		String URL;
		if(asistente.logIn(asistente.getCorreo(), asistente.getContrasenaAsistente()) == 0) {
			URL = "login-Asistente.xhtml";
		}
		else {
			URL = "principalAsistente.xhtml";
		}
		//Show the next page
		return URL;
	}

}
