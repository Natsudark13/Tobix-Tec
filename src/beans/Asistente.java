package beans;

import java.sql.SQLException;

//import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedBean;

import conexion.CRUD;


//@SuppressWarnings("deprecation")
@ManagedBean 
public class Asistente extends Usuario{
	private String contrasenaAsistente;
	private String entidadProcedencia;
	
	public Asistente() {
		super();
	}

	public int logIn(String email, String password) {
		CRUD crud = new CRUD();
		int x = 0;
		try {
			 x = crud.select_ExisteUsuario(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	

	public void crearAsistente() {
		CRUD crud = new CRUD();
		try {
			crud.insertUser(this.cedula, this.sexo, this.correo, this.nombre, this.primerApellido, this.segundoApellido, this.contrasenaAsistente, this.entidadProcedencia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getContrasenaAsistente() {
		return contrasenaAsistente;
	}

	public void setContrasenaAsistente(String contrasenaAsistente) {
		this.contrasenaAsistente = contrasenaAsistente;
	}

	public String getEntidadProcedencia() {
		return entidadProcedencia;
	}

	public void setEntidadProcedencia(String pEntidadProcedencia) {
		this.entidadProcedencia = pEntidadProcedencia;
	}
}
