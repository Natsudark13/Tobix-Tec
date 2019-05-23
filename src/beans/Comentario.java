package beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;

import conexion.CRUD;
@ManagedBean
public class Comentario {
	private String descripcionComentario;
	private DataModel<Comentario> comentarioModel;
	
	public Comentario(String pDescripcionComentario){
		setDescripcionComentario(pDescripcionComentario);
	}

	public Comentario(){
		
	}
	
	public void registrarComentario(String ActivityName) throws SQLException {
		CRUD crud = new CRUD();
		crud.insertComments( ActivityName, descripcionComentario);
		
	}
	
	public ArrayList<String> verComentarios(String ActivityName) throws SQLException {
		CRUD crud = new CRUD();
		ArrayList<String> resultado = crud.select_Comments_Actividad(ActivityName);
		return resultado;
	}
	
	public String getDescripcionComentario() {
		return descripcionComentario;
	}

	public void setDescripcionComentario(String pDescripcionComentario) {
		this.descripcionComentario = pDescripcionComentario;
	}
	
	public DataModel<Comentario> getComentarioModel() { 
		return comentarioModel; 
	}

	public void setComentarioModel(DataModel<Comentario> comentario) { 
		this.comentarioModel = comentario; 
	}
}
