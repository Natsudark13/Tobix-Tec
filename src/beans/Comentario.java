package beans;

import java.sql.SQLException;
import java.util.ArrayList;

import conexion.CRUD;

public class Comentario {
	private String descripcionComentario;
	
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
}
