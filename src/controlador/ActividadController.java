package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import beans.Actividad;
import beans.Asistente;
import beans.Bloque;
import beans.Encargado;
import beans.EnvioCorreo;
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
	
	public String asignarActividad() throws SQLException, AddressException, MessagingException {
		// get the user values from the input form.
		FacesContext context = FacesContext.getCurrentInstance();
		
		//Bloque bloque = context.getApplication().evaluateExpressionGet(context, "#{bloque}", Bloque.class);
		Actividad actividad = context.getApplication().evaluateExpressionGet(context, "#{actividad}", Actividad.class);
		Asistente asistente = context.getApplication().evaluateExpressionGet(context, "#{asistente}", Asistente.class);
		
		System.out.println("resultado ZXZ: "+actividad.getNombreActividad()+" "+asistente.getCorreo());
	    actividad.registrarActividad_Asistente(asistente.getCedula());
	    CRUD crud = new CRUD();
	    String correoR = crud.select_correo(asistente.getCedula());
	    
	   /* String[] pDetallesActividad = {actividad.getNombreActividad(),actividad.getFechaActividad(),actividad.getHoraInicio(),actividad.getHoraFinal(),actividad.getDescripcionActividad()};
	    
	    
	    
	    EnvioCorreo correo = new EnvioCorreo();
		correo.setMailServerProperties();
		correo.crearCorreoComprobante(correoR,pDetallesActividad);
		correo.enviarCorreo();
	    */
	    
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
	
	public String generarConsultaActividadesCantComentarios() {
		CRUD crud = new CRUD();
		FacesContext context = FacesContext.getCurrentInstance();
		int contador = 0;
		ArrayList<Actividad> actividades = new ArrayList<>();
		Actividad actividad = new Actividad();
		try {
			ArrayList<String> temp = actividad.listaActividadesPorComentarios();
			while (temp.size()>contador) {
				System.out.println(temp.get(contador));
				actividades.add(new Actividad(temp.get(contador),crud.select_Comments_Actividad(temp.get(contador)).size()));
				contador++;
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
		return "listadoActividadesCantComentarios.xhtml";
	}
	
	public String generarConsultaActividadesCantAsistentes() {
		CRUD crud = new CRUD();
		FacesContext context = FacesContext.getCurrentInstance();
		int contador = 0;
		ArrayList<Actividad> actividades = new ArrayList<>();
		Actividad actividad = new Actividad();
		try {
			ArrayList<String> temp = actividad.listaActividadesPorUsuarios();
			while (temp.size()>contador) {
				System.out.println(temp.get(contador));
				actividades.add(new Actividad(temp.get(contador), crud.select_IDUsuarios_Actividad(temp.get(contador)).size()));
				contador++;
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
		return "listadoActividadesCantUsuarios.xhtml";
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