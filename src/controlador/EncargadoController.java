package controlador;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.Actividad;
import beans.Encargado;

//@SuppressWarnings("deprecation")
@ManagedBean

public class EncargadoController {

	
	public String btnRegistro() {
		return"registro-Encargado.xhtml";
	}
	
	public String registrarEncargacado() {
		// get the user values from the input form.
				FacesContext context = FacesContext.getCurrentInstance();
				Encargado encargado = context.getApplication().evaluateExpressionGet(context, "#{encargado}", Encargado.class);
				
				try {
					encargado.registrarEncargado();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
						
				// show the user data in console
				//System.out.println("look: "+administrador.getCorreo()+" "+administrador.getContrasenaAdministrador());
						
				// put the user object into the POST request 
				FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("encargado", encargado);
				
				return "principalAdministrador.xhtml";
	}
	
	
}
