package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import conexion.CRUD;

public class Actividad {
	private String nombreActividad;
	private String tipoActividad;
	private String fechaActividad;
	private String horaInicio;
	private String horaFinal;
	private String descripcionActividad;
	private ArrayList <Comentario> comentarios;
	private ArrayList <Usuario> encargados;
	
	/*public Actividad(String pNombreActividad, String pTipoActividad, Date pFechaActividad, String pHoraInicio, String pHoraFinal, String pDescripcionActividad){
		setNombreActividad(pNombreActividad);
		setTipoActividad(pTipoActividad);
		setFechaActividad(pFechaActividad);
		setHoraInicio(pHoraInicio);
		setHoraFinal(pHoraFinal);
		setDescripcionActividad(pDescripcionActividad);
		comentarios = new ArrayList<Comentario>();
	}*/
	
	public Actividad() {
		
	}
	
	public void registrarActividad() throws SQLException {
		CRUD crud = new CRUD();
		crud.insertActivity(tipoActividad, nombreActividad, fechaActividad, horaInicio, horaFinal, descripcionActividad);
	}
	
	public String registrarComentario(String pDescripcionComentario){
		Comentario comentario = new Comentario(pDescripcionComentario);
		comentarios.add(comentario);
		return "Comentario registrado";
	}
	
	public String registrarEncargado(Usuario pEncargado){
		encargados.add(pEncargado);
		return "Encargado registrado";
	}
	
	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public ArrayList<Usuario> getEncargados() {
		return encargados;
	}

	public void setEncargados(ArrayList<Usuario> encargados) {
		this.encargados = encargados;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}
	public void setNombreActividad(String pNombreActividad) {
		this.nombreActividad = pNombreActividad;
	}
	public String getTipoActividad() {
		return tipoActividad;
	}
	public void setTipoActividad(String pTipoActividad) {
		this.tipoActividad = pTipoActividad;
	}
	public String getFechaActividad() {
		return fechaActividad;
	}
	public void setFechaActividad(String pFechaActividad) {
		this.fechaActividad = pFechaActividad;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String pHoraInicio) {
		this.horaInicio = pHoraInicio;
	}
	public String getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(String pHoraFinal) {
		this.horaFinal = pHoraFinal;
	}
	public String getDescripcionActividad() {
		return descripcionActividad;
	}
	public void setDescripcionActividad(String pDescripcionActividad) {
		this.descripcionActividad = pDescripcionActividad;
	}
	
	
}
