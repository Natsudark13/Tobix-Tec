package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.Administrador;


//@SuppressWarnings("deprecation")
@ManagedBean

public class ActividadController {
	
	public String btnRegistro() {
		return"registro-Actividad.xhtml";
	}
	
	public String btnConsultas() {
		return"listadoActividad.xhtml";
	}
}