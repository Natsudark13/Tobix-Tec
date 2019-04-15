package beans;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import conexion.CRUD;

@ManagedBean


public class Encargado extends Usuario {
	private int experiencia;
	private String institucionProcedencia;
	
	
	/*public Encargado (String pCedula, String pNombre, String pPrimerApellido, String pSegundoApellido, String pSexo, String pCorreo, int pExperiencia, String pInstitucionProcedencia){
		super (pCedula, pNombre, pPrimerApellido, pSegundoApellido, pSexo, pCorreo);
		setExperiencia(pExperiencia);
		setInstitucionProcedencia(pInstitucionProcedencia);
	}*/

	public Encargado () {
		super();
		
	}

	public void registrarEncargado() throws SQLException {
		CRUD crud = new CRUD();
		crud.insertSupervisor(this.cedula, this.sexo, this.correo, this.nombre, this.primerApellido, this.segundoApellido, this.experiencia, this.institucionProcedencia);
	}
	
	
	public int getExperiencia() {
		return experiencia;
	}


	public void setExperiencia(int pExperiencia) {
		this.experiencia = pExperiencia;
	}


	public String getInstitucionProcedencia() {
		return institucionProcedencia;
	}


	public void setInstitucionProcedencia(String pInstitucionProcedencia) {
		this.institucionProcedencia = pInstitucionProcedencia;
	}
}
