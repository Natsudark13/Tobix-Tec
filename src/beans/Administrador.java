package beans;

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
	
	public Administrador obtenerAdministrador() {
		String [] datosAdministrador = {"901090654", "Brandon", "Carter", "Estrada", "Masculino", "brandon@gmail.com", "admin"};
		//metodo de select de la base
		Administrador administrador = new Administrador(datosAdministrador[0],datosAdministrador[1],datosAdministrador[2],datosAdministrador[3],datosAdministrador[4],datosAdministrador[5],datosAdministrador[6]);
		return administrador;
	}
}
