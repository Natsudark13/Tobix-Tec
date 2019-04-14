package controlador;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import beans.User;

//@SuppressWarnings("deprecation")
@ManagedBean
public class FormController {

	public String onSubmit(){
		
		// get the user values from the input form.
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
	
		
		// show the user data in console
		//System.out.println("look: "+user.getFirstName()+" "+user.getLastName());
		
		// put the user object into the POST request 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		//Show the next page
		return "Response.xhtml";
	}
}
