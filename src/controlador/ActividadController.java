package controlador;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.Actividad;
import beans.Bloque;


//@SuppressWarnings("deprecation")
@ManagedBean

public class ActividadController {
	
	public String btnRegistro() {
		return"registro-Actividad.xhtml";
	}
	
	public String btnConsultas() {
		return"listadoActividad.xhtml";
	}
	
	public String registrarActividad(){
		
		// get the user values from the input form.
		FacesContext context = FacesContext.getCurrentInstance();
		Bloque bloque = context.getApplication().evaluateExpressionGet(context, "#{bloque}", Bloque.class);
		Actividad actividad = context.getApplication().evaluateExpressionGet(context, "#{actividad}", Actividad.class);
		
		try {
			actividad.registrarActividad();
			actividad.registrarActividad_Bloque(bloque.getTematica());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
				
		// show the user data in console
		//System.out.println("look: "+administrador.getCorreo()+" "+administrador.getContrasenaAdministrador());
				
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("actividad", actividad);
		
		return "principalAdministrador.xhtml";
	}
}