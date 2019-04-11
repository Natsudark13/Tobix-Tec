package beans.logicaDeNegocio;
//import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedBean;


@SuppressWarnings("deprecation")
@ManagedBean 
public class Administrador extends Usuario{
	private String contrasenaAdministrador="contrasena";
	
	/**public Administrador (String pCedula, String pNombre, String pPrimerApellido, String pSegundoApellido, String pSexo, String pCorreo, String pContrasena){
		//super (pCedula, pNombre, pPrimerApellido, pSegundoApellido, pSexo, pCorreo);
		setContrasena(pContrasena);
	}**/
	
	public Administrador(){
		
	}
	
	

	public String getContrasenaAdministrador() {
		return contrasenaAdministrador;
	}

	public void setContrasena(String pContrasenaAdministrador) {
		this.contrasenaAdministrador = pContrasenaAdministrador;
	}
}
