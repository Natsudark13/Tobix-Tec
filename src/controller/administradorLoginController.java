package controller;
import beans.logicaDeNegocio.Administrador;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

//@SuppressWarnings("deprecation")
@ManagedBean
public class administradorLoginController {
	
	public String onSubmit(){
		
		// get the user values from the input form.
		FacesContext context = FacesContext.getCurrentInstance();
		Administrador administrador = context.getApplication().evaluateExpressionGet(context, "#{administrador}", Administrador.class);
	
		
		// show the user data in console
		//System.out.println("look: "+user.getFirstName()+" "+user.getLastName());
		
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("administrador", administrador);
		
		//Show the next page
		return "Response.xhtml";
	}

}
