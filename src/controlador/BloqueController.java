package controlador;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.Administrador;
import beans.Bloque;

//@SuppressWarnings("deprecation")
@ManagedBean
public class BloqueController {
	

	
	public String btnBloque(){
		
		//Show the next page
		return "registro-Bloque.xhtml";
	}
	
	public String registrarBloque(){
		
		// get the user values from the input form.
		FacesContext context = FacesContext.getCurrentInstance();
		Bloque bloque = context.getApplication().evaluateExpressionGet(context, "#{bloque}", Bloque.class);
		
		try {
			bloque.registrarBloque();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
				
		// show the user data in console
		//System.out.println("look: "+administrador.getCorreo()+" "+administrador.getContrasenaAdministrador());
				
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("bloque", bloque);
		
		return "principalAdministrador.xhtml";
	}
	

}
