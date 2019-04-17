package beans;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import conexion.CRUD;
@ManagedBean 
public class Administrador extends Usuario{
	private String contrasenaAdministrador;

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
}
