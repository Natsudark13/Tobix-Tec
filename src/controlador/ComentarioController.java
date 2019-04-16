package controlador;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.Actividad;
import beans.Bloque;
import beans.Comentario;
import beans.Encargado;

@ManagedBean
public class ComentarioController {

	public String registrar() {
		// get the user values from the input form.
				FacesContext context = FacesContext.getCurrentInstance();
				Comentario comentario = context.getApplication().evaluateExpressionGet(context, "#{comentario}", Comentario.class);
				Actividad actividad = context.getApplication().evaluateExpressionGet(context, "#{actividad}", Actividad.class);
				
				try {
					comentario.registrarComentario(actividad.getNombreActividad());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
							
				// put the user object into the POST request 
				FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("comentario", comentario);
				
				return "principalAsistente.xhtml";
	}
	
	
}
