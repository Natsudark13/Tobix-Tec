package beans;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.*;
//import javax.annotation.ManagedBean;

import conexion.CRUD;


//@SuppressWarnings("deprecation")
@ManagedBean  

public class Bloque {
	private String tematica;
	private String descripcionTematica;
	private String fechaBloque;
	private String franjaHoraria;
	private ArrayList <Actividad> actividades;
	private ArrayList<String> bloquesE;
	
	public Bloque() {
		CRUD crud = new CRUD();
		try {
			this.bloquesE = crud.select_Tipo_Bloque();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registrarBloque() throws SQLException {
		CRUD crud = new CRUD();
		crud.insertBlock(tematica, descripcionTematica, fechaBloque, franjaHoraria);
	}
	
	public String registrarActividad(Actividad pActividad){
		actividades.add(pActividad);
		return "Actividad registrada";
	}
	
	public String getBloquesIndex(int ndx_) {
		return bloquesE.get(ndx_);
	}
	
	public ArrayList<String> getBloquesE() {
		return bloquesE;
	}

	public void setBloquesE(ArrayList<String> bloquesE) {
		this.bloquesE = bloquesE;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String pTematica) {
		this.tematica = pTematica;
	}

	public String getDescripcionTematica() {
		return descripcionTematica;
	}

	public void setDescripcionTematica(String pDescripcionTematica) {
		this.descripcionTematica = pDescripcionTematica;
	}

	public String getFechaBloque() {
		return fechaBloque;
	}

	public void setFechaBloque(String pFechaBloque) {
		this.fechaBloque = pFechaBloque;
	}

	public String getFranjaHoraria() {
		return franjaHoraria;
	}

	public void setFranjaHoraria(String pFranjaHoraria) {
		this.franjaHoraria = pFranjaHoraria;
	}
}
