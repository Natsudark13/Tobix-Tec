package beans.logicaDeNegocio;
import java.util.ArrayList;
import java.util.Date;

public class Bloque {
	private String tematica;
	private String descripcionTematica;
	private Date fechaBloque;
	private String franjaHoraria;
	private ArrayList <Actividad> actividades;
	
	public Bloque(String pTematica, String pDescripcionTematica, Date pFechaBloque, String pFranjaHoraria){
		setTematica(pTematica);
		setDescripcionTematica(pDescripcionTematica);
		setFechaBloque(pFechaBloque);
		setFranjaHoraria(pFranjaHoraria);
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

	public Date getFechaBloque() {
		return fechaBloque;
	}

	public void setFechaBloque(Date pFechaBloque) {
		this.fechaBloque = pFechaBloque;
	}

	public String getFranjaHoraria() {
		return franjaHoraria;
	}

	public void setFranjaHoraria(String pFranjaHoraria) {
		this.franjaHoraria = pFranjaHoraria;
	}
}
