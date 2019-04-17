package beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import conexion.CRUD;

@ManagedBean


public class Encargado extends Usuario {
	private int experiencia;
	private String institucionProcedencia;
	private ArrayList<Integer> listaID;

	public Encargado () {
		super();
		CRUD crud = new CRUD();
		try {
			this.listaID = crud.select_ID_Encargados();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void registrarEncargado() throws SQLException {
		CRUD crud = new CRUD();
		crud.insertSupervisor(this.cedula, this.sexo, this.correo, this.nombre, this.primerApellido, this.segundoApellido, this.experiencia, this.institucionProcedencia);
	}
	
		
	public ArrayList<Integer> getListaID() {
		return listaID;
	}

	public void setListaID(ArrayList<Integer> listaID) {
		this.listaID = listaID;
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
