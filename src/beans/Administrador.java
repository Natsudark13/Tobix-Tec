package beans;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import conexion.CRUD;
@ManagedBean 
public class Administrador extends Usuario{
	private String contrasenaAdministrador;
	
	/*public Administrador (String pCedula, String pNombre, String pPrimerApellido, String pSegundoApellido, String pSexo, String pCorreo, String pContrasena){
		super (pCedula, pNombre, pPrimerApellido, pSegundoApellido, pSexo, pCorreo);
		setContrasenaAdministrador(pContrasena);
	}*/

	public Administrador () {
		super();
	}
	
	public String getContrasenaAdministrador() {
		return contrasenaAdministrador;
	}

	public void setContrasenaAdministrador(String pContrasenaAdministrador) {
		this.contrasenaAdministrador = pContrasenaAdministrador;
	}
	
	public int logIn(String email, String password) {
		CRUD crud = new CRUD();
		int x = 0;
		try {
			 x = crud.select_ExisteAdmin(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	/*public Administrador obtenerAdministrador() {
		String [] datosAdministrador = {"901090654", "Brandon", "Carter", "Estrada", "Masculino", "brandon@gmail.com", "admin"};
		//metodo de select de la base
		Administrador administrador = new Administrador(datosAdministrador[0],datosAdministrador[1],datosAdministrador[2],datosAdministrador[3],datosAdministrador[4],datosAdministrador[5],datosAdministrador[6]);
		return administrador;
	}*/
}
