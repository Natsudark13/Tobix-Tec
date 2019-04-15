package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import beans.Actividad;
import beans.Asistente;
import beans.Bloque;
import beans.Encargado;
import conexion.CRUD;


//@SuppressWarnings("deprecation")
@ManagedBean

public class ActividadController {
	
	public void selectOneMenuListener(ValueChangeEvent event) {
	    //This will return you the newly selected
	    //value as an object. You'll have to cast it.
	    Object newValue = event.getNewValue(); 
	    //The rest of your processing logic goes here...
	}
	
	
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
		System.out.println("look: "+bloque.getTematica()+" "+actividad.getNombresA().get(0));
		
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("actividad", actividad);
		
		return"elegirActividad.xhtml?faces-redirect=false";
	}
	
	public String verActividad() throws SQLException {
		// get the user values from the input form.
		FacesContext context = FacesContext.getCurrentInstance();
		Actividad actividad = context.getApplication().evaluateExpressionGet(context, "#{actividad}", Actividad.class);
		System.out.println("resultado: "+actividad.getNombresA().get(0));
		
		//Set the atributes
		CRUD crud = new CRUD();
		ArrayList<String> temp = crud.select_Actividades(actividad.getNombreActividad());
		actividad.setTipoActividad(temp.get(0));
		actividad.setFechaActividad(temp.get(2));
		actividad.setHoraInicio(temp.get(3));
		actividad.setHoraFinal(temp.get(4));
		actividad.setDescripcionActividad(temp.get(5));
		System.out.println("resultado: "+actividad.getNombreActividad()+" "+actividad.getTipoActividad());
		
		
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("actividad", actividad);
		
		return"verActividad.xhtml";
	}
	
	public String asignarActividad() throws SQLException {
		// get the user values from the input form.
		FacesContext context = FacesContext.getCurrentInstance();
		
		//Bloque bloque = context.getApplication().evaluateExpressionGet(context, "#{bloque}", Bloque.class);
		Actividad actividad = context.getApplication().evaluateExpressionGet(context, "#{actividad}", Actividad.class);
		Asistente asistente = context.getApplication().evaluateExpressionGet(context, "#{asistente}", Asistente.class);
		
		System.out.println("resultado: "+actividad.getNombreActividad());
	    actividad.registrarActividad_Asistente(asistente.getCedula());
		
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("actividad", actividad);
		
		return"principalAsistente.xhtml";
	}
	
	public String registrarActividad(){
		
		// get the user values from the input form.
		FacesContext context = FacesContext.getCurrentInstance();
		Bloque bloque = context.getApplication().evaluateExpressionGet(context, "#{bloque}", Bloque.class);
		Actividad actividad = context.getApplication().evaluateExpressionGet(context, "#{actividad}", Actividad.class);
		Encargado encargado = context.getApplication().evaluateExpressionGet(context, "#{encargado}", Encargado.class);
		
		try {
			actividad.registrarActividad();
			actividad.registrarActividad_Bloque(bloque.getTematica());
			actividad.registrarActividad_Encargado(encargado.getCedula());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
					
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("actividad", actividad);
		
		return "principalAdministrador.xhtml";
	}
	
	public String generarConsultaActividades() {
		CRUD crud = new CRUD();
		FacesContext context = FacesContext.getCurrentInstance();
		int contador = 0;
		ArrayList<Actividad> actividades = new ArrayList<>();
		Actividad actividad = new Actividad();
		try {
			System.out.println("Entra al while");
			ArrayList<String> temp = crud.select_ALL_Actividades();
			System.out.println(temp.size());
			while (temp.size()>contador) {
				System.out.println(temp.get(contador));
				actividades.add(new Actividad(temp.get(contador),temp.get(contador+1), temp.get(contador+2), temp.get(contador+3), temp.get(contador+4), temp.get(contador+5)));
				contador+=6;
				System.out.println("actividades de tama: "+actividades.size());
				System.out.println("contador sale con: "+contador);
			}
		DataModel<Actividad> temp2 = new ListDataModel(actividades);
		actividad.setNombreActividadesModel(temp2);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("actividad", actividad);
		return "listadoActividades.xhtml";
	}
	
	public String registrarExtra(){
		
		// get the user values from the input form.
		FacesContext context = FacesContext.getCurrentInstance();
		Actividad actividad = context.getApplication().evaluateExpressionGet(context, "#{actividad}", Actividad.class);
		Encargado encargado = context.getApplication().evaluateExpressionGet(context, "#{encargado}", Encargado.class);
		
		try {
			actividad.registrarActividad_Encargado(encargado.getCedula());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
					
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("actividad", actividad);
		
		return "principalAdministrador.xhtml";
	}
}