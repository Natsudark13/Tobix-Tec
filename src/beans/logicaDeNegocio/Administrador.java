package beans.logicaDeNegocio;

public class Administrador extends Usuario{
	private String contrasenaAdministrador;
	
	public Administrador (String pCedula, String pNombre, String pPrimerApellido, String pSegundoApellido, String pSexo, String pCorreo, String pContrasena){
		super (pCedula, pNombre, pPrimerApellido, pSegundoApellido, pSexo, pCorreo);
		setContrasena(pContrasena);
	}

	public String getContrasenaAdministrador() {
		return contrasenaAdministrador;
	}

	public void setContrasena(String pContrasenaAdministrador) {
		this.contrasenaAdministrador = pContrasenaAdministrador;
	}
}
