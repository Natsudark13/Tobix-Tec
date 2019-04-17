package beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import conexion.CRUD;
@ManagedBean
public class Comentario {
	private String descripcionComentario;
	
	public Comentario(String pDescripcionComentario){
		setDescripcionComentario(pDescripcionComentario);
	}

	public Comentario(){
		
	}
	
	public void registrarComentario(String pActivityName) throws SQLException {
		CRUD crud = new CRUD();
		crud.insertComments( pActivityName, descripcionComentario);
		
	}
	
	public ArrayList<String> verComentarios(String pActivityName) throws SQLException {
		CRUD crud = new CRUD();
		ArrayList<String> resultado = crud.select_Comments_Actividad(pActivityName);
		return resultado;
	}
	
	public String getDescripcionComentario() {
		return descripcionComentario;
	}

	public void setDescripcionComentario(String pDescripcionComentario) {
		this.descripcionComentario = pDescripcionComentario;
	}
}
