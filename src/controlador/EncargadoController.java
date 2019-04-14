package controlador;
import javax.faces.bean.ManagedBean;

//@SuppressWarnings("deprecation")
@ManagedBean

public class EncargadoController {

	public EncargadoController() {
		
	}
	
	public String btnRegistro() {
		return"registro-Encargado.xhtml";
	}
	
}
