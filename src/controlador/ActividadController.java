package controlador;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.Actividad;
import beans.Bloque;
import conexion.CRUD;


//@SuppressWarnings("deprecation")
@ManagedBean

public class ActividadController {
	
	public String btnRegistro() {
		return"registro-Actividad.xhtml";
	}
	
	public String btnConsultas() {
		return"listadoActividad.xhtml";
	}
	
	public String elegirBloque() throws SQLException {
		// get the user values from the input form.
		CRUD crud = new CRUD();
		FacesContext context = FacesContext.getCurrentInstance();
		Bloque bloque = context.getApplication().evaluateExpressionGet(context, "#{bloque}", Bloque.class);
		Actividad actividad = new Actividad();
		actividad.setNombresA(crud.select_Bloque_actividad(bloque.getTematica()));
		
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("actividad", actividad);
		
		return"elegirActividades.xhtml";
	}
	
	public String verActividad() throws SQLException {
		// get the user values from the input form.
		FacesContext context = FacesContext.getCurrentInstance();
		Actividad actividad = context.getApplication().evaluateExpressionGet(context, "#{actividad}", Actividad.class);
		CRUD crud = new CRUD();
		crud.select_Actividades(nameActivity)
		
		
		
		
		
		
		
		
		
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("actividad", actividad);
		
		return"elegirActividades.xhtml";
	}
	
	public String asignarActividad() throws SQLException {
		// get the user values from the input form.
		FacesContext context = FacesContext.getCurrentInstance();
		Bloque bloque = context.getApplication().evaluateExpressionGet(context, "#{bloque}", Bloque.class);
		Actividad actividad = new Actividad();
		//actividad.setNombresA(crud.select_Bloque_actividad(bloque.getTematica()));
		
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("actividad", actividad);
		
		return"elegirActividades.xhtml";
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