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
	
	
	public Bloque() {
		
	}
	
	/*public Bloque(String pTematica, String pDescripcionTematica, Date pFechaBloque, String pFranjaHoraria){
		setTematica(pTematica);
		setDescripcionTematica(pDescripcionTematica);
		setFechaBloque(pFechaBloque);
		setFranjaHoraria(pFranjaHoraria);
	}*/
	
	public void registrarBloque() throws SQLException {
		CRUD crud = new CRUD();
		crud.insertBlock(tematica, descripcionTematica, fechaBloque, franjaHoraria);
	}
	
	public String registrarActividad(Actividad pActividad){
		actividades.add(pActividad);
		return "Actividad registrada";
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
