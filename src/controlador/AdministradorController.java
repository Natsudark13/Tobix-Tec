package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.Administrador;
import beans.Asistente;

//@SuppressWarnings("deprecation")
@ManagedBean

public class AdministradorController {
	
	public String botonInicioSesion(){
				
		//Show the next page
		return "principalAdministrador.xhtml";
	}
	
	public String btnLoginAdministrador(){
		
		//Show the next page
		return "login-Administrador.xhtml";
	}
	
	public String logIN(){
		
		// get the user values from the input form.
		FacesContext context = FacesContext.getCurrentInstance();
		Administrador administrador = context.getApplication().evaluateExpressionGet(context, "#{Administrador}", Administrador.class);
	
		
		// show the user data in console
		System.out.println("look: "+administrador.getCorreo()+" "+administrador.getContrasenaAdministrador());
		
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("administrador", administrador);
		String URL;
		if(administrador.logIn(administrador.getCorreo(), administrador.getContrasenaAdministrador()) == 0) {
			URL = "login-Asistente.xhtml";
		}
		else {
			URL = "principalAsistente.xhtml";
		}
		//Show the next page
		return URL;
	}
}